/**
 * 
 * @author Christian
 *
 */
public class Driver extends Account
{
	private boolean available = true;
	
	
	public Driver(String name, float balance, Location loc){
		super(name, balance,loc);
		
	}
	
	public boolean getStatus(){
		return available;
	}
	
	public void setStatus(Boolean newStatus){
		available = newStatus;
	}

	
}
