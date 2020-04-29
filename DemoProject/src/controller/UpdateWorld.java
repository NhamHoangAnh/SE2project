package controller;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;

import dao.WorldDAO;

public class UpdateWorld {
	public static void main(String args[]) {
		WorldDAO wD = new WorldDAO();
		try {
			wD.updateWorldStatistics();
		} catch (JSONException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
