import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * @author ravik
 * Here we are using stack data structure to store the index of prizes in decreasing order.
 */
class StockSpanner {

	Stack<Integer> stq;
	List<Integer> prices;
	
	int index;
	
	public StockSpanner() {
		stq = new Stack<Integer>();
		prices = new ArrayList<Integer>();
		index = 0;
	}

	public int next(int price) {
		int res =0;
		prices.add(price);
		if(stq.isEmpty() && index==0) {
			stq.add(index);
			index++;
			return 1;
		}else {
			while(!stq.isEmpty() && prices.get(stq.peek()) <= price)
				stq.pop();
			
			if(stq.isEmpty())
				res= index+1;
			else
				res= index - stq.peek();
			stq.push(index);
			index++;
			return res;
		}
		
	}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */

public class OnlineStock {

	public static void main(String[] args) {

		StockSpanner sp = new StockSpanner();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
	}
}
