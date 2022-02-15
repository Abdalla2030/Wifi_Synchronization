import java.io.IOException;
class Device extends Thread{
    
	public String name,type;
	public Router router;
	public int connectionNumber;
        
	public Device (String name,String type) {
		this.name = name;
		this.type = type;
	}
        
        @Override
	public void run() {
            
            try {
                deviceConnect() ;
                performActivity();
		deviceDisconnect();
            } catch (IOException ex) {
               // Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
            }
	
	}
	
	
	private void deviceConnect() throws IOException {
		
		connectionNumber = router.startConnection(this);
	}
	
	private void performActivity() throws IOException {
	
		System.out.println("Connection " + connectionNumber + ": " + name + " occupied");
                System.out.println("Connection " + connectionNumber + ": " + name + " login");
		System.out.println("Connection " + connectionNumber + ": " + name+ " performs online activity");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
        
	private void deviceDisconnect() throws IOException {
	
		System.out.println("Connection " + connectionNumber + ": " + name+ " Logged out ");
		router.endConnection(connectionNumber);
	}
}
