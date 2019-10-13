
/*
There are two basic ways of creating threads
1. Extend from Thread class
2. Implement from Runnable class and pass that in constructor of Thread class
*/

class Runner extends Thread{

	@Override
	public void run() {
		super.run();
		
		for(int i =0; i<10 ;i++) {
			System.out.println("Hello "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

public class BasicThread {

	public static void main(String[] args) {
		
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}

}
