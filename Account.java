
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
	
	public Rating getRating(){
		return rating;
	}
	public Location getLocation(){
		return loc;
	}
	public void setBalance(double newBalance){
		this.balance = newBalance;
	}
	
}
