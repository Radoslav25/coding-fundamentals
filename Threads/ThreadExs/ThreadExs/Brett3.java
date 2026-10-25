package Oblig2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Brett3 {

	private final BlockingQueue<Hamburger3>queue;
	public Brett3(int capacity) {
		this.queue = new LinkedBlockingQueue<>(capacity);
	}
	public void leggTilHamburger(Hamburger3 hamburger, Cook3 cook) throws InterruptedException{
		queue.put(hamburger);
		System.out.println(cook.getName() + " la til " + hamburger + " til brettet. Brett: " + queue);
	}
	public void taUtHamburger(Waiter3 waiter)throws InterruptedException{
		Hamburger3 hamburger = queue.take();
		System.out.println(waiter.getName() + " tok " + hamburger + " fra brettet" + queue);
	}
}
