package databaseOperations;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HireTableDao {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	public HireTableDao() {
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

		String selectAll = "SELECT * FROM Hire;";
		
		try {
			ResultSet result = statement.executeQuery(selectAll);
			
			while(result.next()) {
				System.out.print(result.getInt("IDcar")); System.out.print("  ");
				System.out.print(result.getInt("IDclient")); System.out.print(" ");
				System.out.print(result.getInt("IDhire")); 
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
		
	public void insertHire(int hireId, int carId, int clientId) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Hire(IDcar, IDclient, IDhire) VALUES(?,?,?)");
		preparedStatement.setInt(1, carId);		
		preparedStatement.setInt(2, clientId);
		preparedStatement.setInt(3, hireId);
			
		try {
			preparedStatement.executeUpdate();
			System.out.print("Hire added successfully");
		}catch (SQLException e) {
			System.out.print("Error occured while insert Hire was executed");
			e.printStackTrace();
			System.out.println(e);
		}finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}
	
	public boolean checkExistanceHire() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "Hire", null);
			if(result.next()) {
				System.out.println("Base found");
				return true;
			} else {
				System.out.println("Base does not found");
				return false;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
}
