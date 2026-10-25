package ThreadSecurityAndSync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runway {
	private final Lock lock = new ReentrantLock();
	private String runwayStatus = "Free";

	// Method to get access to the runway
	public void useRunway(String planeName) {
    	boolean lockAcquired = false;
    	
    	try {
        	// Attempt to acquire the lock, waiting up to 2 seconds
        	lockAcquired = lock.tryLock(4, TimeUnit.SECONDS);
        	
        	if (lockAcquired) {
            	runwayStatus = "Used by " + planeName;
            	System.out.println(planeName + " uses the runway.");
            	Thread.sleep(1000);  // Simulate using the runway
            	runwayStatus = "Free";
        	} else {
            	// If lock was not acquired, handle this case (e.g., retry later)
            	System.out.println(planeName + " could not use the runway. Runway is used.");
        	}
    	} catch (InterruptedException e) {
        	e.printStackTrace();
    	} finally {
        	// Only unlock if the lock was actually acquired
        	if (lockAcquired) {
            	lock.unlock();
        	}
    	}
	}


	public String getRunwayStatus() {
    	return runwayStatus;
	}
}
