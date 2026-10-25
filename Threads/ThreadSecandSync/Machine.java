package ThreadSecandSync;

public class Machine extends Thread{

	private Parts parts;
	
	public Machine(Parts parts) {
		this.parts = parts;
	}
	
	@Override
	public void run() {
		try {
			for(int i =1; i<=5;i++) {
				parts.makeParts(i);
				//simulate production time
				Thread.sleep(500);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
