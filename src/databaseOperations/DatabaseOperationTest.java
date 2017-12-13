package databaseOperations;

import java.sql.ResultSet;
import java.util.Scanner;

public class DatabaseOperationTest {

	public static void main(String args[]) throws Exception {


		CarTableDao carTableDao = new CarTableDao();
		ResultSet queryToGetCar = carTableDao.getCarById(2);
		
		CarMapperObject carToRide= new CarMapperObject();
		CarDto Audi = carToRide.carMapper(queryToGetCar);
		
		System.out.print(Audi.getModel()+" "+ Audi.getMake()+" "+Audi.getYear());
		
	}

}
