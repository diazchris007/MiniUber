
public class Area {
	int[][] map;
	
	public Area(){
		map = new int[300][300];
	}
	public void addPerson(Location loc){
		map[loc.getX()][loc.getY()] = 1; 
	}
	public void removePerson(Location loc){
		map[loc.getX()][loc.getY()] = 1;		
	}
	

}
