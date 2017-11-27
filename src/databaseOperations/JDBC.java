package databaseOperations;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class JDBC {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			//Class.forName(className)
			connection = (Connection) DriverManager.getConnection(URL, User, Password);
			if(connection!=null) {
				System.out.println("Connection finished with success");
			}
		} 
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
	
}
