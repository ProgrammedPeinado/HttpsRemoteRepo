package springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaHet
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springdemo/beans.xml");
		
		Pizza pizza1 = (Pizza) context.getBean("pizza1");
		System.out.println(pizza1);
		
		//or type based, but because theres 2. It will give us a non unique identifier error
		//pizza = context.getBean(Pizza.class);
		//System.out.println(pizza);
		
		Pizza pizza2 = (Pizza) context.getBean("pizza2");
		System.out.println(pizza2);
		
		Drink drink1 = (Drink) context.getBean("drink1");
		System.out.println(drink1);
		
		Meal meal1 = (Meal) context.getBean("meal1");
		System.out.println(meal1);
		
		Pizza pizza3 = (Pizza) context.getBean("pizza3");
		System.out.println(pizza3);
	}
}
