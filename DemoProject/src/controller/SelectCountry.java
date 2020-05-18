package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import dao.CountryDAO;
import model.Country;
@WebServlet("/Country")
public class SelectCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryDAO cd = new CountryDAO();
	private Country c = new Country();

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		String countryName = req.getParameter("countryName");
		try {
			c = cd.selectCountry(countryName);
		} catch (IOException | SQLException | JSONException e) {
			e.printStackTrace();
		}
		req.setAttribute("c", c);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Country.jsp");
		dispatcher.include(req, res);
	}

}
