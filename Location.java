/**
 * Holds the X, Y coordinates of a location.
 * @author Christian
 *
 */
public class Location {
	private int x, y;
	public Location(int x, int y){
		this.x = x;
		this.y =y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public double getDistance(Location Destination){
		return Math.sqrt(Math.pow((x - Destination.getX()),2)+
				Math.pow((y - Destination.getY()),2));
	}
}
