package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import dao.CountryDAO;
public class UpdateCountries extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CountryDAO cd = new CountryDAO();
		try {
			cd.updateCountries();
		}catch(IOException | SQLException | JSONException e){
			e.printStackTrace();
		}
	}
}
