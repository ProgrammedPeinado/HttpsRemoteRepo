package calculator;

import java.util.Scanner;

//This calculator performs arithmetic operations on int values
public class Calculator 
{
	public static void main(String[] args)
	{
		int a, b, choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which operation would you like to perform?");
		System.out.println("1. addition");
		System.out.println("2. substraction");
		System.out.println("3. multiplication");
		System.out.println("4. division");
		choice = input.nextInt();
		
		System.out.println("Please, input the first number.");
		a = input.nextInt();
		System.out.println("Please, input the second number.");
		b = input.nextInt();
		
		switch(choice)
		{
			case 1:
				System.out.println("Result: "+Calculator.add(a,b));
				break;
			case 2:
				System.out.println("Result: "+Calculator.sub(a,b));
				break;
			case 3:
				System.out.println("Result: "+Calculator.mult(a,b));
				break;
			case 4:
				System.out.println("Result: "+Calculator.div(a,b));
				break;
			default:
				System.out.println("Invalid input.");
		}
		
		input.close();
		
	}
	
	public static int add(int a, int b)
	{
		return(a+b);
	}
	
	public static int sub(int a, int b)
	{
		return(a-b);
	}
	
	public static int mult(int a, int b)
	{
		return(a*b);
	}

	public static int div(int a, int b)
	{
		return(a/b);
	}
}
