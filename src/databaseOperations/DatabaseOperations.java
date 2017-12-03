package databaseOperations;


import java.sql.*;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class DatabaseOperations {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	public DatabaseOperations() throws Exception{
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
	
//	public Connection getConnection() throws Exception {
//		
//		try {
//			connection = DriverManager.getConnection(URL, User, Password);
//			statement = connection.createStatement(); //Creating Statement Class's object which is responsible for performing all db tasks
//			if(connection!=null) {
//				System.out.println("Connection finished with success");
//			}
//		}catch(Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
//		// DODANY STATEMENT
//
//	}
//	
	
	public ArrayList<String> getALL() throws Exception{
		//QUERY DO BAZY DANYCH.
		String selectAll = "SELECT * FROM testowa;";
		
		try {
			// TUTAJ JU¯ WYWO£ANIE NA TYM statement.
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
	
<<<<<<< HEAD
	public ArrayList<String> getClient() throws Exception{
		//QUERY DO BAZY DANYCH.
		String selectAll = "SELECT * FROM Client;";
		
		try {
			// TUTAJ JU¯ WYWO£ANIE NA TYM statement.
			ResultSet result = statement.executeQuery(selectAll);
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("ID")); System.out.print("  ");
				System.out.print(result.getString("PESEL")); System.out.print(" ");
				System.out.print(result.getString("Name")); System.out.print(" ");
				System.out.println(result.getString("Surname")); 
				
			}
			return array;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public ArrayList<String> getCar() throws Exception{
		//QUERY DO BAZY DANYCH.
		String selectAll = "SELECT * FROM Car;";
		
		try {
			// TUTAJ JU¯ WYWO£ANIE NA TYM statement.
			ResultSet result = statement.executeQuery(selectAll);
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("ID")); System.out.print("  ");
				System.out.print(result.getString("Model")); System.out.print(" ");
				System.out.print(result.getString("Make")); System.out.print(" ");
				System.out.print(result.getString("Year")); System.out.print(" ");
				System.out.println(result.getString("Availability")); 
				
			}
			return array;
		}catch(Exception e){
=======
	public ArrayList<String> getStatus() throws Exception{
		
		String selectStatus = "SELECT model, make, year, availability FROM Cars WHERE availability='Yes';";
		preparedStatement = connection.prepareStatement(selectStatus);
		
		
		try {
			ResultSet result = preparedStatement.executeQuery(selectStatus);
		} catch(Exception e){
>>>>>>> kBranch
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
	
<<<<<<< HEAD
	public void insertCar(String model, String make, int year, String availability) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Car(Model, Make, Year, Availability) VALUES(?,?,?,?)");
		preparedStatement.setString(1, model);
		preparedStatement.setString(2, make);
		preparedStatement.setInt(3, year);
		preparedStatement.setString(4, availability);
=======
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
>>>>>>> kBranch
		
		
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
	
	public void insertClient(long pesel, String name, String surname) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Client(PESEL, Name, Surname) VALUES(?,?,?)");
		preparedStatement.setLong(1, pesel);		
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, surname);
		
		
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
