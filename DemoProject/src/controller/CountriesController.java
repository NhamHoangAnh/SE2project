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
public class CountriesController extends HttpServlet {
	
	private static final long seriralVersionUID = 1L;
	CountryDAO cd = new CountryDAO();
	ArrayList<Country> country = new ArrayList<Country>(); 
	Country aCountry = new Country();
	
	public CountriesController() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		
		doGet(req,res);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		try {
			if (req.getParameter("delId") != null) {
				deleteCountry(req, res);
			} else if(req.getParameter("editId") != null) {
				showEditForm(req, res);
				editCountry(req, res);
			} else if(req.getParameter("insert") != null) {
				showInsertForm(req,res);
				insertCountry(req,res);
				
			} else {
				listCountries(req,res);
			}
		} catch (JSONException | IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void listCountries(HttpServletRequest req, HttpServletResponse res) 
			throws JSONException, IOException, SQLException, ServletException {
		
		country = cd.selectAllCountries();
		req.setAttribute("c", country);
		RequestDispatcher dispatcher = req.getRequestDispatcher("AllCountries.jsp");
		dispatcher.include(req, res);
	}
	
	public void showEditForm(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, ServletException, IOException {
		
		String getCid = req.getParameter("editId");
		int cId = Integer.parseInt(getCid);
		aCountry = cd.getCountryById(cId);
		req.setAttribute("Country", aCountry);
		RequestDispatcher dispatcher = req.getRequestDispatcher("countryEditForm.jsp");
		dispatcher.include(req, res);
		
	}
	
	public void editCountry(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, IOException {
		
		int cId = Integer.parseInt(req.getParameter("eCId"));
		String country = req.getParameter("eCountry");
		double newConfirmed = Double.parseDouble(req.getParameter("eNewConfirmed"));
		double totalConfirmed = Double.parseDouble(req.getParameter("eTotalConfirmed"));
		double newDeaths = Double.parseDouble(req.getParameter("eNewDeaths"));
		double totalDeaths = Double.parseDouble(req.getParameter("eTotalDeaths"));
		double newRecovered = Double.parseDouble(req.getParameter("eNewRecovered"));
		double totalRecovered = Double.parseDouble(req.getParameter("eTotalRecovered"));
		String date = req.getParameter("eDate");
		String countryCode = req.getParameter("eCountryCode");
		Country changedCountry = new Country(cId, country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		cd.editCountry(changedCountry);
		res.sendRedirect("AllCountries");
		return;
	}
	
	public void showInsertForm(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("countryInsertForm.jsp");
		dispatcher.include(req, res);
	}
	
	public void insertCountry(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, IOException {
		
		String country = req.getParameter("iCountry");
		double newConfirmed = Double.parseDouble(req.getParameter("iNewConfirmed"));
		double totalConfirmed = Double.parseDouble(req.getParameter("iTotalConfirmed"));
		double newDeaths = Double.parseDouble(req.getParameter("iNewDeaths"));
		double totalDeaths = Double.parseDouble(req.getParameter("iTotalDeaths"));
		double newRecovered = Double.parseDouble(req.getParameter("iNewRecovered"));
		double totalRecovered = Double.parseDouble(req.getParameter("iTotalRecovered"));
		String date = req.getParameter("iDate");
		String countryCode = req.getParameter("iCountryCode");
		Country brandNewCountry = new Country(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		cd.insertCountry(brandNewCountry);
		res.sendRedirect("AllCountries");
		return;
		
	}
	
	public void deleteCountry(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		String getCId = req.getParameter("delId");
		int cId = Integer.parseInt(getCId);
		System.out.println("get delId: " + cId);
		cd.deleteCountry(cId);
		res.sendRedirect("AllCountries");
	}
	
	 
	
	
	
}
