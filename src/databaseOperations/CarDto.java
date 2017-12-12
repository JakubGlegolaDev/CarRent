package databaseOperations;

public class CarDto {


	private int id;
	private String make;
	private String model;
	private int year;
	private String availability;
	
	public CarDto(int id, String make, String model, int year, String availability) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.availability = availability;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
}
