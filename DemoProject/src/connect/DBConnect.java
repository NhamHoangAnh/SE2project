package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/se2project?useSSL=false";
	private static String USER_NAME = "root";
	// Attention, different pass from different computer :v
	private static String PASSWORD = "tuanh223";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
