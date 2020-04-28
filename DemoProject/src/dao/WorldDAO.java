package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONException;
import org.json.JSONObject;

import connect.DBConnect;
import data.Fetch;
import model.World;

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
		PreparedStatement preparedStatement = conn.prepareStatement(updateWorld);
		preparedStatement.setDouble(1, newConfirmed);
		preparedStatement.setDouble(2, totalConfirmed);
		preparedStatement.setDouble(3, newDeaths);
		preparedStatement.setDouble(4, totalDeaths);
		preparedStatement.setDouble(5, newRecovered);
		preparedStatement.setDouble(6, totalRecovered);
		preparedStatement.setString(7, date);
		preparedStatement.setInt(8, 1);
		preparedStatement.executeUpdate();
	}
	
	public World selectWorldStatistics() throws SQLException, JSONException, IOException{
		
		String globalDate = Fetch.fetchDate();
		World w = new World();
		String selectWorld = "SELECT * FROM World WHERE date = '" + globalDate + "';";
		PreparedStatement preparedStatement = conn.prepareStatement(selectWorld);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			double newConfirmed = rs.getDouble("newConfirmed");
			double totalConfirmed = rs.getDouble("totalConfirmed");
			double newDeaths = rs.getDouble("newDeaths");
			double totalDeaths = rs.getDouble("totalDeaths");
			double newRecovered = rs.getDouble("newRecovered");
			double totalRecovered = rs.getDouble("totalRecovered");
			w.setNewConfirmed(newConfirmed);
			w.setTotalConfirmed(totalConfirmed);
			w.setNewDeaths(newDeaths);
			w.setTotalDeaths(totalDeaths);
			w.setNewRecovered(newRecovered);
			w.setTotalRecovered(totalRecovered);
			w.setDate(globalDate);
		}
		return w;	
	}
	
	public static void main(String args[]) {
		try {
			String globalDate = Fetch.fetchDate();
			System.out.println(globalDate);
		} catch (JSONException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
