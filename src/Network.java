// Abdalla Fadl Shehata
// 20190305
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Network {
    
    public static void main(String[] args) throws FileNotFoundException {
                int maxNumberOfConnections;
		int maxNumberOfDevices;
		ArrayList<Device> devices = new ArrayList<Device>();
		Scanner input = new Scanner(System.in);
		System.out.println("What is number of WI-FI Connections?");
		maxNumberOfConnections = input.nextInt();
		System.out.println("What is number of devices Clients want to connect?");
		maxNumberOfDevices = input.nextInt();
		
		for (int i=0 ; i<maxNumberOfDevices ; i++) {
			String name = input.next();
			String type = input.next();
			devices.add(new Device(name,type));
		}
		
		Router router = new Router(maxNumberOfConnections, maxNumberOfDevices);
		
		for (int i=0; i<maxNumberOfDevices ; i++) {
			devices.get(i).router = router;
			devices.get(i).start();
		} 
                
           
	}
}