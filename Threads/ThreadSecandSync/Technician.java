package ThreadSecandSync;

public class Technician extends Thread {

	private Parts parts; 
	 public Technician (Parts parts) {
		 this.parts = parts;
	 }
	 
	 @Override
		public void run() {
			try {
				for(int i =1; i<=5;i++) {
					//simulate assembly time
					Thread.sleep(500);
					parts.assemblePart(i);
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
