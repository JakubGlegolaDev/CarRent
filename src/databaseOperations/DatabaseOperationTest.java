package databaseOperations;

import java.util.Scanner;

public class DatabaseOperationTest {

public static void main(String args[]) throws Exception {
		

		DatabaseOperations dboper = new DatabaseOperations();
		dboper.getConnection();
		dboper.getALL();
		dboper.getID();
		dboper.checkExistance();
		dboper.insertExample();
	
		
		String type = "";
		System.out.println("Type 'status' to see informations about rental capacity");
		Scanner scanner = new Scanner(System.in);
		type = scanner.nextLine();
		if(type=="status") {
			
		}
		
	}

}
