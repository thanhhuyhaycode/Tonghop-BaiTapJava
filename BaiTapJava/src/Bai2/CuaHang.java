package Bai2;
import java.lang.Thread;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CuaHang extends Thread {
	    private int n = 10; // số vé ban đầu
	    private final Lock lock = new ReentrantLock();
	    private final Random random = new Random();
//kiểm tra số vé
	    public boolean kiemTraVe() {
	        if (n <= 0) {
	            System.out.println("Đã Hết Vé!");
	            return false;
	        } else {
	            System.out.println("Còn Vé! Số vé còn lại: " + n);
	            return true;
	        }
	    }
//chọn vé
	    public boolean chonVeNgauNhien() {
	        if (n <= 0) {
	            System.out.println("Vé Không Tồn Tại!");
	            return false;
	        }
	        int ve = random.nextInt(n) + 1; 
	        System.out.println("Đã Chọn Vé Thành Công! Vé số: " + ve);
	        return true;
	    }

	    
	    public void bookTicket(String buyer) {
	        lock.lock(); 
	        try {
	            if (kiemTraVe()) {
	                if (chonVeNgauNhien()) {
	                    System.out.println(buyer + " đang mua vé...");
	                    Thread.sleep(100);
	                    n--; 
	                    System.out.println(buyer + " đã mua vé. Vé còn lại: " + n);
	                }
	            } else {
	                System.out.println(buyer + " không thể mua vé. Hết vé!");
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            lock.unlock(); 
	        }
	    }
	


}

	

	
	

