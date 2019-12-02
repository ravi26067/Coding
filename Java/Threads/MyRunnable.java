
/**
 * Runnable interface just contain only one method run(). We need to create new Thread object 
 * and pass the target runnable i.e object of runnable to start new thread. As Thread class
 * implements runnable interface , we can use Thread class object also as target runnable, it 
 * won't throw error.
 */
public class MyRunnable {

	public static void main(String[] args) {
		Runnable r1 = new MyRunnableThread();
		//MyThreadNew t1 = new MyThreadNew();
		Thread t = new Thread(r1);
		t.start();
		for(int i = 0 ;i<5 ;i++)
			System.out.println("This is parent thread.." + i);
	}
}

class MyRunnableThread implements Runnable{
	
	//job of threadn 
	public void run() {
		for(int i = 0 ;i<5 ;i++)
			System.out.println("This is child thread using runnable.." + i);
	}
}

/*class MyThreadNew extends Thread{
	@Override
	public void run() {
		for(int i = 0 ;i<5 ;i++)
			System.out.println("This is child thread using Thread.." + i);
	}
}*/
