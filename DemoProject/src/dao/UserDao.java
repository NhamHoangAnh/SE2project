package dao;
	
import java.sql.Connection;

import connect.DBConnect;
import model.User;

public class UserDao {
	
	private Connection conn;
	public UserDao() {
		conn = DBConnect.getConnection();
	}
	
	public boolean login(String username,String password) {
		
		User u = new User();
		
		
		return false; 
	}
}
