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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        
        try {
			allProvinces = vnpDAO.selectAllProvinces();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        String provincesJSON = this.gson.toJson(allProvinces);
//        PrintWriter pw = res.getWriter();
//        pw.print(provincesJSON);
//        pw.flush();
//        
        
        req.setAttribute("allProvinces", allProvinces);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("provinces.jsp");
        dispatcher.include(req, res);
        
	}
}
