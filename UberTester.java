import java.util.Random;

public class UberTester {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Location[] l= new Location [10];
		Location[] dests = new Location[6];
		Area a = new Area();
		for(int i = 0; i < l.length;i++) {
			l[i] = new Location(rand.nextInt(300),rand.nextInt(300));
		}
		for(int i = 0; i < dests.length;i++) {
			dests[i] = new Location(rand.nextInt(300),rand.nextInt(300));
		}
		
		Driver d1 = new Driver("Christian", 300, l[0]);
		Driver d2 = new Driver("Michael", 300, l[1]);
		Driver d3 = new Driver("Gary", 300, l[2]);
		Driver d4 = new Driver("Sam", 300, l[3]);
		
		Passenger p1 = new Passenger("Eric", 300, l[4]);
		Passenger p2 = new Passenger("Errick", 300, l[5]);
		Passenger p3 = new Passenger("Victor", 300, l[6]);
		Passenger p4 = new Passenger("Javi", 300, l[7]);
		Passenger p5 = new Passenger("Nayele", 300, l[8]);
		Passenger p6 = new Passenger("Clarisa", 300, l[9]);
		Management manager = new Management(a);
		
		manager.addDriver(d1);
		manager.addDriver(d2);
		manager.addDriver(d3);
		manager.addDriver(d4);
		p1.requestRide(manager, dests[0]);
		p2.requestRide(manager, dests[1]);
		p3.requestRide(manager, dests[2]);
		p4.requestRide(manager, dests[3]);
		p5.requestRide(manager, dests[4]);
		p6.requestRide(manager, dests[5]);		
		
	}

}
