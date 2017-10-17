import java.util.Random;

public class Passenger extends Account{

	public Passenger(String name, float balance, Location loc){
		super(name, balance, loc);
	}
	public Boolean requestRide(Management Unit,Location Dest) {
		Driver driver = (Driver) Unit.getNearest(this.loc);
		
		if(driver != null) {
			if(driver.getStatus()) {
				System.out.println(driver.getName()+" is nearest.");
				if(this.sendPayment(driver,Unit.calcTtlDist(this.loc,driver.getLocation(),Dest))){
					driver.setStatus(false);
					int temp = new Random().nextInt(5);
					driver.getRating().addRate(temp);
					System.out.println(this.getName() + " gave "+ driver.getName() + " a " + temp);
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
		System.out.println("No Drivers Available");
		return false;
	}

}
