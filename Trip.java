
public class Trip {
	
	private Location destination;
	private Driver driver;
	private Account passenger;
	private double ttlDistance;
	
	public Trip(Driver driver, Account passenger,Location destination) {
		this.destination = destination;
		this.driver = driver;
		this.passenger = passenger;
		ttlDistance  = calcTtlDist();
	}
	


	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Account getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public double getTtlDistance() {
		return ttlDistance;
	}
	
	private double calcTtlDist() {
		double temp = 0;
		temp += driver.getLocation().getDistance(passenger.getLocation());
		temp += passenger.getLocation().getDistance(destination);
		
		return temp;
	}
		
	
}
