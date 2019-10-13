
import java.util.Scanner;

class Processer extends Thread{

	private volatile boolean running = true;
	
	public void run() {
		
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void shutdown() {
		running = false;
	}
	
	
}

public class ThreadSync {

	public static void main(String[] args) {
		Processer p1 = new Processer();
		p1.start();
		System.out.println("Press any key to stop..");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		p1.shutdown();
		
	}

}
