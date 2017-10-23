
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


import com.google.gson.Gson;

public class UberTester {

	public static void main(String[] args) {

		Area a = new Area();
		List<Driver> drivers = new ArrayList<Driver>();
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
					manager.addPassenger((Passenger)g.fromJson(sCurrentLine,Passenger.class));
				}
			}
			/*
			Location[] dests = new Location[manager.getPassengers().size()];
			for(int i = 0; i < dests.length;i++) {
				dests[i] = new Location(rand.nextInt(15),rand.nextInt(15));
			}
			*/
			passengers = manager.getPassengers();
			drivers = manager.getDrivers();
			int i = 0;
			manager.getArea().printArea();
			Location[] dests = new Location[3];
			
			dests[0] = new Location(0,3);
			dests[1] = new Location(3,0);
			dests[2] = new Location(20,3);
			
			passengers.get(0).requestRide(manager, dests[0]);
			try {
				Thread.currentThread().sleep(1000);
				
			}catch(InterruptedException e) {}

			passengers.get(1).requestRide(manager, dests[1]);
			try {
				Thread.currentThread().sleep(1000);
				
			}catch(InterruptedException e) {}

			passengers.get(2).requestRide(manager, dests[2]);

			try {
				Thread.currentThread().sleep(1000);
				
			}catch(InterruptedException e) {}
			
			manager.printTrips();
			manager.finalPrint();
			manager.getArea().printArea();
		}catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
