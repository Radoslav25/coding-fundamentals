package ThreadSecurityAndSync;

public class Baker extends Thread{
	private Cake cake;

	Baker(Cake cake) {
    	this.cake = cake;
	}

	public void run() {
    	for (int i = 1; i <= 10; i++) {
        	try {
            	cake.bakeCake(i);  // The baker bakes cake nr. i
            	Thread.sleep(500);  // Simulating time used to bake the cake
        	} catch (InterruptedException e) {
            	e.printStackTrace();
        	}
    	}
	}
}

