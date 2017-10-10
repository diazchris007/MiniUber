
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
	public void addRate(int newRate){
		rateSum += newRate;
		rates +=1;
		rating = rateSum/rates;
	}
	
	
}
