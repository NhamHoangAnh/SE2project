package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import connect.DBConnect;
import data.Fetch;
import helper.SSLHelper;
import model.VietNamProvinces;
import helper.DT;

public class VNProvincesDAO {
	
	private Connection conn;
	final String url = "https://ncov.moh.gov.vn/";
	
	public VNProvincesDAO() {
		conn = DBConnect.getConnection();
	}
	
	public void updateProvinces() throws SQLException, IOException {
		
		String globalDate = Fetch.fetchDate();
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM VietnamProvinces");
		ResultSet r = pstmt.executeQuery();
		if(!r.next()) {
			String insertProvinces = " INSERT INTO VietnamProvinces("
					+ "name,confirmed,"
					+ "deaths,recovered,"
					+ "underTreatment,"
					+ "date) "
					+ "VALUES(?,?,?,?,?,?);";
			Document doc = SSLHelper.getConnection(url).userAgent("HTTPS").get();
			Element firstTable = doc.select("table.table-striped.table-covid19").get(0);
			for (Element row: firstTable.select("tr") ) {
				String name = row.select("td:nth-of-type(1)").text();
				double confirmed = DT.ParseDouble(row.select("td:nth-of-type(2)").text());
				double deaths = DT.ParseDouble(row.select("td:nth-of-type(5)").text());
				double recovered = DT.ParseDouble(row.select("td:nth-of-type(4)").text());
				double underTreatment = DT.ParseDouble(row.select("td:nth-of-type(3)").text());
				PreparedStatement preparedStatement = conn.prepareStatement(insertProvinces);
				preparedStatement.setString(1, name);
				preparedStatement.setDouble(2, confirmed);
				preparedStatement.setDouble(3, deaths);
				preparedStatement.setDouble(4, recovered);
				preparedStatement.setDouble(5, underTreatment);
				preparedStatement.setString(6, globalDate);
				preparedStatement.execute();
			}
		} else {
			String updateProvinces = "UPDATE VietnamProvinces SET "
					+ "name = ?, confirmed = ?, "
					+ "deaths = ?,recovered =?, "
					+ "underTreatment =?, "
					+ "date =?"
					+ "WHERE pId = ?;";
			Document doc = SSLHelper.getConnection(url).userAgent("HTTPS").get();
			Element firstTable = doc.select("table.table-striped.table-covid19").get(0);
			int pId = 1;
			for (Element row: firstTable.select("tr") ) {
				String name = row.select("td:nth-of-type(1)").text();
				double confirmed = DT.ParseDouble(row.select("td:nth-of-type(2)").text());
				double deaths = DT.ParseDouble(row.select("td:nth-of-type(5)").text());
				double recovered = DT.ParseDouble(row.select("td:nth-of-type(4)").text());
				double underTreatment = DT.ParseDouble(row.select("td:nth-of-type(3)").text());
				PreparedStatement preparedStatement = conn.prepareStatement(updateProvinces);
				preparedStatement.setString(1, name);
				preparedStatement.setDouble(2, confirmed);
				preparedStatement.setDouble(3, deaths);
				preparedStatement.setDouble(4, recovered);
				preparedStatement.setDouble(5, underTreatment);
				preparedStatement.setString(6, globalDate);
				preparedStatement.setInt(7, pId);
				pId++;
				preparedStatement.execute();
			}
		}
	}
	
	public ArrayList<VietNamProvinces> selectAllProvinces() throws SQLException {
		ArrayList<VietNamProvinces> allProvinces = new ArrayList<VietNamProvinces>();
		String selectProvinces = "SELECT * FROM VietnamProvinces";
		PreparedStatement pstmt = conn.prepareStatement(selectProvinces);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int pId = rs.getInt("pId");
			String name = rs.getString("name");
			int confirmed = rs.getInt("confirmed");
			int deaths = rs.getInt("deaths");
			int recovered = rs.getInt("underTreatment");
			String date = rs.getString("date");
			allProvinces.add(new VietNamProvinces(name, confirmed,deaths,recovered, date));
		}
		return allProvinces;
	}
	
	public static void main(String args[]) throws IOException, SQLException {
		Document doc = SSLHelper.getConnection("https://ncov.moh.gov.vn/").userAgent("HTTPS").get();
		Element firstTable = doc.select("table.table-striped.table-covid19").get(0);
		
		for (Element row: firstTable.select("tr") ) {
			//System.out.println(DT.ParseDouble((row.select("td:nth-of-type(2)").text())));
		}
		
		VNProvincesDAO vnpDAO = new VNProvincesDAO();
		vnpDAO.updateProvinces();
		System.out.println(vnpDAO.selectAllProvinces());;
		
	}
	
}
