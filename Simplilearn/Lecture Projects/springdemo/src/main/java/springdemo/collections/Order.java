package springdemo.collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="order1")
public class Order
{
	@Value(value="21")
	private int orderId;
	@Autowired
	@Qualifier(value="meal1")
	private List<Meal> meals;
	
	public Order()
	{
		
	}
	
	public Order(int orderId, List<Meal> meals)
	{
		super();
		this.orderId = orderId;
		this.meals = meals;
	}
	
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public List<Meal> getMeal()
	{
		return meals;
	}
	public void setMeal(List<Meal> meals)
	{
		this.meals = meals;
	}
	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", meals=" + meals + "]";
	}
	
	
	
	
}
