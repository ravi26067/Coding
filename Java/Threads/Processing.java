
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processing implements Runnable{
	
	private int id;
	
	public Processing(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting process:"+id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed process:"+id);
	}
	
}



public class ThreadPooling {

	public static void main(String[] args) {
		ThreadPooling m1 = new ThreadPooling();
		m1.logic();
	}

	public void logic() {
		ExecutorService execute = Executors.newFixedThreadPool(10);
		for(int i=0;i<50;i++) {
			execute.submit(new Processing(i));
		}
		
		execute.shutdown();
		System.out.println("All tasks are successfully submitted.");
		
		try {
			execute.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks are successfully completed.");
	}
	
}
