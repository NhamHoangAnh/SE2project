package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.WorldDAO;
import model.World;

public class SelectWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        
        
        WorldDAO wD = new WorldDAO();
        World w = new World();
        
	}
}
