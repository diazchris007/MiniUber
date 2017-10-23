import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

/**
 * manages all operations and communications between classes
 * can store drivers and passengers and a list of trips 
 * @author TheTaco
 *
 */
public class Management {
	private Area area;
	private List<Driver> drivers = new LinkedList();
	private List<Passenger> passengers = new LinkedList();
	private List<Trip> trips = new LinkedList();
	private final int DRIVERANDPASSENGER =  3;
	public Management(Area area) {
		if(area == null)
			this.area = new Area();
		else {
			this.area = area;
		}
	}
	
/**
 * adds an available driver to the map and to a list of all drivers
 * @param newDriver driver to add
 */
	public void addDriver(Driver newDriver) {
		if(area.addPerson(newDriver.getLocation(), 1))
			drivers.add(newDriver);
	}
	/**
	 * adds a passenger to the map and a list of all passengers
	 * @param newPassenger passenger to add
	 */
	public void addPassenger(Passenger newPassenger) {
		if(area.addPerson(newPassenger.getLocation(), 2))
			passengers.add(newPassenger);
	}
	
	public List getDrivers() {
		return drivers;
	}
	/**
	 * finds nearest driver to the target location
	 * if 2 drivers are the same distance from the target location
	 * takes the driver with the highest rating
	 * @param loc location of interest
	 * @return closest driver
	 */
	public Driver getNearest(Location loc) {
		Driver nearest = null;
		double tempDistance;
		double minDistance = Double.MAX_VALUE;
		
		for(Iterator j = drivers.iterator();j.hasNext();) {
			Driver driver = (Driver)j.next();
			tempDistance = driver.getLocation().getDistance(loc);
			if(driver.getStatus()) {
				if(tempDistance < minDistance) {
					minDistance= tempDistance;
					nearest = driver;
				}
				else if(tempDistance == minDistance) {
					
					if(driver.getRating().getRating() > nearest.getRating().getRating()) {
						minDistance = tempDistance;
						nearest = driver;
					}
				}
			}
		}
			
		return nearest;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	/**
	 * Takes a Passenger and a destination, looks for the nearest driver
	 * and creates a new trip which is added to a list of trips as a log
	 * 
	 * @param passenger passenger of the trip
	 * @param destination destination of passenger
	 */
	
	public boolean addTrip(Passenger passenger, Location destination) {
		if(area.validLoc(destination)) {
			Driver driver = getNearest(passenger.getLocation());
			
			if(driver != null) {
	
				if(driver.getStatus()) {
					Trip trip = new Trip(driver,passenger,destination);
					
					System.out.println(driver.getName()+" is nearest.");
					if(passenger.sendPayment(driver,trip.getTtlDistance()))
					{
						setDriverUnavailable(trip);
						passenger.giveRating((Account)driver);
	
						trips.add((Trip)trip.cloneObject());
						area.removePerson(driver.getLocation());
						area.removePerson(passenger.getLocation());
						driver.setLocation(destination);
						passenger.setLocation(destination);
						area.addPerson(destination, DRIVERANDPASSENGER);                                                                                                                                                                                                                                                                                                                                                                                                            
						return true;
					}
					else {
						System.out.println("Payment Failed");
						return false;
					}
				}
				else {
					System.out.println("Driver not Available");
					return false;
				}
				
			}
			else {
				System.out.println("No Drivers Available");
				return false;
			}
		}
		else {
			Trip trip = new Trip(passenger,destination);
			trips.add(trip);
		//invalid location, add canceled trip
		return false;
		}
		

	}
	/**
	 * takes the information of a trip to make a driver unavailable for the correct amount of time
	 * @param trip trip the driver is about to go on.
	 */
	private void setDriverUnavailable(Trip trip) {
		final int TIMEMULT = 1000;
		
		trip.getDriver().setStatus(false);
		long timeTtl = (long) trip.getTtlDistance() *TIMEMULT;
		long timeToPassenger = (long) trip.getDriverPassengerDistance() * TIMEMULT;
		long timeToDestination = (long) trip.getPassengerDestinationDistance() * TIMEMULT;
		
		String name = trip.getDriver().getName();
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				trip.getDriver().setStatus(true);
				System.out.println(name+ " is now available");
			};
		};
		
		TimerTask task2 = new TimerTask() {
			public void run() {
				System.out.println(name + " is outside now!");
			};
		};
		
		System.out.println(name + " will be unavailable for " + timeTtl + "ms");
		System.out.println(name + " will be outside in " + timeToPassenger + "ms"); 
		timer.schedule(task2, timeToPassenger);
		timer.schedule(task, timeTtl);
		
	}
	
	/**
	 * print the log of trips made 
	 */
	public void printTrips() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("tripLog.txt"), "utf-8"))) {
			for(Trip t : trips) {
	
			   writer.write(t.toString());
			   writer.write("\r\n");
			}
		} catch (Exception e) {}
	}
	/**
	 * print all information after
	 */
	public void finalPrint() {		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("finalOutput.txt"), "utf-8"))) {
			writer.write("There was " + trips.size()+  " trips requested \r\n");
			for(Driver d : drivers) {
				writer.write(d.getDetails());
			}
			for(Passenger p : passengers) {
				writer.write(p.getDetails());
			}
			writer.write(area.printArea());
			
	} catch (Exception e) {}
		
	}
	public Area getArea() {
		return area;
	}
}



