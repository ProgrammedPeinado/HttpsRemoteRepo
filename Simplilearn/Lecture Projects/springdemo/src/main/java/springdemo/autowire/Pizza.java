package springdemo.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="pizza1")
public class Pizza
{
	@Value(value="Margarita")
	private String name;
	@Value(value="Meat")
	private String category;
	@Value(value="Cheese")
	private String crust;
	@Value(value="250.00")
	private double cost;
	
	public Pizza()
	{
		System.out.println("Baking Piza...");
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

	public String getCrust()
	{
		return crust;
	}

	public void setCrust(String crust)
	{
		this.crust = crust;
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
		return "Pizza [name=" + name + ", category=" + category + ", crust=" + crust + ", cost=" + cost + "]";
	}
	
	
}
