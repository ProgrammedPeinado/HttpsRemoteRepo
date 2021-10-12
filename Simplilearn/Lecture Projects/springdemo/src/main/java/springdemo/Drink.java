package springdemo;

import org.springframework.stereotype.Component;

public class Drink
{
	private String name;
	private String category;
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
