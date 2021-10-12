package springdemo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMain
{

	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springdemo/jdbc/beans.xml");
		
	}

}
