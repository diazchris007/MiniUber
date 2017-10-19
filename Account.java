import java.util.Random;

public abstract class Account {
	private String name;
	private double balance;
	private Rating rating;
	protected Location loc;

	public Account(String name, double balance, Location loc){
		this.name = name;
		this.balance = balance;
		this.rating = new Rating();
		this.loc = loc;

	}	
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	

	public Rating getRating(){
		return rating;
	}
	public Location getLocation(){
		return loc;
	}
	public void setBalance(double newBalance){
		this.balance = newBalance;
	}
	
	public boolean sendPayment(Account other, Double amount){
		
		if(this.balance >= amount){
			this.balance -= amount;
			other.setBalance(other.getBalance() + amount);
			System.out.println(name +" paid " + other.name + " $" + amount);
			System.out.println(other.name +" new Balance $" + other.getBalance());
			System.out.println(name +" new balance $" + balance);
			
			return true;
		}
		System.out.println("Can not afford $" + amount + " balance is $" + balance);
		return false;
	}
	public void giveRating(Account acct) {
		int temp = new Random().nextInt(5);
		acct.getRating().addRate(temp);
		System.out.println(this.getName() + " gave "+ acct.getName() + " a " + temp);
		return;
	}
	
	public Boolean requestRide(Management Unit,Location Dest) {
		Unit.addTrip(this, Dest);
		/*
		if(driver != null) {
			if(driver.getStatus()) {
				System.out.println(driver.getName()+" is nearest.");
				if(this.sendPayment(driver,Unit.calcTtlDist(this.loc,driver.getLocation(),Dest))){
					driver.setStatus(false);
					giveRating(driver);
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
	*/
		return true;
		}
	
}
