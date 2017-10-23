import com.google.gson.Gson;
/**
 * Information on a trip for later output
 * @author TheTaco
 *
 */
public class Trip {
	private boolean completed;
	private Location destination;
	private Driver driver;
	private Passenger passenger;
	private double driverPassengerDistance;
	private double passengerDestinationDistance;
	
	/**
	 * constructor for a completed trip
	 * @param driver driver of the trip
	 * @param passenger passenger who requested trip
	 * @param destination destination of the trip
	 */
	public Trip(Driver driver, Passenger passenger,Location destination) {
		this.destination = destination;
		this.driver = driver;
		this.passenger = passenger;
		driverPassengerDistance = driver.getLocation().getDistance(passenger.getLocation());
		passengerDestinationDistance = passenger.getLocation().getDistance(destination);
		this.completed = true;
	}
	/**
	 * constructor for a canceled trip
	 * @param passenger passenger who requested trip
	 * @param destination destination passenger requested
	 */
	public Trip(Passenger passenger, Location destination) {
		this.destination = destination;
		this.driver = null;
		this.passenger = passenger;	
		this.completed = false;
	}
	
	public boolean getCompletion() {
		return completed;
	}
	public Driver getDriver() {
		return driver;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public double getTtlDistance() {
		return driverPassengerDistance +passengerDestinationDistance;
	}
	
	public Location getDestination() {
		return destination;
	}


	public double getDriverPassengerDistance() {
		return driverPassengerDistance;
	}


	public double getPassengerDestinationDistance() {
		return passengerDestinationDistance;
	}

/**
 * creates a JSon string of the trip
 * @return a JSon string of the trip
 */
	public String serializeObject() {
	    Gson gson = new Gson();
	    String serializedObject = gson.toJson(this);
	    return serializedObject;
	}

/**
 * creates a trip from a json string
 * @param s Json string representation a of a trip
 * @return a trip constructed from the JSon string
 */
	public Object unserializeObject(String s){
	    Gson gson = new Gson();
	    Object object = gson.fromJson(s, this.getClass());
	    return object;
	}
/**
 * clones a trip so that no information is altered when connections are changed.
 * @return a clone of the trip
 */
	public Object cloneObject(){
	    String s = serializeObject();
	    Object object = unserializeObject(s);
	    return object;
	}
	/**
	 * returns a JSon string representation of the object
	 */
	public String toString() {
		return new Gson().toJson(this) ;
	}
	
}
