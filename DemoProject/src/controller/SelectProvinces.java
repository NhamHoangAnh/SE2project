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
        		showEditForm(req, res);
        		editProvince(req,res);
        	} else if (req.getParameter("insert") != null) {
        		showInsertForm(req, res);
        		insertProvince(req,res);
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
	
	public void showEditForm(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException, SQLException {
		
		int pId = Integer.parseInt(req.getParameter("editId"));
		VietNamProvinces p = vnpDAO.getProvince(pId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("provinceEditForm.jsp");
		req.setAttribute("p", p);
        dispatcher.include(req, res);
	}
	
	public void editProvince(HttpServletRequest req, HttpServletResponse res) 
			throws SQLException, IOException {
		
		int pId = Integer.parseInt(req.getParameter("ePId"));
		String name = req.getParameter("eName");
		double confirmed = Double.parseDouble(req.getParameter("eConfirmed"));
		double deaths = Double.parseDouble(req.getParameter("eDeaths"));
		double recovered = Double.parseDouble(req.getParameter("eRecovered"));
		double underTreatment = Double.parseDouble(req.getParameter("eUnderTreatment"));
		String date = req.getParameter("eDate");
		VietNamProvinces changedP = new VietNamProvinces(pId, name,confirmed, deaths, recovered, underTreatment, date);
		vnpDAO.editProvince(changedP);
		res.sendRedirect("provinces");
		return;
	}
	
	public void showInsertForm(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException, SQLException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("provinceInsertForm.jsp");
        dispatcher.include(req, res);
	}
	
	public void insertProvince(HttpServletRequest req, HttpServletResponse res)
			throws SQLException, IOException {
		
		String name = req.getParameter("iName");
		double confirmed = Double.parseDouble(req.getParameter("iConfirmed"));
		double deaths = Double.parseDouble(req.getParameter("iDeaths"));
		double recovered = Double.parseDouble(req.getParameter("iRecovered"));
		double underTreatment = Double.parseDouble(req.getParameter("iUnderTreatment"));
		String date = req.getParameter("iDate");
		VietNamProvinces newP = new VietNamProvinces(name, confirmed, deaths, recovered, underTreatment, date);
		vnpDAO.insertProvince(newP);
		res.sendRedirect("provinces");
		return;
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
