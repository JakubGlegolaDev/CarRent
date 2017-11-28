package databaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseOperations {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	
	public static Connection getConnection() throws Exception {
		
		Connection connection = null;
		
		try {
			//Class.forName(className)
			connection = DriverManager.getConnection(URL, User, Password);
			if(connection!=null) {
				System.out.println("Connection finished with success");
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return connection;
	}
	

	// DOESNT WORK... do not create any table(checked in phpmyadmin)
	public static void createTable() throws Exception {
		
		String cr = "CREATE TABLE IF NOT EXISTS test2(ID int(5) AUTO_INCREMENT, name VARCHAR(40);";
		DatabaseOperations jdbc = new DatabaseOperations();
		
		try {
			Connection connection = jdbc.getConnection();
			PreparedStatement create = (PreparedStatement) connection.prepareStatement(cr);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Function complete");
		}
	}
	
	
	
		// WORKS WELL
	public static ArrayList<String> getALL() throws Exception{
		
		DatabaseOperations jdbc = new DatabaseOperations();
		
		try {
			Connection connection = jdbc.getConnection();
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement("SELECT * from testowa;");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("ID")); System.out.print("  ");
				System.out.println(result.getString("name"));
				
			}
			return array;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	
		//WORKS WELL
	public static ArrayList<String> getID() throws Exception{
		
		DatabaseOperations jdbc = new DatabaseOperations();
		
		try {
			Connection connection = jdbc.getConnection();
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement("SELECT ID from testowa;");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.println(result.getString("ID"));
			}
			return array;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

	public static void insertCar(int id, String make, String model, int year, String availability) {
		try {
			Connection connection = null;
			PreparedStatement preStatement = connection.prepareStatement("INSERT INTO Car(ID,Make,Model,Year,Availability) VALUES(?,?,?,?,?)");
			
		}
	}
	
}
