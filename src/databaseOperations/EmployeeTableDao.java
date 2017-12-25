package databaseOperations;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeTableDao {

	private static String URL = "jdbc:mysql://149.156.96.20:3306/jglegola";
	private static String User = "jglegola";
	private static String Password = "87KwxYGh15ktgViX";
	Connection connection;
	Statement statement;
	DatabaseMetaData dbMetaData;
	PreparedStatement preparedStatement;
	
	public EmployeeTableDao() {
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
		String selectAll = "SELECT * FROM Employee;";
		
		try {
			ResultSet result = statement.executeQuery(selectAll);
			
			while(result.next()) {
				System.out.print(result.getInt("ID")); System.out.print("  ");
				System.out.print(result.getLong("PESEL")); System.out.print(" ");
				System.out.print(result.getString("Name")); System.out.print(" ");
				System.out.print(result.getString("Surname")); System.out.print(" ");
				System.out.print(result.getString("Proffesion")); System.out.print(" ");
				System.out.println(result.getInt("Salary")); 				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}	
	
	public void insertEmployee(String name, String surname, long pesel, String proffesion, int salary) throws Exception{
		preparedStatement = connection.prepareStatement("INSERT INTO Employee(PESEL, Name, Surname, Proffesion, Salary) VALUES(?,?,?,?,?)");
		preparedStatement.setLong(1, pesel);		
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, surname);
		preparedStatement.setString(4, proffesion);
		preparedStatement.setInt(5, salary);
				
		try {
			preparedStatement.executeUpdate();
			System.out.print("Employee added successfully");
		}catch (SQLException e) {
			System.out.println("Error occured while insert Employee was executed");
			e.printStackTrace();
			System.out.println(e);
		}finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}
	
	public boolean checkExistanceEmployee() throws Exception{
		
		try {
	
			dbMetaData = connection.getMetaData();
			ResultSet result = dbMetaData.getTables(null, null, "Emplyoee", null);
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
	
	
	public ResultSet getEmployeeById(int employeeId) throws Exception{
			
			ResultSet result = null;
			
			try {
				String employeeIdString = String.valueOf(employeeId);
				String selectById = "SELECT * FROM Employee WHERE ID ='"+employeeIdString+"';";
				result = statement.executeQuery(selectById);
				System.out.println("Wykonal sie resultSet");
				
			} catch (Exception e) {
				System.out.println(e);
			}
				
			return result;
		}
	
}
