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
import dao.WorldDAO;
import model.Country;
import model.World;

@WebServlet("/guestHomePage")
public class GuestController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorldDAO wD = new WorldDAO();
	private CountryDAO cD = new CountryDAO();
	private World world = new World();
	private Country c = new Country();
	
	public GuestController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		try {
			showGuestHomePage(req, res);
			getWorld(req, res);
			getVietNam(req, res);
		} catch (ServletException | IOException | JSONException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		doGet(req,res);
	}
	
	public void showGuestHomePage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("guestHomePage.jsp");
        dispatcher.include(req, res);
	}
	
	public void getWorld(HttpServletRequest req, HttpServletResponse res) 
			throws JSONException, SQLException, IOException, ServletException {
		
		world = wD.selectWorldStatistics();
		req.setAttribute("world", world);       
	}
	
	public void getVietNam(HttpServletRequest req, HttpServletResponse res) 
			throws JSONException, IOException, SQLException {
		
		c = cD.selectVietNam();
		System.out.println(c.getCountry());
		req.setAttribute("vn", c);	
	}
}
