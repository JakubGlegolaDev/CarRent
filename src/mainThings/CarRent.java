package mainThings;

import java.util.Scanner;

import databaseOperations.JDBC;

public class CarRent {
	
	public static void main(String args[]) throws Exception {
		
		JDBC jdbc = new JDBC();
		jdbc.getConnection();
		
		String type = "";
		System.out.println("Type 'status' to see informations about rental capacity");
		Scanner scanner = new Scanner(System.in);
		type = scanner.nextLine();
		if(type=="status") {
			
		}
		
	}

}
