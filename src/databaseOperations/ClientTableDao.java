package databaseOperations;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientTableDao {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	public ClientTableDao() throws Exception{
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

		String selectAll = "SELECT * FROM Client;";
		
		try {
			ResultSet result = statement.executeQuery(selectAll);
			
			while(result.next()) {
				System.out.print(result.getInt("ID")); System.out.print("  ");
				System.out.print(result.getLong("PESEL")); System.out.print(" ");
				System.out.print(result.getString("Name")); System.out.print(" ");
				System.out.println(result.getString("Surname")); 
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
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

	
}
