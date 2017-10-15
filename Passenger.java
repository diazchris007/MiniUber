
public class Passenger extends Account{

	public Passenger(String name, float balance, Location loc){
		super(name, balance, loc);
	}
	public Boolean requestRide(Management Unit,Location Dest) {
		Driver driver = (Driver) Unit.getNearest(this.loc);
		
		if(driver != null) {
			if(sendPayment(driver,Unit.calcFare(this.loc,driver.getLocation(),Dest))){
				driver.setStatus(false);
				
			}
		}
		return false;
	}

}
