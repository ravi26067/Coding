
import java.util.ArrayList;
import java.util.Collections;
/*
*Comparable is an interface present in java.lang package.
*Comparable has by default one method which is public int compareTo(Object o)
*This compareTo is used as default sorting method in Collection.sort() and also when we insert element in TreeHashSet()
*All wrapper classes(Integer,String,etc.) implements Comparable interface
*/
class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private int age;
	
	public Student(int id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student s) {
		
		if(age==s.age)
			return 0;
		else if (age>s.age)
			return 1;
		else
			return -1;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}


public class ComparableDemo {
	
	public static void main(String[] args) {
		ArrayList<Student> arr = new ArrayList<>();
		arr.add(new Student(101, "Ravi", 24));
		arr.add(new Student(102,"Vivek",27));
		arr.add(new Student(103,"Mohit",20));
		Collections.sort(arr);
		
		
		
		for(Student s:arr)
		System.out.println(s.getId()+"\t"+ s.getName()+ "\t"+ s.getAge());
		
		
		//Array
	}

}
