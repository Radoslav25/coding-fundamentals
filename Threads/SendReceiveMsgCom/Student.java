package SendReceiveMsgCom;


class Counter	{
	 private int counter;
	  public void increment() {
		  synchronized(this) {
		  counter++;
		  }
	  }
	  public synchronized int getCount() {
		  return counter;
	  }
	  	 }
class Student extends Thread {
	 private Counter counter;
	 
	 Student(Counter counter){
		 this.counter=counter;
	 }
	 public void run() {
		
		 for(int i=0; i<1000;i++) {
			 counter.increment();
		 }
		 
	 }
	 public static void main(String[]args) {
		Counter counter = new Counter();
		Student t1 = new Student(counter);
		Student t2 = new Student(counter);
		
	      t1.start();
	        t2.start();
	        try {
	        	t1.join();
	        	t2.join();
	        } catch(InterruptedException e) {
	        	e.printStackTrace();
	        }
	        System.out.println("final vlaue: " + counter.getCount());
	 }
}
