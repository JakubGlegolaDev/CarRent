package databaseOperations;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseOperations {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	
	
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
			// TUTAJ JU� WYWO�ANIE NA TYM object.
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
	
	
	public void checkExistance() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "testowa", null);
			if(result.next()) {
				System.out.println("Base found");
			} else {
				System.out.println("Base does not found");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}