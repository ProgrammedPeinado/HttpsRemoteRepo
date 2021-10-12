package springdemo.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaHet
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springdemo/autowire/annotation/beans.xml");
		
		//Solely annotation based can only keep 1 object of each
		Pizza pizza1 = (Pizza) context.getBean("pizza1");
		System.out.println(pizza1);
		
		Drink drink1 = (Drink) context.getBean("drink1");
		System.out.println(drink1);
		
		Order order1 = (Order)context.getBean("order1");
		System.out.println(order1);
	}
}
