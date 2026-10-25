package Oblig2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class O2Hamburger {

	private static final AtomicInteger count = new AtomicInteger(0);
	private final int number;
	
	public O2Hamburger() {
		this.number = count.incrementAndGet();
	}
	public int getNumber() {
		return number;
	}
	public String toString() {
		return "" + number;
	}
}

class Brett {
	private Queue<O2Hamburger>q = new LinkedList<>();
	private final int capacity;
	
	private final Lock lock = new ReentrantLock();
	private final Condition nextCookCondition = lock.newCondition();
	
	private int nextCook = 1;
	
	public Brett(int capacity) {
		this.capacity = capacity;
	}
	 
	public synchronized void addHam(O2Hamburger ham, Cook cook) throws InterruptedException {
		while(q.size()==capacity) {
			System.out.println("Brett er full. " + cook.getNavn() + " (cook) venter.");
			wait();
		}
		q.add(ham);
		System.out.println(cook.getNavn() + " Kokk lagt til burger nummer: " + ham.getNumber() + " på brettet. Brett: " + q.toString());
		notifyAll();
	}
	
	public synchronized void taHam(Waiter waiter) throws InterruptedException {
		while(q.isEmpty()) {
			System.out.println("brett er tom. " + waiter.getNavn() + " (waiter) venter!");
			wait();
		}
		O2Hamburger hamb = q.poll();
		System.out.println(waiter.getNavn() + " Servitor tok hamburger nummer: " + hamb.getNumber() + " fra brettet. Brett: " + q.toString());
		notifyAll();
	}
	
	
}







