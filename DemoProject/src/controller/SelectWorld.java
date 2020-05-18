package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.google.gson.Gson;
import dao.WorldDAO;
import dao.CountryDAO;
import model.World;
import model.Country;

@WebServlet("/homePage")
public class SelectWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private WorldDAO wD = new WorldDAO();
	private CountryDAO cD = new CountryDAO();
	private World world = new World();
	private Country c = new Country();
	
	public SelectWorld() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        
        try {
			getWorld(req, res);
			getVietNam(req, res);
			showHomePage(req,res);
		} catch (JSONException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        	// world as JSON
        
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	public void showHomePage(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("homePage.jsp");
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
		req.setAttribute("vn", c);	
	}
}
