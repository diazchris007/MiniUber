import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Management {
	private static Area area;
	private List drivers = new LinkedList();
	private List passengers = new LinkedList();
	private List trips = new LinkedList();
	public Management(Area area) {
		if(area == null)
			this.area = new Area();
		else {
			this.area = area;
		}
	}
	public void addDriver(Driver newDriver) {
		area.addPerson(newDriver.getLocation());
		drivers.add(newDriver);
	}
	public void addPassenger(Passenger newPassenger) {
		area.addPerson(newPassenger.getLocation());
		passengers.add(newPassenger);
	}
	public List getDrivers() {
		return drivers;
	}
	public Driver getNearest(Location loc) {
		Driver nearest = null;
		double tempDistance;
		double minDistance = 0;
		
		for(Iterator j = drivers.iterator();j.hasNext();) {
			Driver driver = (Driver)j.next();
			tempDistance = driver.getLocation().getDistance(loc);
			if(driver.getStatus()) {
				if(tempDistance > minDistance) {
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
	public List getPassengers() {
		return passengers;
	}
	
	public void addTrip(Account account, Location destination) {

		Driver driver = getNearest(account.getLocation());
		
		if(driver != null) {

			if(driver.getStatus()) {
				Trip trip = new Trip(driver,account,destination);
				
				System.out.println(driver.getName()+" is nearest.");
				if(account.sendPayment(driver,trip.getTtlDistance()))
				{
					driver.setStatus(false);
					account.giveRating(driver);

					trips.add(trip);
				}
				else {
					System.out.println("Payment Failed");
				}
			}
			else {
			System.out.println("Driver not Available");
			}
			
		}
		System.out.println("No Drivers Available");
	}

	}

}
