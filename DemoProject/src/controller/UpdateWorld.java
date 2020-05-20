package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import dao.WorldDAO;

//@WebServlet("update-world")
public class UpdateWorld extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		WorldDAO wD = new WorldDAO();
		try {
			wD.updateWorldStatistics();
		} catch (JSONException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(req,res);
	}
	
}
