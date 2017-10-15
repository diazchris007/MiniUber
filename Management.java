import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Management {
	private static Area area;
	private Queue drivers;
	private List passengers;
	
	public Management(Area area) {
		if(area == null)
			this.area = new Area();
		else {
			this.area = area;
		}
	}
	public void addDriver(Account newDriver) {
		area.addPerson(newDriver.getLocation());
		drivers.add(newDriver);
	}
	public void addPassenger(Account newDriver) {
		area.addPerson(newDriver.getLocation());
		passengers.add(newDriver);
	}
	public Queue getDrivers() {
		return drivers;
	}
	public Account getNearest(Location loc) {
		Driver nearest = null;
		double tempDistance;
		double minDistance = 0;
		
		for(Iterator j = drivers.iterator();j.hasNext();) {
			Driver driver = (Driver)j.next();
			tempDistance = driver.getLocation().getDistance(loc);
			
			if(tempDistance > minDistance) {
				minDistance= tempDistance;
				nearest = driver;
			}
			else if(tempDistance == minDistance) {
				
				if(driver.getRating() > nearest.getRating()) {
					minDistance = tempDistance;
					nearest = driver;
				}
			}
		}
			
		return nearest;
	}
	
	public List getPassengers() {
		return passengers;
	}
	public Double calcFare(Location passengerLoc,Location DriverLoc , Location dest) {
		Double ttlDistance = 0.00;
		ttlDistance += DriverLoc.getDistance(passengerLoc);
		ttlDistance += passengerLoc.getDistance(dest);
		
		return ttlDistance;
	}
	
}
