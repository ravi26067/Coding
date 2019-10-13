
public class ThreadSyncronization {
	
	private int count = 0;

	public static void main(String[] args) {
		
		ThreadSyncronization ts = new ThreadSyncronization();
		ts.doWork();
	}

	public synchronized void increment() {
		count++;
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000;i++)
					count++;
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000;i++)
					count++;
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Value of count: "+count);
	}
	
}
