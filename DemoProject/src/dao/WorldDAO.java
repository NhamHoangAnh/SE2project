package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
	
	public void updateWorldStatistics() throws JSONException, IOException, SQLException  {
		JSONObject world = Fetch.fetchWorldStatistics();
		String globalDate = Fetch.fetchDate();
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM WORLD ORDER BY wId DESC LIMIT 1");
		ResultSet r = pstmt.executeQuery();
		r.next();
		String dateBefore = dateFormat(r.getString("date"));
		String currentDate = dateFormat(globalDate);
				 
		if (!dateBefore.equals(currentDate)) {
			String updateWorld = " INSERT INTO World("
					+ "newConfirmed,totalConfirmed,"
					+ "newDeaths,totalDeaths,"
					+ "newRecovered,totalRecovered,"
					+ "date) "
					+ "VALUES(?,?,?,?,?,?,?);";
			double newConfirmed = world.getDouble("NewConfirmed");
			double totalConfirmed = world.getDouble("TotalConfirmed");
			double newDeaths = world.getDouble("NewDeaths");
			double totalDeaths = world.getDouble("TotalDeaths");
			double newRecovered = world.getDouble("NewRecovered");
			double totalRecovered = world.getDouble("TotalRecovered");
			PreparedStatement preparedStatement = conn.prepareStatement(updateWorld);
			preparedStatement.setDouble(1, newConfirmed);
			preparedStatement.setDouble(2, totalConfirmed);
			preparedStatement.setDouble(3, newDeaths);
			preparedStatement.setDouble(4, totalDeaths);
			preparedStatement.setDouble(5, newRecovered);
			preparedStatement.setDouble(6, totalRecovered);
			preparedStatement.setString(7, globalDate);
			preparedStatement.executeUpdate();
		}
	}
	
	public World selectWorldStatistics() throws SQLException, JSONException, IOException{
		
		String globalDate = Fetch.fetchDate();
		World w = new World();
		String selectWorld = "SELECT * FROM WORLD ORDER BY wId DESC LIMIT 1";
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
	
	public static String dateFormat(String d) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(d, inputFormatter);
		String formattedDate = outputFormatter.format(date);
		return formattedDate;
	}
	
	public static void main(String args[]) throws SQLException, IOException {
		try {
			
			String globalDate = Fetch.fetchDate();
			
			//String globalDate = Fetch.fetchDate();
			Connection connect = DBConnect.getConnection();
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM WORLD ORDER BY wId DESC LIMIT 1");
			//ps.setString(1, "2020-04-29T15:28:20Z");
			
			ResultSet r = ps.executeQuery();
			r.next();
			String dateBefore = dateFormat(r.getString("date"));
			String currentDate = dateFormat(globalDate);
			System.out.println(dateBefore);
			System.out.println(currentDate);
			
		} catch (JSONException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
