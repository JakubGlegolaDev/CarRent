package databaseOperations;

import java.sql.*;
import java.util.ArrayList;

public class CarTableDao {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	
	public CarTableDao() throws Exception{
		try {
			connection = DriverManager.getConnection(URL, User, Password);
			statement = connection.createStatement(); //Creating Statement Class's object which is responsible for performing all db tasks
			if(connection!=null) {
				System.out.println("Connection finished with success");
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
		
	
	public ArrayList<String> getAllInformation() throws Exception{
		String selectAll = "SELECT * FROM Car;";
		
		try {
			ResultSet result = statement.executeQuery(selectAll);
			
			while(result.next()) {
				System.out.print(result.getInt("ID")); System.out.print("  ");
				System.out.print(result.getString("Model")); System.out.print(" ");
				System.out.print(result.getString("Make")); System.out.print(" ");
				System.out.print(result.getInt("Year")); System.out.print(" ");
				System.out.println(result.getString("Availability")); 
				
			}
		}catch(Exception e){
			}
		return null;
		}
	
	public void insertCar(String model, String make, int year, String availability) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Car(Model, Make, Year, Availability) VALUES(?,?,?,?)");
		preparedStatement.setString(1, model);
		preparedStatement.setString(2, make);
		preparedStatement.setInt(3, year);
		preparedStatement.setString(4, availability);
	}
	
	public void checkExistanceCarTable() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "Car", null);
			if(result.next()) {
				System.out.println("Base found");
			} else {
				System.out.println("Base does not found");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public ArrayList<String> getAllAvailabilityCar() throws Exception{
		
		String selectStatus = "SELECT Model, Make, Year, Availability FROM Car WHERE Availability='Yes';";
		
		
		try {
			ResultSet result = statement.executeQuery(selectStatus);
			
			System.out.println("Model | Make | Year | Availability");
			
			while(result.next()) {
				System.out.print(result.getString("Model")); System.out.print("   ");
				System.out.print(result.getString("Make")); System.out.print("   ");
				System.out.print(result.getString("Year")); System.out.print("   ");
				System.out.println(result.getString("Availability")); 
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
