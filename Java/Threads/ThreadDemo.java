/**
 * Creating child by extending Thread class which implements Runnable. It is good practice to 
 * override run method because default run method in Thread class doesn't contain any logic.
 * start() is responsible for creating new thread, and calling run method.
 */
public class ThreadDemo {

	public static void main(String[] args) {
		
		Mythread obj1 = new Mythread();
		obj1.start();
		for(int i =0 ;i<10;i++)
			System.out.println("Executing parent thread..."+ i);
		
	}

}

class Mythread extends Thread{
	
	@Override
	public void run() {
		for(int i =0 ;i<10;i++)
			System.out.println("Executing child thread..."+ i);
	}
}