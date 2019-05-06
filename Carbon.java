import java.util.concurrent.Semaphore;
import java.util.Random;
//package molecule;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Methane sharedMethane;
	//private Semaphore mutex;

	public Carbon(Methane methane_obj) {
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedMethane = methane_obj;
		//this.mutex = new Semaphore(1);
	}
	
	public void run() {
	    try {	 
			// you will need to fix below	
			sharedMethane.mutex.acquire();
			sharedMethane.addCarbon();
			if(sharedMethane.getHydrogen()>=4)
			{
				sharedMethane.hydrogensQ.release(4);
				sharedMethane.removeHydrogen(4);
				sharedMethane.carbonQ.release();
				sharedMethane.removeCarbon(1);
			}
			else
			{
				sharedMethane.mutex.acquire();
			}
			sharedMethane.carbonQ.acquire();
			sharedMethane.bond("C"+ this.id);  //bond
			System.out.println("---Group ready for bonding---");
			sharedMethane.barrier.b_wait();
			sharedMethane.mutex.release();
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
