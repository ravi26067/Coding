/*
*Comparator is an interface which is used for customized sorting. It contains two methods(compare , equals) but while implementing
we have to strictly override compare method and not equal method as it will use the equal method of Object class.
*Its method signature is public int compare(Object ob1,Object ob2) 
*It provides multiple sequence of sorting as seen below.
*Present in java.util package
*It doesn't effect the class on which sorting is to be performed. Instead we create another class which implements comparator
pass as parameter to Collections.sort()
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student1{
	Integer rollno;
	String name;
	Integer age;
	Student1(int rollno,String name,int age){
	this.rollno=rollno;
	this.name=name;
	this.age=age;
	}
	
}


class NameSotter implements Comparator<Student1>{

	@Override
	public int compare(Student1 o1, Student1 o2) {
		return o1.name.compareToIgnoreCase(o2.name);
	}
	
}

class AgeSotter implements Comparator<Student1>{
	
	@Override
	public int compare(Student1 o1, Student1 o2) {
		return o1.age.compareTo(o2.age);
	}
}

public class ComparatorDemo{
public static void main(String args[]){
	ArrayList<Student1> al=new ArrayList<Student1>();
	al.add(new Student1(101,"Vijay",23));
	al.add(new Student1(106,"Ajay",27));
	al.add(new Student1(105,"Jai",21));

	/*Collection.sort is present in java.util class and used to sort the comparable class object.
	 *It sorts in default sorting order of compareTo method which is ascending. We can't sort list of primitive datatypes 
	 *We can only sort list through this method and not the sets and maps.
	 *To sort list of object which is not comparable use comparator class and pass its instance as a parameter to sort(listObj,comparatorObj) 
	 */
	Collections.sort(al,new NameSotter());
	for(Student1 s1:al)
	System.out.println(s1.rollno+"\t"+s1.name+"\t"+s1.age);
	}
}
