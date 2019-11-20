package queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

class Stack{
	
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	static int curr_size ;
	
	public Stack() {
		curr_size = 0;
	}
	
	static void push(int x) {
		
		q2.add(x);
		curr_size++;
		
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	static int pop() throws Exception{
		if(!q1.isEmpty()) {
			curr_size--;
			return q1.remove();
		}
		else
		{
			throw new EmptyStackException();
		}
	}
	
	static int top() throws Exception{
		
		if(!q1.isEmpty())
			return q1.peek();
		else
			throw new EmptyStackException();
	}
	
}


public class LinkedListUsingQueue {

	public static void main(String[] args) throws Exception {
		
		Stack s = new Stack();
		s.push(5);
		System.out.println("Stack top is:" + s.top());
		s.pop();
		s.pop();
	}

}
