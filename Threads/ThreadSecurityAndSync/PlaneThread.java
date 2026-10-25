package ThreadSecurityAndSync;

class PlaneThread extends Thread {
	private Runway runway;
	private String planeName;

	PlaneThread(Runway runway, String planeName) {
    	this.runway = runway;
    	this.planeName = planeName;
	}

	public void run() {
    	runway.useRunway(planeName);
	}

	public static void main(String[] args) {
    	Runway runway = new Runway();

    	// Create multiple threads that represent different flights
    	PlaneThread t1 = new PlaneThread(runway, "Fly 1");
    	PlaneThread t2 = new PlaneThread(runway, "Fly 2");
    	PlaneThread t3 = new PlaneThread(runway, "Fly 3");

    	t1.start();
    	t2.start();
    	t3.start();

    	try {
        	t1.join();
        	t2.join();
        	t3.join();
    	} catch (InterruptedException e) {
        	e.printStackTrace();
    	}

    	System.out.println("Runway status after flights: " + runway.getRunwayStatus());
	}
}
