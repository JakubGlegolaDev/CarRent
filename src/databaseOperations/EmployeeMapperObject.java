package databaseOperations;

import java.sql.ResultSet;

public class EmployeeMapperObject {
	
	public EmployeeDto employeeMapper(ResultSet queryResult) throws Exception{
		
		EmployeeDto employeeToCreate = null;
		
		try {
			queryResult.first();
			String employeeName = queryResult.getString("Name");
			String employeeSurname = queryResult.getString("Surname");
			String employeeProffesion = queryResult.getString("Proffesion");
			int employeeId = queryResult.getInt("ID");
			long employeePesel = queryResult.getLong("PESEL");
			int employeeSalary = queryResult.getInt("Salary");
			employeeToCreate = new EmployeeDto(employeeName, employeeSurname, employeeId, employeePesel, employeeProffesion, employeeSalary);
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return employeeToCreate;
		
	}

}
