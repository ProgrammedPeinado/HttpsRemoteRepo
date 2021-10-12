package springdemo.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Meal
{
	@Value(value="BigSaver")
	private String name;
	@Autowired
	private Pizza pizza;
	@Autowired
	private Drink drink;
	
	Meal()
	{
		System.out.println("Prepping meal");
	}
	
	Meal(Pizza pizza, Drink drink)
	{
		this.pizza = pizza;
		this.drink = drink;
	}

	public Pizza getPizza()
	{
		return pizza;
	}

	public void setPizza(Pizza pizza)
	{
		this.pizza = pizza;
	}

	public Drink getDrink()
	{
		return drink;
	}

	public void setDrink(Drink drink)
	{
		this.drink = drink;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Meal [name=" + name + ", pizza=" + pizza + ", drink=" + drink + "]";
	}
	
	
	
}
