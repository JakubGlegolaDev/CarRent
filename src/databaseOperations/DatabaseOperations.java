package databaseOperations;


import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperations {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	
	public Connection getConnection() throws Exception {
		
		try {
			connection = DriverManager.getConnection(URL, User, Password);
			if(connection!=null) {
				System.out.println("Connection finished with success");
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		// DODANY STATEMENT
		statement = connection.createStatement(); //Creating Statement Class's object which is responsible for performing all db tasks
		return connection;
	}
	
	
	public ArrayList<String> getALL() throws Exception{
		//QUERY DO BAZY DANYCH.
		String selectAll = "SELECT * FROM testowa;";
		
		try {
			// TUTAJ JU� WYWO�ANIE NA TYM statement.
			ResultSet result = statement.executeQuery(selectAll);
			
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
	
	public ArrayList<String> getStatus() throws Exception{
		
		String selectStatus = "SELECT model, make, year, availability FROM Cars WHERE availability='Yes';";
		preparedStatement = connection.prepareStatement(selectStatus);
		
		
		try {
			ResultSet result = preparedStatement.executeQuery(selectStatus);
		} catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	
	public ArrayList<String> getID() throws Exception{
		
		String selectID = "SELECT ID FROM testowa;";
		
		try {
			
			ResultSet result = statement.executeQuery(selectID);
			
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
	
	
	public void checkExistanceClient() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "Client", null);
			if(result.next()) {
				System.out.println("Base found");
			} else {
				System.out.println("Base does not found");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void checkExistanceEmployee() throws Exception{
			
			try {
		
				dbMetaData = connection.getMetaData();
				ResultSet result = dbMetaData.getTables(null, null, "Emplyoee", null);
				if(result.next()) {
					System.out.println("Base found");
				} else {
					System.out.println("Base does not found");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	
	public void checkExistanceHire() throws Exception{
			
			try {
		
				dbMetaData = connection.getMetaData();
				ResultSet result = dbMetaData.getTables(null, null, "Hire", null);
				if(result.next()) {
					System.out.println("Base found");
				} else {
					System.out.println("Base does not found");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	
	public void checkExistanceCar() throws Exception{
			
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


	
	
	public void insertExample(String name) throws Exception {
		
		String insertion = "INSERT INTO testowa " + "VALUES (,"+name+")";
		
		try {
			statement.executeUpdate(insertion);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void inserExamplePS(String name) throws Exception{
		
		preparedStatement = connection.prepareStatement("INSERT INTO testowa(name) VALUES(?)");
		preparedStatement.setString(1, name);
		try {
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		
	}
	
	public void insertCar(String model, String make, int year, String availability) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Car(Model, Make, Year, Availability) VALUES(?,?,?,?)");
		preparedStatement.setString(1, model);
		preparedStatement.setString(2, make);
		preparedStatement.setInt(3, year);
		preparedStatement.setString(4, availability);
		
		
		try {
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}
	
	
	
	
	
}
