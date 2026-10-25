package ThreadSecurityAndSync;

public class Cake {
	private int cakeNumber;
	private boolean isBaked = false;

	// The baker bakes cake
	public synchronized void bakeCake(int cakeNumber) throws InterruptedException {
    	while (isBaked) {
        	wait();  // Wait until the waiter has served the cake
    	}
    	this.cakeNumber = cakeNumber;
    	isBaked = true;
    	System.out.println("Baked cake nr: " + cakeNumber);
    	notify();  // Notify the waiter that the cake is ready 
	}

	// The waiter serves a cake
	public synchronized void serveCake() throws InterruptedException {
    	while (!isBaked) {
        	wait();  // Wait until the cake is baked
    	}
    	System.out.println("Served cake nr: " + cakeNumber);
    	isBaked = false;
    	notify();  // Notify the baker that there is room to bake more cakes
	}
}

