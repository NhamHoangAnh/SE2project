package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import data.Fetch;
import java.sql.SQLException;
import org.json.JSONException;
//import com.google.gson.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DataServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType(" application/json");
		JSONObject data = null;
		
		PrintWriter pw = res.getWriter();
		pw.print("Something");
		pw.close();
		
	}
	
}
