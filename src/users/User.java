package users;

public class User {
	
	private String name;
	private String proffesion;
	private float salary;
	
	public User(String name, String proffesion, float salary) {
		this.name = name;
		this.proffesion = proffesion;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getProffesion() {
		return proffesion;
	}

	public float getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
