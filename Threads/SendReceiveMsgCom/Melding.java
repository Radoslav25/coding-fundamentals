package SendReceiveMsgCom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Melding {

    private String melding;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    private boolean meldingLest = true; 
    
    public String getMelding() {
        lock.lock();
        try {
            while (meldingLest) {  
                condition.await();        
            }
            meldingLest = true; // Mark as read after retrieving
            condition.signalAll();
            return melding;
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void setMelding(String melding) {
        lock.lock();
        try {
            while (!meldingLest) { // Wait until the previous message has been read
                condition.await();
            }
            this.melding = melding;
            meldingLest = false; // A new unread message exists
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}