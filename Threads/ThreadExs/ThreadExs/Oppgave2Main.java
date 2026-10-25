package Oblig2;

import java.util.LinkedList;
import java.util.Queue;

public class Oppgave2Main {

	private static final int BRETT_CAPACITY = 4;
	public static void main(String[] args) {
		
		
		System.out.println("I denne simuleringen har vi"
				+ "\n 3 kokker [Anne, Erik, Knut"
				+ "\n 2 servitører [Mia, Per]"
				+ "\n Kapasiteten til brettet er 4 hamburgere."
				+ "\n Vi starter ...");

		Brett brett = new Brett(BRETT_CAPACITY);
		Thread c1 = new Thread(new Cook(brett, "Anne"));
		Thread c2 = new Thread(new Cook(brett, "Erik"));		
		Thread c3 = new Thread(new Cook(brett, "Knut"));
		
		Thread s1 = new Thread(new Waiter(brett, "Mia"));
		Thread s2 = new Thread(new Waiter(brett, "Per"));
		
		c1.start();
		c2.start();
		c3.start();
		
		s1.start();
		s2.start();
		
		
	}
	
}
