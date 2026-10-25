package ThreadSecurityAndSync;

public class BakerySimulation {
	public static void main(String[] args) {
    	Cake cake = new Cake();  // Common resource
    	new Baker(cake).start();  // Starts baker's thread
    	new AWaiter(cake).start();  // Starts waiter's thread
	}
}

