import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	
	public static void demoBeanFactory(){
		
		//Spring way|  IOC
		Resource resource = new ClassPathResource("employeebean.xml");
		//BeanFactory interface is spring container responsible for creating objects.
		BeanFactory factory = new XmlBeanFactory(resource); //Spring container which shall parse xml file and constructs object
		
	}
	
	public static void demoApplicationontext(){
		
		//Application context is implementaion of Bean factory and is also responsible for creating object(IOC)
		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		/*Application context will create objects by itself weather we will call getbean or not but BeanFactory will create
		*object only when getBean is called.  
		*/
		Employee e1 = (Employee) context.getBean("emp1");
		
		Employee e2 = (Employee) context.getBean("emp2", Employee.class);
				
		System.out.println("Employee1 Details: "+e1);
		System.out.println("Employee2 Details: "+e2);
		
		//we are downcasting context so that we can destroy the object
		ClassPathXmlApplicationContext cls = (ClassPathXmlApplicationContext) context;
		cls.close();
	}

	/*You need to add spring framework related jar to your reference libraries to make this program work
	*/
	public static void main(String[] args) {
		demoApplicationontext();
	}

}
