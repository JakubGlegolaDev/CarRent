package databaseOperations;

import java.sql.ResultSet;
import java.util.Scanner;

public class DatabaseOperationTest {

	public static void main(String args[]) throws Exception {


		CarTableDao carTableDao = new CarTableDao();
		ResultSet queryToGetCar = carTableDao.getCarById(2);
		
		CarMapperObject carToRide= new CarMapperObject();
		CarDto Audi = carToRide.carMapper(queryToGetCar);
		
		System.out.println(Audi.getModel()+" "+ Audi.getMake()+" "+Audi.getYear());
		
		
		
		EmployeeTableDao employeeTableDao = new EmployeeTableDao();
		ResultSet queryToGetEmployee = employeeTableDao.getEmployeeById(2);
		
		EmployeeMapperObject employee = new EmployeeMapperObject();
		EmployeeDto Przemyslaw = employee.employeeMapper(queryToGetEmployee);
		
		System.out.println(Przemyslaw.getId()+" "+Przemyslaw.getName()+ " "+ Przemyslaw.getSalary());
		
		
	}

}
