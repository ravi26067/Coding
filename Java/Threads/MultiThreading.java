
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*Syncronised is used to stop multiple write by multiple threads. Here we only made the shared code as syncronised.
It is reducing the overall execution time of program.*/

public class MultiThreading {

	private List<Integer> list1 = new ArrayList<Integer>(); 
	private List<Integer> list2 = new ArrayList<Integer>(); 
	
	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	
	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for(int i = 0 ;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public static void main(String[] args) {
		MultiThreading m1 = new MultiThreading();
		m1.logic();
	}
	
	public void logic () {
		System.out.println("Starting......");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
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
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken :"+(end-start));
		System.out.println("List 1 size:"+ list1.size()+",List 2 size:"+list2.size());
	}

}
