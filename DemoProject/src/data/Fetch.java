package data;


import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.sql.SQLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class Fetch  {


	/**
	 *  Fetch Summary
	 */
	
//	public static  JSONObject fetchSummary() throws IOException, SQLException, JSONException {
//		URL url = new URL("https://api.covid19api.com/summary");
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setRequestMethod("GET");
//		connection.setRequestProperty("Accept", "application/json");
//		if (connection.getResponseCode() != 200) {
//		    throw new RuntimeException("Failed : HTTP error code : "
//		            + connection.getResponseCode());
//		}
//		InputStream in = new BufferedInputStream(
//			    (connection.getInputStream()));
//		
//		String output = convertToString(in);
//		JSONObject all = new JSONObject(output);
//		return all;
//	}
	
	/**
	 *  Fetch World Statistics
	 *  a JSON (Object) about world statistics
	 */
	
	public static  JSONObject fetchWorldStatistics() throws IOException, SQLException, JSONException {
		URL url = new URL("https://api.covid19api.com/summary");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
//		connection.setRequestProperty("Accept", "application/json");
		if (connection.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connection.getResponseCode());
		}
		InputStream in = new BufferedInputStream(
			    (connection.getInputStream()));
		
		String output = convertToString(in);
		JSONObject all = new JSONObject(output);
		JSONObject world = (JSONObject) all.get("Global");
		return world;
	}
	
	/**
	 *  Fetch all Countries Statistics (up to date)
	 *  an JSON Array about all Countries statistics
	 */
	
	public static  JSONArray fetchCountries() throws IOException, SQLException, JSONException {
		URL url = new URL("https://api.covid19api.com/summary");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
//		connection.setRequestProperty("Accept", "application/json");
		if (connection.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + connection.getResponseCode());
		}
		InputStream in = new BufferedInputStream(
			    (connection.getInputStream()));
		
		String output = convertToString(in);
		JSONObject all = new JSONObject(output);
		JSONArray countriesAry = all.getJSONArray("Countries");
		return countriesAry;
	}
	
	private static String convertToString(InputStream in) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	      StringBuilder sb = new StringBuilder();

	      String line;
	      try {
	         while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	        	 in.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	        
	      return sb.toString();
	  }
	
}
