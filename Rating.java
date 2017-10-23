/**
 * handles the rating system for all accounts
 * @author TheTaco
 *
 */
public class Rating {
	private float rating;
	private int rates;
	private int rateSum;
	
	public Rating(){
		this.rating = 0;
		this.rates = 0;
	}
	
	public float getRating(){
		return rating;
	}
	
	public int getRates(){
		return rates;
	}
	
	public int getRateSum(){
		return rateSum;
	}
/**
 * adjusts the rating	
 * @param newRate an integer rating for a trip
 */
	public void addRate(int newRate){
		rateSum += newRate;
		rates +=1;
		rating = rateSum/rates;
	}
	
	
}
