package lockedmeapp;

import java.util.Scanner;

public class LockedMe 
{
	private static Scanner input = new Scanner(System.in);
	private static String sel;
	
	public static void main(String[] args)
	{
		try 
		{
			mainScreen();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			input.close();
		}
	}
	
	private static void mainScreen() throws Exception
	{
		System.out.print("Welcome to the LockedMe app\n designed by Hector Alarcon");
		System.out.println("After the following options, you may input the number corresponding of the option:");
		System.out.println("1. Option");
		System.out.println("2. Option");
		System.out.println("Please type your input of c1hoice: \n");
		sel = input.nextLine();
		if(sel.startsWith("1") || sel.equalsIgnoreCase("o"))
		{
			firstOption();
		}
		else if(sel.startsWith("2") || sel.equalsIgnoreCase("t"))
		{
			secondOption();
		}

	}
	
	private static void firstOption() throws Exception
	{
		System.out.println("FirstOptionSelected");
	}
	
	private static void secondOption() throws Exception
	{
		System.out.println("SecondOptionSelected");
	}
}
