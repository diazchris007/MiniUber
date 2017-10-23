import java.text.DecimalFormat;
import java.util.Random;
import com.google.gson.Gson;
/**
 * Account holds the main details of a Driver or Passenger
 * an account is responsible of sending payments to other accounts
 * it is also responsible for sending a pick up request.
 * @author TheTaco
 *
 */
public abstract class Account {
	private String name;
	private double balance;
	private Rating rating;
	private Location loc;
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
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public void setBalance(double newBalance){
		this.balance = newBalance;
	}
	/**
	 * Sends a payment to another account
	 * @param other account which is going to receive payment
	 * @param amount total amount due 
	 * @return if payment was successful
	 */
	
	public boolean sendPayment(Account other, Double amount){
		final float FARERATE = 10f;
		amount = amount * FARERATE;

		DecimalFormat df = new DecimalFormat("#.00"); 

		if(this.balance >= amount){
			this.balance -= amount;
			other.setBalance(other.getBalance() + amount * 0.75);
			
			//System.out.println(name +" paid " + other.name + " $" + df.format(amount) + "\nUber's cut is $" +  df.format(amount * .25));
			//System.out.println(other.name +" new Balance $" + df.format(other.getBalance()));
			//System.out.println(name +" new balance $" +df.format(balance));
			
			return true;
		}
		System.out.println(name+" can not afford $" + df.format(amount) + " balance is $" + df.format(balance));
		return false;
	}
	/**
	 * rate another account with a random number between 0 and 5
	 * @param acct account to rate
	 */
	public void giveRating(Account acct) {
		int temp = new Random().nextInt(5);
		acct.getRating().addRate(temp);
		//System.out.println(this.getName() + " gave "+ acct.getName() + " a " + temp);
		return;
	}
	/**
	 * given a management unit a ride is requested to a destination
	 * @param Unit which manager to use 
	 * @param Dest target destination
	 * @return if ride was not canceled returns true
	 */

	public Boolean requestRide(Management Unit,Location Dest) {
		if(Unit.addTrip((Passenger)this, Dest)){
			return true;
		}
		
		return false;
		}

	public String toString() {
		return new Gson().toJson(this);
	}
	/**
	 * formats an account variables for final output
	 * @return string of account variables
	 */
	public String getDetails() {

		DecimalFormat df = new DecimalFormat("#.00"); 
		return name + " end balance is $" +df.format(balance) + "\r\nRating is:" + df.format(rating.getRating()) + "\r\n-----------\r\n";
	}
}
