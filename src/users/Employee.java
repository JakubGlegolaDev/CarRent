package users;

public class Employee extends User{

	private String proffesion;
	private int salary;
	
	public Employee(String firstName, String lastName, int id, long pesel, String proffesion, int salary) {
		super(firstName, lastName, id, pesel);
		this.proffesion = proffesion;
		this.salary = salary;
	}
	
	public String getProffesion() {
		return proffesion;
	}
	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

	
}
