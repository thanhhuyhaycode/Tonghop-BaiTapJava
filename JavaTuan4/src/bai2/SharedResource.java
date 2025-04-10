package bai2;
	import java.util.concurrent.locks.Lock;
	import java.util.concurrent.locks.ReentrantLock;

	class SharedResource {
	    static final Lock resource1 = new ReentrantLock();
	    static final Lock resource2 = new ReentrantLock();
	}

	class ThreadA extends Thread {
	    public void run() {
	        while (true) {
	            if (SharedResource.resource1.tryLock()) {
	                try {
	                    System.out.println("Thread A locked resource 1");
	                    try {
	                        Thread.sleep(50); // Giả lập thời gian xử lý
	                    } catch (InterruptedException e) {}

	                    if (SharedResource.resource2.tryLock()) {
	                        try {
	                            System.out.println("Thread A locked resource 2");
	                            System.out.println("Thread A is processing...");
	                            break;
	                        } finally {
	                            SharedResource.resource2.unlock();
	                        }
	                    }
	                } finally {
	                    SharedResource.resource1.unlock();
	                }
	            }
	            try {
	                Thread.sleep(10); // Tránh CPU sử dụng quá mức
	            } catch (InterruptedException e) {}
	        }
	    }
	}

	class ThreadB extends Thread {
	    public void run() {
	        while (true) {
	            if (SharedResource.resource2.tryLock()) {
	                try {
	                    System.out.println("Thread B locked resource 2");
	                    try {
	                        Thread.sleep(50);
	                    } catch (InterruptedException e) {}

	                    if (SharedResource.resource1.tryLock()) {
	                        try {
	                            System.out.println("Thread B locked resource 1");
	                            System.out.println("Thread B is processing...");
	                            break;
	                        } finally {
	                            SharedResource.resource1.unlock();
	                        }
	                    }
	                } finally {
	                    SharedResource.resource2.unlock();
	                }
	            }
	            try {
	                Thread.sleep(10);
	            } catch (InterruptedException e) {}
	        }
	    }

}
