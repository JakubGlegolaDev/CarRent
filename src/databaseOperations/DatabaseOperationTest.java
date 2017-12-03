package databaseOperations;

import java.util.Scanner;

public class DatabaseOperationTest {

private static Scanner scanner;

public static void main(String args[]) throws Exception {
		

		DatabaseOperations dboper = new DatabaseOperations();
//		dboper.getALL();
//		dboper.getID();
		dboper.checkExistance();

//		dboper.insertCar("e90", "BMW", 2008, "Tak");
//		dboper.insertClient(88052375680L, "Malgosia", "Bak");
		dboper.getCar();
		dboper.getClient();
		
		String type = "";
		
		scanner = new Scanner(System.in);
		System.out.print("Podaj pesel: ");
		long pesel = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Podaj imie: ");
		String name = scanner.nextLine();
		System.out.print("Podaj nazwisko: ");
		String surname = scanner.nextLine();
		
		dboper.insertClient(pesel, name, surname);
		
		System.out.println("Type 'status' to see informations about rental capacity");
		type = scanner.nextLine();
		if(type=="status") {
			System.out.println("Istnieje");
		}
		
		
		
	}

}
