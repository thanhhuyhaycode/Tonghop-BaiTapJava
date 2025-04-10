package Bai1;
import java.lang.Thread;
public class InSoChanLe {
		public static class soChan extends Thread{
			public void run() {
				int n=10;
				for(int i=0;i<=n;i++) {
					if(i%2==0){
						System.out.println("Số chẵn:"+i);
						
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return ;
					}
				}
			}
		}
		public static class soLe extends Thread{
			public void run() {
				int n=10;
				for(int i=0;i<=n;i++) {
					if(i%2!=0){
						System.out.println("Số lẻ:"+i);
						
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
			}
			
		}	
		public static void main(String[] args) {
			Thread soChan = new soChan();
			Thread soLe=new soLe();
			soChan.start();
			soLe.start();
		}
		
		
		
		
		
	}
		

	


