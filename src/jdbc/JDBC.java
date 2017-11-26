package jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class JDBC {

	private static String URL = "jdbc:mysql://localhost:3306/CarRent";
	private static String User = "root";
	private static String Password = "root";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = (Connection)DriverManager.getConnection(URL, User, Password);
			if(connection!=null) {
				System.out.println("Connection finished with success");
			}
		} 
		catch(Exception e) {
			System.out.println("Connection FAILED");
		}
		
		return connection;
	}
	
	
	
	
}
