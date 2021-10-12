package springdemo.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="drink1")
public class Drink
{
	@Value(value="Tea")
	private String name;
	@Value(value="Hot beaverages")
	private String category;
	@Value(value="100")
	private double cost;
	
	public Drink()
	{
		System.out.println("Serving drink");
	}
	public Drink(String name, String category, double cost)
	{
		this.name =name;
		this.category =category;
		this.cost =cost;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public double getCost()
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}
	@Override
	public String toString()
	{
		return "Drink [name=" + name + ", category=" + category + ", cost=" + cost + "]";
	}
	
	
}
