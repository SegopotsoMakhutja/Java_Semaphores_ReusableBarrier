package molecule;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Carbon extends Thread {

	private static int carbonCounter = 0;
	private int id;
	private Methane sharedMethane;

	public Carbon(Methane methane_obj) {
		Carbon.carbonCounter += 1;
		id = carbonCounter; // id for the atoms
		this.sharedMethane = methane_obj; // sharedMethane obj
	}

	public void run() {
		try {
			// you will need to fix below
			sharedMethane.mutex.acquire(); // mutex lock for one thread
			sharedMethane.addCarbon(); // add carbon atom to the methane molecule

			// check how many atoms at barrier
			if (sharedMethane.getHydrogen() >= 4)
			{
				sharedMethane.hydrogensQ.release(4);
				sharedMethane.removeHydrogen(4);
				sharedMethane.carbonQ.release();
				sharedMethane.removeCarbon(1);
			} 
			else 
			{
				sharedMethane.mutex.acquire(); // unlock mutex
			}
			sharedMethane.carbonQ.acquire();
			sharedMethane.bond("C" + this.id); // bond
			sharedMethane.barrier.b_wait(); 
			sharedMethane.mutex.release(); // unlock mutex
		} catch (InterruptedException ex) { /* not handling this */ }
		// System.out.println(" ");
	}
}
