package bai1;
import java.util.concurrent.locks.ReentrantLock;
 class Chopstick {	
	    private final ReentrantLock lock = new ReentrantLock();
	    public boolean pickUp() {
	        return lock.tryLock();
	    }
	    public void putDown() {
	        lock.unlock();
	    }

}
