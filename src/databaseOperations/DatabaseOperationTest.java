package databaseOperations;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseOperationTest {

public static void main(String args[]) throws Exception {
		
		DatabaseOperationTest jdbctest = new DatabaseOperationTest();
		jdbctest.getALL();
		System.out.println("\n------------------");
		jdbctest.getID();
		System.out.println("\n------------------");
		jdbctest.createTable();
		
		
		String type = "";
		//System.out.println("Type 'status' to see informations about rental capacity");
		Scanner scanner = new Scanner(System.in);
		type = scanner.nextLine();
		if(type=="status") {
			
		}
		
	}

}
