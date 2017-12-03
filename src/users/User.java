package users;

public class User {
	
	private String name;
	private String surname;
	private int id;
	private long pesel;
	
	public User(String name, String surname, int id, long pesel) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.pesel = pesel;
	}
	
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
	
}
