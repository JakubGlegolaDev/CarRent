package databaseOperations;

import java.sql.ResultSet;

import databaseOperations.*;

public class CarMapperObject {
	
	public CarDto carMapper(ResultSet queryResult) throws Exception{
		
		CarDto carToCreate = null;
		
		try {
			queryResult.first();
			int carId = queryResult.getInt("ID");
			String carMake = queryResult.getString("Make");
			String carModel = queryResult.getString("Model");
			int carYear = queryResult.getInt("Year");
			String carAvailability = queryResult.getString("Availability");	
			carToCreate = new CarDto(carId, carMake, carModel, carYear, carAvailability);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return carToCreate;

	}
	
}