/**
 * 
 * @author Christian
 *
 */
public class Driver 
{
	private Account account;
	private boolean status;
	public Driver(Account account){
		this.account = account;
		this.status = false;
	}
	
	public Account getAccount(){
		return account;
	}
	public boolean getStatus(){
		return status;
	}
	public void setStatus(Boolean newStatus){
		status = newStatus;
	}

	
}
