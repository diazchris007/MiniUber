import java.util.Timer;
import java.util.TimerTask;

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
	
	public void setStatus(boolean b) {
		// TODO Auto-generated method stubs
		available = b;
		
	}

	
}
