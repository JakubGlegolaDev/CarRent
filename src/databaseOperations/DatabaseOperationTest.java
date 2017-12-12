package databaseOperations;

import java.util.Scanner;

public class DatabaseOperationTest {

private static Scanner scanner;

public static void main(String args[]) throws Exception {
		

//		DatabaseOperations dboper = new DatabaseOperations();

//		dboper.getALL();
//		dboper.getID();
//		dboper.checkExistanceCar();

//		dboper.insertCar("e90", "BMW", 2008, "Yes");
//		dboper.insertClient(88052375680L, "Malgosia", "Bak");
//		dboper.getCar();
//		dboper.getClient();

//		dboper.getALL();
//		dboper.getID();
//		dboper.checkExistanceCar();

		
		
		String type = "";
		
		scanner = new Scanner(System.in);
		/*System.out.print("Podaj pesel: ");
		long pesel = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Podaj imie: ");
		String name = scanner.nextLine();
		System.out.print("Podaj nazwisko: ");
		String surname = scanner.nextLine();*/
		
		//dboper.insertClient(pesel, name, surname);
		
		System.out.println("Type 'status' to see informations about available cars and rental capacity");
		type = scanner.nextLine();
		if(type.equals("status")) {
//			dboper.getStatus(); // aktualna lista dostêpnych samochodów.
		}
		
		
		
	}

}
