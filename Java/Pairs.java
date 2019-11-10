import java.util.ArrayList;
import java.util.List;

public class Pairs {

	public static void main(String[] args) {
		List<Pair<Integer,Integer>> arr = new ArrayList<>(5);
		for(int i =0 ;i<5 ;i++) {
			arr.add(new Pair<Integer, Integer>(i, i*i));
		}
		
		for(int i =0 ;i<arr.size();i++) {
			System.out.println("value of first:"+ arr.get(i).getFirst() +" Value of second:"+ arr.get(i).getSecond());
		}
		
	}

}


class Pair<T,U>{
	
	private T first;
	private U second;
	
	Pair() {
	}
	
	Pair(T obj1,U obj2) {
		first = obj1;
		second = obj2;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}
	
}