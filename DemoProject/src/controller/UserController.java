package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import controller.SelectAllCountries;

@WebServlet("/index")
public class UserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO uD = new UserDAO();
	
	
	public UserController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		
		
		try {
			showIndex(req, res);
			login(req,res);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		doGet(req,res);
	}
	
	public void showIndex(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, res);
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException, SQLException {
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		boolean authen = uD.login(userName, password);
		if (authen) {
			res.sendRedirect("AllCountries");
		} else {
			System.out.println("NO");
		}
	}
}
