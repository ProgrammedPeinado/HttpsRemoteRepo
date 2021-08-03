package lockedmeapp;

import java.io.File;
import java.io.IOException;
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
		catch (IOException e) 
		{
			System.out.println("Something went wrong on the file directory.");
			System.out.println(e.getCause());
		}
		catch (Exception e) 
		{
			System.out.println("Something went wrong.");
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
		System.out.print("Welcome to the LockedMe app\ndesigned by Hector Alarcon");
		System.out.println("Please select among the following options by typing the corresponding number:");
		System.out.println("1. Inspect current directory.");
		System.out.println("2. File handeling.");
		System.out.println("3. Exit application.\n");
		sel = input.nextLine();
		
		updateList();
		Arrays.parallelSort(dir); //Updating the stored files if any had been modified.
		
		if(sel.startsWith("1") || sel.equalsIgnoreCase("o"))
		{
			firstOption();
		}
		else if(sel.startsWith("2") || sel.equalsIgnoreCase("t"))
		{
			secondOption();
		}
		else if(sel.startsWith("3") || sel.equalsIgnoreCase("thr"))
		{
			System.out.println("Exiting..");
		}
	}
	
	private static void firstOption() throws Exception
	{
		if(dir != null)
		{
			System.out.println("You have the following files stored:");
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
	
	private static void secondOption() throws IOException, Exception
	{
		
		System.out.println("Please select among the following options by typing the corresponding number:");
		System.out.println("1. Add a file to existing directory.");
		System.out.println("2. Delete a file from existing directory.");
		System.out.println("3. Search for a file from existing directory.");
		System.out.println("4. Return to main menu.\n");
		sel = input.nextLine();
		
		switch(sel.charAt(0))
		{
			case('1'):
			{	
				System.out.println("Please type the name of the new file:\n");
				sel = input.nextLine();
				File upload = new File(storage.getAbsoluteFile()+"\\"+sel.toLowerCase());
				if(upload.createNewFile())
				{
					System.out.println("File created successfully.\n");
				}
				else
				{
					System.out.println("File already exists.\n");
				}
				updateList();
				Arrays.parallelSort(dir); 
				secondOption();
				break;
			}
			case('2'):
			{
				System.out.println("Please type the name of the file you want to delete:\n");
				sel = input.nextLine();
				boolean deleted = false;
				int i=1;
				for(File f: dir)
				{
					if(f.getName().equals(sel))
					{
						f.delete();
						deleted = true;
						System.out.println("File deleted successfully.\n");
					}
					else if(i == dir.length-1 && deleted == false)
					{
						System.out.println("File not found.\n");
					}
					i++;
				}
				//No need to sort after elimination since the rest of the files will be sorted already
				updateList();
				secondOption();
				break;
			}
			case('3'):
			{
				System.out.println("Please type the name of the file you are looking for:\n");
				sel = input.nextLine();
				boolean found = false;
				int i=0;
				
				for(File f: dir)
				{
					if(f.getName().equals(sel))
					{
						found = true;
						System.out.println(dir[i].getName()+" has been found in position "+i+" of the directory.\n");
					}
					else if(i == dir.length-1 && found == false)
					{
						System.out.println("File not found.\n");
					}
					i++;
				}
				secondOption();	
				break;
			}
			case('4'):
			{
				mainScreen();
				break;
			}
		}
	}
	
	private static void updateList()
	{
		dir = storage.listFiles();
	}
}
