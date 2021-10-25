package springdemo.collections;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaHet
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springdemo/collections/beans.xml");
		
		//Collections bean wiring using tags in beans
		//Pizza pizza1 = (Pizza) context.getBean("pizza1");
		//System.out.println(pizza1);
		
		Customer customer1 = (Customer) context.getBean("customer1");
		System.out.println(customer1);
		
		//Order order1 = (Order) context.getBean(Order.class);// When theres only 1 order class
		Set<String> addresses = customer1.getAddress();
		System.out.println(addresses.getClass().getName());
		System.out.println(customer1.getOrders().getClass().getName());
	}
}
