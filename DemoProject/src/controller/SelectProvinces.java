package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.VNProvincesDAO;
import model.VietNamProvinces;

@WebServlet("/provinces")
public class SelectProvinces extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private VNProvincesDAO vnpDAO = new VNProvincesDAO();
	private ArrayList<VietNamProvinces> allProvinces = new ArrayList<VietNamProvinces>();
	
	
	public SelectProvinces() {
		super();
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		
		doGet(req,res);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {	
		res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        String action = req.getServletPath();
        
        String path = req.getRequestURI().substring(req.getContextPath().length());
        //System.out.println(path);
        System.out.println(action);
        try {
//        	switch(action) {
//        	case "/delete": 
//        		deleteProvince(req,res);
//        		break;
//        	default:
//        		listProvinces(req,res);
//        		break;
//        	}
        	if (req.getParameter("delId") != null) {
        		System.out.println("Calling delete with id of: " + req.getParameter("delId"));
        		deleteProvince(req,res);
        	} else if(req.getParameter("editId") != null) {
        		System.out.println("Calling edit with id of: " + req.getParameter("editId"));
        	} else {
        		listProvinces(req,res);
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//  
        
	}
	
	public void listProvinces(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, ServletException, IOException {
		
		allProvinces = vnpDAO.selectAllProvinces();
		req.setAttribute("allProvinces", allProvinces);
		RequestDispatcher dispatcher = req.getRequestDispatcher("provinces.jsp");
		dispatcher.include(req, res);
		
		
	}
	
	public void deleteProvince(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException, SQLException {
        
		//System.out.println("Calling delete");
		String getPId = req.getParameter("delId");
        int pId = Integer.parseInt(getPId);
        vnpDAO.deleteProvince(pId);
        System.out.println("Delete successful at id: " + pId );
        res.sendRedirect("provinces");
        
	}
}
