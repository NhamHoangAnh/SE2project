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

import dao.VNProvincesDAO;
import model.VietNamProvinces;

@WebServlet("/guestProvince")
public class GuestProvince extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VNProvincesDAO vnpDAO = new VNProvincesDAO();
	private ArrayList<VietNamProvinces> allProvinces = new ArrayList<VietNamProvinces>();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			try {
				getProvinces(req, res);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		doGet(req,res);
	}
	
	public void getProvinces(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, ServletException, IOException {
		
		allProvinces = vnpDAO.selectAllProvinces();
		req.setAttribute("allProvinces", allProvinces);
		RequestDispatcher dispatcher = req.getRequestDispatcher("guestProvince.jsp");
		dispatcher.include(req, res);
	}
}
