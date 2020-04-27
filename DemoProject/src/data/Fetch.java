package data;


import java.util.List;

//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

import java.io.*;

import org.json.JSONException;
import org.json.JSONObject;
import java.sql.SQLException;
import java.net.*;

public class Fetch  {
//	private static WebTarget resource = ClientBuilder.newBuilder()
//            .build().target("https://api.randomuser.me/");
	
	
	public static  JSONObject retrieveWorldStatistic() throws IOException, SQLException, JSONException {
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
		
		return all;
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
