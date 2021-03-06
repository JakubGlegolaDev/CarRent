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
		
		try {
			preparedStatement.executeUpdate();
			System.out.print("Dodano samochod do tabeli Car");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Nie udalo sie dodac samochodu");
			System.out.println(e);
		}finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}
	
	public boolean checkExistanceCarTable() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "Car", null);
			if(result.next()) {
				System.out.println("Base found");
				return true;
			} else {
				System.out.println("Base does not found");
				return false;
			}
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	
	public ArrayList<String> getAllAvailabilityCar() throws Exception{
		
		String selectStatus = "SELECT Model, Make, Year FROM Car WHERE Availability='Yes';";
		
		
		try {
			ResultSet result = statement.executeQuery(selectStatus);
			
			System.out.println("Model | Make | Year  ");
			
			while(result.next()) {
				System.out.print(result.getString("Model")); System.out.print(" | ");
				System.out.print(result.getString("Make")); System.out.print(" | ");
				System.out.println(result.getString("Year")); 
 
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public ResultSet getCarById(int carId) throws Exception{
		
		ResultSet result = null;
		
		try {
			String carIdString = String.valueOf(carId);
			String selectById = "SELECT * FROM Car WHERE ID ='"+carIdString+"';";
			result = statement.executeQuery(selectById);
			System.out.println("Wykonal sie resultSet");
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		return result;
	}
	
	
}
