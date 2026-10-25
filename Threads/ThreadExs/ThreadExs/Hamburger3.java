package Oblig2;

import java.util.concurrent.atomic.AtomicInteger;

public class Hamburger3 {

	private static final AtomicInteger count = new AtomicInteger(0);
	private int number;
	
	public Hamburger3() {
		this.number = count.incrementAndGet();
	}
	public int getNumber() {
		return number;
	}
	public String toString() {
		return "" + number;
	}
}

