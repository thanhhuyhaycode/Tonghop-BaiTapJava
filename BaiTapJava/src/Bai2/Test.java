package Bai2;
import Bai2.CuaHang;
public class Test extends Thread {
	public static void main(String[] args) {
		CuaHang system = new CuaHang();
	        for (int i = 1; i <= 10; i++) {
	            String buyerName = "Khách " + i;
	            new Thread(() -> system.bookTicket(buyerName)).start();
	        }
	}
}
