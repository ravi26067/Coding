
class Runner1 implements Runnable{

	@Override
	public void run() {
		
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


public class BasicThread1 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner1());
		t1.start();
		
	}

}
