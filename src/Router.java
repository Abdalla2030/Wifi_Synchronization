import java.io.IOException;
import java.util.ArrayList;

class Router {
    
	private Semaphore semaphore;
	int maxNumberOfConnections;
	ArrayList<Integer> connectionsDevices;
        
	public Router(int maxNumberOfConnections, int maxNumberOfDevices) {
		this.maxNumberOfConnections = maxNumberOfConnections;
		connectionsDevices = new ArrayList<Integer>();
		semaphore = new Semaphore(maxNumberOfConnections);
		for (int i=0; i< maxNumberOfConnections; i++) {
			connectionsDevices.add(0);
		}
	}
	
	public int startConnection(Device d) throws IOException{
            
		semaphore.wait(d.name + "("+d.type+")");
		int connectionNumber = 0; 
		for (int i=0; i<maxNumberOfConnections; i++) {
			if (connectionsDevices.get(i) == 0) {
				connectionsDevices.set(i,1);
				connectionNumber = i+1;
				break;
			}
		}
		return connectionNumber;
		
	}
	public void endConnection(int connectionNumber) {
		connectionsDevices.set(connectionNumber-1,0);
		semaphore.signal();
	}

}
