
public class Account {
	private String name;
	private float balance;
	private Rating rating;
	private Location loc;
	public Account(String name, float balance, Location loc){
		this.name = name;
		this.balance = balance;
		this.rating = new Rating();
		this.loc = loc;
	}	
	public String getName(){
		return name;
	}
	public float getBalance(){
		return balance;
	}
	public boolean sendPayment(Account other, float amount){
		if(this.balance >= amount){
			this.balance -= amount;
			other.setBalance(other.getBalance() + amount);
			System.out.println(other.name +" paid " + name + " $" + amount);
			System.out.println(other.name +" new Balance $" + other.getBalance());
			System.out.println(name +" new balance $" + balance);
			
			return true;
		}
		return false;
	}
	public Rating getRating(){
		return rating;
	}
	public Location getLocation(){
		return loc;
	}
	public void setBalance(float newBalance){
		this.balance = newBalance;
	}
	
}
