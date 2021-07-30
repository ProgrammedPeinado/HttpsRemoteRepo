package lockedmeapp;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe 
{
	private static Scanner input = new Scanner(System.in);	
	private static String sel;
	private static String path = Paths.get("").toAbsolutePath().toString();
	private static final String USER_STORAGE = "\\Implement OOPS using JAVA with Data Structures and Beyond\\src\\ApplicationStorage";
	private static File storage = new File(path+USER_STORAGE);
	private static File[] dir = storage.listFiles();
	
	public static void main(String[] args)
	{
		try 
		{
			mainScreen();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getCause());
		}
		finally
		{
			input.close();
			System.out.println("Thank you for using the LockedMe App.");
		}
	}
	
	private static void mainScreen() throws Exception
	{
		System.out.print("Welcome to the LockedMe app\n designed by Hector Alarcon");
		System.out.println("After the following options, you may input the number corresponding of the option:");
		System.out.println("1. Option");
		System.out.println("2. Option");
		System.out.println("Please type your input of choice: \n");
		sel = input.nextLine();
		Arrays.parallelSort(dir);
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
		if(dir != null)
		{
			for(File f : dir)
				System.out.println(f.getName());
		}
		else
		{
			System.out.println("The current repository is empty.\n\n");
		}
		System.out.print("\n");
		mainScreen();
	}
	
	private static void secondOption() throws Exception
	{
		System.out.println("SecondOptionSelected");
	}
}
