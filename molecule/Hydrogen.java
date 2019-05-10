package molecule;

public class Hydrogen extends Thread {

	private static int carbonCounter = 0;
	private int id;
	private Methane sharedMethane;

	public Hydrogen(Methane methane_obj) {
		Hydrogen.carbonCounter += 1;
		id = carbonCounter;
		this.sharedMethane = methane_obj;
	}

	public void run() {
		try {
			// you will need to fix below
			sharedMethane.mutex.acquire(); // lock mutex for thread
			sharedMethane.addHydrogen();

			// check how many atoms at barrier, if 4 H atoms arrived release along with carbon
			if (sharedMethane.getHydrogen()>=4 && sharedMethane.getCarbon()>=1) 
			{
				System.out.println("---Group ready for bonding---");
				sharedMethane.hydrogensQ.release(4);
				sharedMethane.removeHydrogen(4);
				// System.out.println("Avengers Assemble");
				sharedMethane.carbonQ.release();
				sharedMethane.removeCarbon(1);
			}
			else
			{
				sharedMethane.mutex.release(); // unlock mutex if less than 4 H arrived
			}
			
			sharedMethane.hydrogensQ.acquire();
			sharedMethane.bond("H" + this.id);
			sharedMethane.barrier.b_wait(); // wait for reusable barrier after bonding

		} catch (InterruptedException ex) { /* not handling this */}
		// System.out.println(" ");
	}

}
