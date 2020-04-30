package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import connect.DBConnect;
import data.Fetch;
import model.Country;

public class CountryDAO {
	private Connection conn;
	public CountryDAO() {
		conn = DBConnect.getConnection();
	}
	public void updateCountries() throws IOException, SQLException, JSONException  {
		JSONArray countries = Fetch.fetchCountries();
//		String globalDate = Fetch.fetchDate();
		
		String updateCountries = "UPDATE Countries SET " + 
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
		
		for( int i = 0; i < countries.length(); i++) {
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
			
		}
	}
	
	public ArrayList<Country> selectAllCountries() throws IOException, SQLException, JSONException{
		ArrayList<Country> countriesList = new ArrayList<Country>();
		String selectCoutries = "SELECT * FROM Country";
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
		String selectCountry = "SELECT * FROM Countries WHERE country = "+ countryName + "  ";
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
		String selectVietNam = "SELECT * FROM Countries WHERE country = "+ "VietNam" + "  ";
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
	
	public static void main(String arg[]) throws IOException, SQLException, JSONException {
		CountryDAO c = new CountryDAO();
		c.updateCountries();
		JSONArray countries = Fetch.fetchCountries();
		
//		JSONObject o = countries.getJSONObject(2);
//		System.out.println(o);
	}
}