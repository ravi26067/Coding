import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetClass {
	
	public static void main(String[] args) {
		/*by default it will call compareTo() but when we pass MyComparator as parameter in constructor it will call compare method.
		if we not passing comparator object , the JVM will call compareTo() which is meant for default natural sorting order.In this 
		After we pass the comparator object the JVM will call compare mehtod meant for customized sorting.
		*/
		TreeSet<Integer> k = new TreeSet<>(new MyComparator());
		k.add(12); 
		k.add(67); // compare(67,12) returns -ve -> compare each element with root 
		k.add(5);
		k.add(20);
		k.add(34);
		System.out.println(k);
	}

}

class MyComparator implements Comparator{
	
	
	//It is mandatory to override compare method of Comparator interface and we should not override equals methods.
	@Override
	public int compare(Object o1, Object o2) {
		
		Integer I1 = (Integer) o1;
		Integer I2 = (Integer) o2;
		
		if(I1< I2)
			return 1;
		else if(I1>I2)
			return -1;
		else return 0;
	}
	
}