package databaseOperations;

public class HireDto {

	private int hireId;
	private int carId;
	private int clientId;
	
	public HireDto(int hireId, int carId, int clientId) {
		super();
		this.hireId = hireId;
		this.carId = carId;
		this.clientId = clientId;
	}
	
	public int getHireId() {
		return hireId;
	}
	public void setHireId(int hireId) {
		this.hireId = hireId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
