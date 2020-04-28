package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.json.JSONException;
import org.json.JSONObject;

import connect.DBConnect;
import data.Fetch;

public class WorldDAO {
	private Connection conn;
	public WorldDAO() {
		conn = DBConnect.getConnection();
	}
	
	public void updateWorldStatistics() throws JSONException, IOException, SQLException {
		JSONObject world = Fetch.fetchWorldStatistics();
		String globalDate = Fetch.fetchDate();
		String updateWorld = " UPDATE World SET " + 
				"newConfirmed = ?" +
				", totalConfirmed = ?" +
				", newDeaths = ?" +
				", totalDeaths = ?" +
				", newRecovered = ?" +
				", totalRecovered =?" +
				", date = ?" +
				"WHERE wId = ?;";	
		double newConfirmed = world.getDouble("NewConfirmed");
		double totalConfirmed = world.getDouble("TotalConfirmed");
		double newDeaths = world.getDouble("NewDeaths");
		double totalDeaths = world.getDouble("TotalDeaths");
		double newRecovered = world.getDouble("NewRecovered");
		double totalRecovered = world.getDouble("TotalRecovered");
		String date = globalDate;
		PreparedStatement prepareStatement = conn.prepareStatement(updateWorld);
		prepareStatement.setDouble(1, newConfirmed);
		prepareStatement.setDouble(2, totalConfirmed);
		prepareStatement.setDouble(3, newDeaths);
		prepareStatement.setDouble(4, totalDeaths);
		prepareStatement.setDouble(5, newRecovered);
		prepareStatement.setDouble(6, totalRecovered);
		prepareStatement.setString(7, date);
		prepareStatement.setInt(8, 1);
		prepareStatement.executeUpdate();
	}
	
	public JSONObject selectWorldStatistics(){
		
		return null;	
	}
}
