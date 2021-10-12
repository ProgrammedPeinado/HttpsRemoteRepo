package springdemo.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="order1")
public class Order
{
	@Value(value="21")
	private int orderId;
	@Autowired
	private Meal meal;
	
	public Order(int orderId, Meal meal)
	{
		System.out.println("Inside order");
		this.orderId = orderId;
		this.meal = meal;		
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", meal=" + meal + "]";
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public Meal getMeal()
	{
		return meal;
	}

	public void setMeal(Meal meal)
	{
		this.meal = meal;
	}
	
	
}
