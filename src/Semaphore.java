import java.io.IOException;
class Semaphore {
	
	public int value ;

	public Semaphore(int value) {   
            
            this.value = value; 
        
        }
	
	public synchronized void wait(String device) throws IOException {		  
		value-- ;
		if (value < 0){
                    try {
                        System.out.println(device+" arrived and waiting");
                        wait() ;
                    } catch (InterruptedException ex) {
                        
                    }
                }
					
                else{
			System.out.println(device + " arrived");
                        
                }
	}
	
	public synchronized void signal() { 
            
	  value++ ; 
          if (value <= 0) {
              notify() ;
          }
          
	}
}