/**
 * creates a map of the allowed area of operation
 * @author TheTaco
 *
 */
public class Area {
	private int[][] map;
	private final int RANGE = 12;
	
	public Area(){
		map = new int[RANGE][RANGE];
	}
	/**
	 * adds a person to the map at the given location, type is 1 for a driver, 2 for a passenger and 3 if more than one person is at the index
	 * @param loc location of person to be added
	 * @param type type is 1 for a driver, 2 for a passenger and 3 if more than one person is at the index
	 * @return if person was successfully placed on map returns true
	 */
	public boolean addPerson(Location loc, int type){
		if(validLoc(loc)) {
			
			map[loc.getX()][loc.getY()] = type; 
			return true;
		}
		else {
			System.out.println("Location not covered by Uber");
			return false;
		}
	}
	/**
	 * removes all from given location
	 * @param loc location of person to be removed
	 */
	public void removePerson(Location loc){
		map[loc.getX()][loc.getY()] = 0;		
	}
	/**
	 * validates a location to be within the area of operation
	 * @param loc location to validate
	 * @return true if location is valid
	 */
	public boolean validLoc(Location loc) {
		// TODO Auto-generated method stub
		if((loc.getX() <RANGE&& loc.getX() >= 0) && (loc.getY() < RANGE && loc.getY() >= 0)) {
			return true;		
		}
		else {
			System.out.println("X:"+ loc.getX() + " & Y:" + loc.getY() + " target Location out of bounds.");
			return false;
		}
	}
	/**
	 * returns a multi-line string representation of the map
	 * @return a multi-line string representation of the map
	 */
	public String printArea() {
		StringBuilder sb = new StringBuilder("");
		for(int x = 0; x<RANGE;x++) {
			for(int y = 0; y<RANGE;y++) {
				if(map[x][y] == 1)
					sb.append("D ");
				else if(map[x][y] == 2)
					sb.append("P ");
				else if(map[x][y] == 3)
					sb.append("X ");
				else
					sb.append(". ");
			}
			sb.append("\r\n");
		}
		return sb.toString();
	}
	

}
