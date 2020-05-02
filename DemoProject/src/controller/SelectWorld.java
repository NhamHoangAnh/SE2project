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
import model.World;

@WebServlet("/world")
public class SelectWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private WorldDAO wD = new WorldDAO();
	private World world = new World();
	
	public SelectWorld() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        
        try {
			world = wD.selectWorldStatistics();
		} catch (JSONException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // world as JSON
        
//        String worldJSON = this.gson.toJson(world);
//        PrintWriter pw = res.getWriter();
//        pw.print(world);
//        pw.flush();
        
        req.setAttribute("world", world);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("world.jsp");
        dispatcher.include(req, res);
        
	}
	
	
}
