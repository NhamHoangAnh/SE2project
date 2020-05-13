package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
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
	private String globalDate;
	final String url = "https://ncov.moh.gov.vn/";
	
	public VNProvincesDAO() {
		conn = DBConnect.getConnection();
		try {
			globalDate = Fetch.fetchDate();
		} catch (JSONException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProvinces() throws SQLException, IOException {
		
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
	
	public void editProvince(VietNamProvinces p) throws SQLException {
		String editProvince = "UPDATE VietNamProvinces SET "
				+ "name = ?, "
				+ "confirmed =?, deaths =?, "
				+ "recovered = ?, underTreatment=?, "
				+ "date=? WHERE pId = ? ";
		PreparedStatement pstmt = conn.prepareStatement(editProvince);
		int pId = p.getpId();
		String name = p.getName();
		double confirmed = p.getConfirmed();
		double deaths = p.getDeaths();
		double recovered = p.getRecovered();
		double underTreatment = p.getUnderTreatment();
		String date = p.getDate();
		pstmt.setString(1, name);
		pstmt.setDouble(2, confirmed);
		pstmt.setDouble(3, deaths);
		pstmt.setDouble(4, recovered);
		pstmt.setDouble(5, underTreatment);
		pstmt.setString(6, date);
		pstmt.setInt(7, pId);
		pstmt.execute();
		
	}
	
	public void deleteProvince(int id) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM VietnamProvinces WHERE pId = ?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	
	
	public ArrayList<VietNamProvinces> selectAllProvinces() throws SQLException {
		ArrayList<VietNamProvinces> allProvinces = new ArrayList<VietNamProvinces>();
		String selectProvinces = "SELECT * FROM VietnamProvinces";
		PreparedStatement pstmt = conn.prepareStatement(selectProvinces);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int pId = rs.getInt("pId");
			String name = rs.getString("name");
			double confirmed = rs.getDouble("confirmed");
			double deaths = rs.getDouble("deaths");
			double recovered = rs.getDouble("recovered");
			double underTreatment = rs.getDouble("underTreatment");
			String date = rs.getString("date");
			VietNamProvinces vnp = new VietNamProvinces(pId, name, confirmed,deaths,recovered,underTreatment, date);
			allProvinces.add(vnp);
		}
		return allProvinces;
	}
	
	
	public static void main(String args[]) throws IOException, SQLException {
		
//		Connection conn = DBConnect.getConnection();
//		
//		String selectProvinces = "SELECT * FROM VietnamProvinces";
//		PreparedStatement pstmt = conn.prepareStatement(selectProvinces);
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getString("name"));
//		}
		
		String date = Fetch.fetchDate();
		
		
		VNProvincesDAO vnpDAO = new VNProvincesDAO();
		
		
//		VietNamProvinces p = new VietNamProvinces(4, "Bạc Liêu" , 24, 0, 3, 19, date);
//		vnpDAO.editProvince(p);
		
	}
	
}
