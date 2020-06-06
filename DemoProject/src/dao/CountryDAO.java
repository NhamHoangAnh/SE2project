package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import connect.DBConnect;
import data.Fetch;
import model.Country;
import helper.DateTransform;

public class CountryDAO {
	private Connection conn;
	public CountryDAO() {
		conn = DBConnect.getConnection();
	}
	public void updateCountries() throws IOException, SQLException, JSONException  {
		JSONArray countries = Fetch.fetchCountries();
//		String globalDate = Fetch.fetchDate();
		
		String updateCountries = " UPDATE Countries SET " + 
				"country = ?" +
				", newConfirmed = ?" +
				", totalConfirmed = ?" +
				", newDeaths = ?" +
				", totalDeaths = ?" +
				", newRecovered = ?" +
				", totalRecovered =?" +
				", date = ?" +
				", countryCode = ?" +
				"WHERE cId = ?;";
		int i = 0;
		while(i < countries.length()) {
			JSONObject o = countries.getJSONObject(i);
			String country = o.getString("Country");
			double newConfirmed = o.getDouble("NewConfirmed");
			double totalConfirmed = o.getDouble("TotalConfirmed");
			double newDeaths = o.getDouble("NewDeaths");
			double totalDeaths = o.getDouble("TotalDeaths");
			double newRecovered = o.getDouble("NewRecovered");
			double totalRecovered = o.getDouble("TotalRecovered");
			String date = o.getString("Date"); 
			String countryCode = o.getString("CountryCode");
			
			PreparedStatement preparedStatement = conn.prepareStatement(updateCountries);
			preparedStatement.setString(1, country);
			preparedStatement.setDouble(2, newConfirmed);
			preparedStatement.setDouble(3, totalConfirmed);
			preparedStatement.setDouble(4, newDeaths);
			preparedStatement.setDouble(5, totalDeaths);
			preparedStatement.setDouble(6, newRecovered);
			preparedStatement.setDouble(7, totalRecovered);
			preparedStatement.setString(8, date);
			preparedStatement.setString(9, countryCode);
			preparedStatement.setInt(10, i+1);
			preparedStatement.executeUpdate();
			i++;
		}
	}
	
	public ArrayList<Country> selectAllCountries() throws IOException, SQLException, JSONException{
		//System.out.println(java.time.LocalDate.now()); 
		
		String lastDate = null;
		
		String getLastDate = "Select date from Countries";
		PreparedStatement statement = conn.prepareStatement(getLastDate);
		ResultSet result = statement.executeQuery();
		if (result.next() == true) {
			lastDate = DateTransform.dateFormat(result.getString("date"));
		}
		Date d = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		String currentDate= formatter.format(d);
		if (lastDate.equals(currentDate)) {
			try {
				updateCountries();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<Country> countriesList = new ArrayList<Country>();
		String selectCoutries = "SELECT * FROM Countries";
		PreparedStatement preparedStatement = conn.prepareStatement(selectCoutries);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			int cId = rs.getInt("cId");
			String country = rs.getString("country");
			double newConfirmed = rs.getDouble("newConfirmed");
			double totalConfirmed = rs.getDouble("totalConfirmed");
			double newDeaths = rs.getDouble("newDeaths");
			double totalDeaths = rs.getDouble("totalDeaths");
			double newRecovered = rs.getDouble("newRecovered");
			double totalRecovered = rs.getDouble("totalRecovered");
			String date = rs.getString("date");
			String countryCode = rs.getString("countryCode");
			
			countriesList.add(new Country(cId, country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date,countryCode));
		}
		
		return countriesList;
	}
	
	public Country selectCountry(String countryName) throws IOException, SQLException, JSONException{
		Country c = new Country();
		String selectCountry = "SELECT * FROM countries where country = " + "\"" + countryName + "\"";
		PreparedStatement preparedStatement = conn.prepareStatement(selectCountry);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
//			int cId = rs.getInt("cId");
			String country = rs.getString("country");
			double newConfirmed = rs.getDouble("newConfirmed");
			double totalConfirmed = rs.getDouble("totalConfirmed");
			double newDeaths = rs.getDouble("newDeaths");
			double totalDeaths = rs.getDouble("totalDeaths");
			double newRecovered = rs.getDouble("newRecovered");
			double totalRecovered = rs.getDouble("totalRecovered");
			String date = rs.getString("date");
			String countryCode = rs.getString("countryCode");
			
			c.setCountry(country);
			c.setNewConfirmed(newConfirmed);
			c.setTotalConfirmed(totalConfirmed);
			c.setNewDeaths(newDeaths);
			c.setTotalDeaths(totalDeaths);
			c.setNewRecovered(newRecovered);
			c.setTotalRecovered(totalRecovered);
			c.setDate(date);
			c.setCountryCode(countryCode);
		}
		return c;
	}
	
