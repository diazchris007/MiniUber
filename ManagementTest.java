import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

class ManagementTest {

	@Test
	void test() {
		Area a = new Area();
		List <Driver> drivers = new ArrayList<Driver>();
		List <Passenger>passengers = new ArrayList<Passenger>();

		Management manager = new Management(a);
		Gson g = new Gson();
		Random rand = new Random();

		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\TheTaco\\Desktop\\eclip\\ws\\MiniUber\\src\\input.txt"))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.contains("available")) {
					manager.addDriver((Driver)g.fromJson(sCurrentLine,Driver.class));
					
				}
				else if(sCurrentLine.length() >0) {
					try {
					manager.addPassenger((Passenger)g.fromJson(sCurrentLine,Passenger.class));
					}catch(Exception e){
						System.out.println("Could not create object from file");
					}
				}
			}
			Location[] dests = new Location[3];
			
			dests[0] = new Location(0,3);
			dests[1] = new Location(3,0);
			dests[2] = new Location(2,3);
			
			
			passengers = manager.getPassengers();
			drivers = manager.getDrivers();
			int i = 0;
			for(Passenger p : passengers) {
				//System.out.println(p.toString());
				try {
					Thread.currentThread().sleep(1000);
					
				}catch(InterruptedException e) {}

				System.out.println("--------------\n");
				p.requestRide(manager, dests[i++]);
			}
	}catch(Exception e) {}
	}
	

}
