package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import data.Fetch;
import java.sql.SQLException;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("username");
		String age = req.getParameter("userage");
		res.setContentType("text/html");
		
//		JSONObject data = null;
//		try {
//			data = Fetch.retrieveWorldStatistic();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		PrintWriter pw = res.getWriter();
		pw.println("<html>\n" + "<body>" + "<h2> Hello " + name + " !\n" + "</body>" + "</html>");
		
		pw.close();
	}
}






