package dao;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.DBConnect;
import model.User;

public class UserDAO {
	
	private Connection conn;
	public UserDAO() {
		conn = DBConnect.getConnection();
	}
	
	public boolean login(String username,String password) 
			throws SQLException {
		
		String getUser = "SELECT * FROM User WHERE username =? AND password =?";
		PreparedStatement pstmt = conn.prepareStatement(getUser);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
		 
	}
	
	public static void main(String args[]) {
		UserDAO uD = new UserDAO();
		try {
			System.out.println(uD.login("admin", "admin"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}