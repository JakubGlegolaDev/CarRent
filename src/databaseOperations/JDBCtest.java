package databaseOperations;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCtest {



	// DOESNT WORK... do not create any table(checked in phpmyadmin)
public static void createTable() throws Exception {
		
		String cr = "CREATE TABLE IF NOT EXISTS test2(ID int(5) AUTO_INCREMENT, name VARCHAR(40);";
		JDBC jdbc = new JDBC();
		
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
		
		JDBC jdbc = new JDBC();
		
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
		
		JDBC jdbc = new JDBC();
		
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
	
}
