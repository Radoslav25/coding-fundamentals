package Oblig2;

public class Main3 {

	
	public static void main(String[] args) {

		System.out.println("I denne simuleringen har vi"
				+ "\n 3 kokker [Anne, Erik, Knut"
				+ "\n 2 servitører [Mia, Per]"
				+ "\n Kapasiteten til brettet er 4 hamburgere."
				+ "\n Vi starter ...");

		Brett3 brett = new Brett3(4);
		Thread c1 = new Thread(new Cook3(brett, "Anne"));
		Thread c2 = new Thread(new Cook3(brett, "Erik"));		
		Thread c3 = new Thread(new Cook3(brett, "Knut"));
		
		Thread s1 = new Thread(new Waiter3(brett, "Mia"));
		Thread s2 = new Thread(new Waiter3(brett, "Per"));
		
		c1.start();
		c2.start();
		c3.start();
		
		s1.start();
		s2.start();
		
	}

}
