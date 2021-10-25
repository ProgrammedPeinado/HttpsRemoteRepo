package springdemo;

import java.util.List;

public class Pizza
{
	private String name;
	private String category;
	private String crust;
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
