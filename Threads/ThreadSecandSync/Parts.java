package ThreadSecandSync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parts {

	private int partNumber;
	private boolean isMade = false;
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();
	
	//machine produces parts
	public void makeParts(int partNumber) throws InterruptedException {
		lock.lock();
		try {
		if(isMade) {
			empty.await();;
		}
		this.partNumber = partNumber;
		System.out.println("Part was just made: " + partNumber);
		isMade = true;
		full.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	//tech consumes parts ,assembles.
	public void assemblePart(int partNumber) throws InterruptedException {
		lock.lock(); 
		try {	
		if(!isMade) {
			full.await();
		}
		System.out.println("assembled part: " + partNumber);
		isMade = false;
		empty.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
