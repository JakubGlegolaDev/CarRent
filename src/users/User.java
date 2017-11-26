package users;

public class User {
	
	private String firstName;
	private String lastName;
	private int id;
	private long pesel;
	
	public User(String firstName, String lastName, int id, long pesel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.pesel = pesel;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPesel() {
		return pesel;
	}
	public void setPesel(long pesel) {
		this.pesel = pesel;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
}
