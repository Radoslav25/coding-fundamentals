package ThreadSecurityAndSync;


	class AWaiter extends Thread {
		private Cake cake;

		AWaiter(Cake cake) {
	    	this.cake = cake;
		}

		public void run() {
	    	for (int i = 1; i <= 10; i++) {
	        	try {
	            	cake.serveCake();  // The waiter serves the cake
	            	Thread.sleep(650);  // Simulating time used to serve the cake
	        	} catch (InterruptedException e) {
	            	e.printStackTrace();
	        	}
	    	}
		}
	}

