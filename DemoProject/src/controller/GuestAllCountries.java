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

@WebServlet("/guestAllCountries")
public class GuestAllCountries extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CountryDAO cD = new CountryDAO();
	ArrayList<Country> countries = new ArrayList<Country>(); 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		try {
			getAllCountries(req ,res);
		} catch (JSONException | IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		doGet(req, res);
	}
	
	public void getAllCountries(HttpServletRequest req, HttpServletResponse res) 
			throws JSONException, IOException, SQLException, ServletException {
		
		countries = cD.selectAllCountries();
		req.setAttribute("c", countries);
		RequestDispatcher dispatcher = req.getRequestDispatcher("guestAllCountries.jsp");
		dispatcher.include(req, res);
	}
}
