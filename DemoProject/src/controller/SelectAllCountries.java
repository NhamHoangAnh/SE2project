package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import dao.CountryDAO;
import model.Country;
@WebServlet("/AllCountries")
public class SelectAllCountries extends HttpServlet {
	
	private static final long seriralVersionUID = 1L;
	CountryDAO cd = new CountryDAO();
	ArrayList<Country> country = new ArrayList<Country>(); 
	
	public SelectAllCountries() {
		super();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		try {
		 	country = cd.selectAllCountries();
		 	
		}catch(IOException | SQLException | JSONException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("c", country);
		RequestDispatcher dispatcher = req.getRequestDispatcher("AllCountries.jsp");
		dispatcher.include(req, res);
		
	}
	
	
	
}
