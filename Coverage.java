/**
 * 
 * @author Christian
 *
 */
public class Map {
	int[][] map;
	
	public Map(){
		map = new int[300][300];
	}
	public void addPerson(Location loc){
		map[loc.getX()][loc.getY()] = 1; 
	}
	public void removePerson(Location loc){
		map[loc.getX()][loc.getY()] = 1;		
	}
	
}