	public Country selectVietNam() throws IOException, SQLException, JSONException{
		Country vn = new Country();
		String selectVietNam = "SELECT * FROM countries where country = " + "\"" + "VietNam" + "\"";
		PreparedStatement preparedStatement = conn.prepareStatement(selectVietNam);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			String country = rs.getString("country");
			double newConfirmed = rs.getDouble("newConfirmed");
			double totalConfirmed = rs.getDouble("totalConfirmed");
			double newDeaths = rs.getDouble("newDeaths");
			double totalDeaths = rs.getDouble("totalDeaths");
			double newRecovered = rs.getDouble("newRecovered");
			double totalRecovered = rs.getDouble("totalRecovered");
			String date = rs.getString("date");
			String countryCode = rs.getString("countryCode");
			
			vn.setCountry(country);
			vn.setNewConfirmed(newConfirmed);
			vn.setTotalConfirmed(totalConfirmed);
			vn.setNewDeaths(newDeaths);
			vn.setTotalDeaths(totalDeaths);
			vn.setNewRecovered(newRecovered);
			vn.setTotalRecovered(totalRecovered);
			vn.setDate(date);
			vn.setCountryCode(countryCode);
		}
		return vn;
	}
	
	public void insertCountries() throws IOException, SQLException  {
		JSONArray countries = Fetch.fetchCountries();
//		String globalDate = Fetch.fetchDate();
		
		String updateCountries = " INSERT INTO Countries(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode) VALUES " + 
				"(country = ?" +
				", newConfirmed = ?" +
				", totalConfirmed = ?" +
				", newDeaths = ?" +
				", totalDeaths = ?" +
				", newRecovered = ?" +
				", totalRecovered =?" +
				", date = ?" +
				", countryCode = ?);"
				;
		int i = 0;
		while(i < countries.length()) {
			JSONObject o = countries.getJSONObject(i);
			String country = o.getString("Country");
			double newConfirmed = o.getDouble("NewConfirmed");
			double totalConfirmed = o.getDouble("TotalConfirmed");
			double newDeaths = o.getDouble("NewDeaths");
			double totalDeaths = o.getDouble("TotalDeaths");
			double newRecovered = o.getDouble("NewRecovered");
			double totalRecovered = o.getDouble("TotalRecovered");
			String date = o.getString("Date"); 
			String countryCode = o.getString("CountryCode");
			
			PreparedStatement preparedStatement = conn.prepareStatement(updateCountries);
			preparedStatement.setString(1, country);
			preparedStatement.setDouble(2, newConfirmed);
			preparedStatement.setDouble(3, totalConfirmed);
			preparedStatement.setDouble(4, newDeaths);
			preparedStatement.setDouble(5, totalDeaths);
			preparedStatement.setDouble(6, newRecovered);
			preparedStatement.setDouble(7, totalRecovered);
			preparedStatement.setString(8, date);
			preparedStatement.setString(9, countryCode);
//			preparedStatement.setInt(10, i+1);
			preparedStatement.executeUpdate();
			i++;
		}
	}
	
	public Country getCountryById(int id) throws SQLException {
		
		Country c = null;
		
		String getCountryById = "SELECT * FROM COUNTRIES WHERE cID =?";
		PreparedStatement pstmt = conn.prepareStatement(getCountryById);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int cId = rs.getInt("cId");
			String country = rs.getString("country");
			double newConfirmed = rs.getDouble("newConfirmed");
			double totalConfirmed = rs.getDouble("totalConfirmed");
			double newDeaths = rs.getDouble("newDeaths");
			double totalDeaths = rs.getDouble("totalDeaths");
			double newRecovered = rs.getDouble("newRecovered");
			double totalRecovered = rs.getDouble("totalRecovered");
			String date = rs.getString("date");
			String countryCode = rs.getString("countryCode");
			c = new Country(cId, country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		}
		
		return c; 
	}
	
	public void editCountry(Country c) throws SQLException {
		
		String editCountry = "UPDATE COUNTRIES SET "
				+ "country =?, newConfirmed =?, "
				+ "totalConfirmed =?, newDeaths =?, "
				+ "totalDeaths =?, newRecovered =?, "
				+ "totalRecovered =?, date =?,"
				+ "countryCode =? WHERE cId =?";
		PreparedStatement pstmt = conn.prepareStatement(editCountry);
		int cId = c.getcId();
		String country = c.getCountry();
		double newConfirmed = c.getNewConfirmed();
		double totalConfirmed = c.getTotalConfirmed();
		double newDeaths = c.getNewDeaths();
		double totalDeaths = c.getTotalDeaths();
		double newRecovered = c.getNewRecovered();
		double totalRecovered = c.getTotalRecovered();
		String date = c.getDate();
		String countryCode = c.getCountryCode();
		pstmt.setString(1, country);
		pstmt.setDouble(2, newConfirmed);
		pstmt.setDouble(3, totalConfirmed);
		pstmt.setDouble(4, newDeaths);
		pstmt.setDouble(5, totalDeaths);
		pstmt.setDouble(6, newRecovered);
		pstmt.setDouble(7, totalRecovered);
		pstmt.setString(8, date);
		pstmt.setString(9, countryCode);
		pstmt.setInt(10, cId);
		pstmt.execute();
		
	}
	
	public void insertCountry(Country c) throws SQLException {
		String insertCountry = "INSERT INTO COUNTRIES(country, newConfirmed, "
				+ "totalConfirmed, newDeaths, "
				+ "totalDeaths, newRecovered, "
				+ "totalRecovered, date, "
				+ "countryCode) VALUES(?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(insertCountry);
		String country = c.getCountry();
		double newConfirmed = c.getNewConfirmed();
		double totalConfirmed = c.getTotalConfirmed();
		double newDeaths = c.getNewDeaths();
		double totalDeaths = c.getTotalDeaths();
		double newRecovered = c.getNewRecovered();
		double totalRecovered = c.getTotalRecovered();
		String date = c.getDate();
		String countryCode = c.getCountryCode();
		pstmt.setString(1, country);
		pstmt.setDouble(2, newConfirmed);
		pstmt.setDouble(3, totalConfirmed);
		pstmt.setDouble(4, newDeaths);
		pstmt.setDouble(5, totalDeaths);
		pstmt.setDouble(6, newRecovered);
		pstmt.setDouble(7, totalRecovered);
		pstmt.setString(8, date);
		pstmt.setString(9, countryCode);
		pstmt.execute();
		
	}
	
	public void deleteCountry(int id) throws SQLException {
		
		String deleteCountry = "DELETE FROM COUNTRIES WHERE cId = ?";
		PreparedStatement pstmt = conn.prepareStatement(deleteCountry);
		pstmt.setInt(1, id);
		pstmt.execute();
		
	}
}
