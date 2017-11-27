package mainThings;

import java.util.Scanner;

import databaseOperations.JDBC;
import databaseOperations.JDBCtest;

public class CarRent {
	
	public static void main(String args[]) throws Exception {
		
		JDBCtest jdbctest = new JDBCtest();
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
