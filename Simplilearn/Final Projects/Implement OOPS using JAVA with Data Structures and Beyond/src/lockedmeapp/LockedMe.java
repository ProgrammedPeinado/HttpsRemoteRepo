package lockedmeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe 
{
	//Class variable declaration; most of these are resources we reuse multiple times throughout the program.
	private static Scanner input = new Scanner(System.in);	
	private static String sel;
	private static String path = Paths.get("").toAbsolutePath().toString();
	private static final String USER_STORAGE = "\\Implement OOPS using JAVA with Data Structures and Beyond\\src\\ApplicationStorage";
	private static File storage = new File(path+USER_STORAGE);
	private static File[] dir = storage.listFiles();
	
	public static void main(String[] args)
	{
		//Kept main method clean and only handeling the exceptions form the screen methods.
		try 
		{
			mainScreen();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File was not found in directory.");
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
			System.out.println("Thank you for using the LockedMe App desgined by Hector Alarcon.");
			//Closing the scanner object and exiting the application.
			input.close();
			System.exit(0);
		}
	}
	
	private static void mainScreen() throws Exception
	{
		//Mainscreen user interaction information and welcome message.
		System.out.print("Welcome to the LockedMe app\ndesigned by Hector Alarcon\n");
		System.out.println("=============================================================================");
		System.out.println("Please select among the following options by typing the corresponding number:");
		System.out.println("1. Inspect current directory.");
		System.out.println("2. File handeling.");
		System.out.println("3. Exit application.");
		System.out.print("=============================================================================\n");
		sel = input.nextLine();
		System.out.println();
		updateList();
		Arrays.parallelSort(dir); //Updating the stored files if any had been modified.
		
		//Sentinel value logic, making sure user inputs a number corresponding to the options.
		while(!sel.startsWith("1") && !sel.startsWith("2") && !sel.startsWith("3"))
		{
			System.out.println("INVALID INPUT");
			System.out.println("=============================================================================");
			System.out.println("Please select among the following options by typing the corresponding number:");
			System.out.println("1. Inspect current directory.");
			System.out.println("2. File handeling.");
			System.out.println("3. Exit application.");
			System.out.print("=============================================================================\n");
			sel = input.nextLine();
			System.out.println();
		}
		
		//Mainscreen options
		if(sel.startsWith("1"))
		{
			firstOption();
		}
		else if(sel.startsWith("2"))
		{
			secondOption();
		}
		else if(sel.startsWith("3"))
		{
			System.out.println("Exiting..");
		}
	}
	
	/**
	 * First option for the locker app, displays a list of the current stored files in Application Storage.
	 * @throws Exception
	 */
	private static void firstOption() throws Exception
	{
		//If directory is not empty, display the file names, otherwise let the user known its empty.
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
	
	/**
	 * Second option for the locker app, adds a file to the directory as well as adding whatever content the user wishes to add.
	 * @throws IOException
	 * @throws Exception
	 */
	private static void secondOption() throws IOException, Exception
	{
		//Second option user interaction information.
		System.out.println("=============================================================================");
		System.out.println("Please select among the following options by typing the corresponding number:");
		System.out.println("1. Add a file to existing directory.");
		System.out.println("2. Delete a file from existing directory.");
		System.out.println("3. Search for a file from existing directory.");
		System.out.println("4. Return to main menu.");
		System.out.println("=============================================================================\n");
		sel = input.nextLine();
		System.out.println();
		
		//Sentinel value logic, making sure user inputs a number corresponding to the options.
		while(sel.charAt(0) != '1' && sel.charAt(0) != '2' && sel.charAt(0) != '3' && sel.charAt(0) != '4')
		{
			System.out.println("INVALID INPUT");
			System.out.println("=============================================================================");
			System.out.println("Please select among the following options by typing the corresponding number:");
			System.out.println("1. Add a file to existing directory.");
			System.out.println("2. Delete a file from existing directory.");
			System.out.println("3. Search for a file from existing directory.");
			System.out.println("4. Return to main menu.");
			System.out.println("=============================================================================\n");
			sel = input.nextLine();	
			System.out.println();
		}
		
		switch(sel.charAt(0))
		{
			case('1'):
			{
				boolean finished = false;
				
				System.out.println("Please type the name of the new file:\n");
				sel = input.nextLine();
				System.out.println();
				File upload = new File(storage.getAbsoluteFile()+"\\"+sel.toLowerCase());
				PrintWriter pw = new PrintWriter(upload.getAbsoluteFile());
				
				System.out.println("Proceeds to type in the content of the file:");
				System.out.println("=============================================================================");
				while(!finished)
				{
					pw.println(input.nextLine());
					
					System.out.println("If you are done, please type "+"Exit"+" otherwise, press Enter.");
					if(input.nextLine().contentEquals("Exit"))
					{
						finished = true;
					}
				}
				System.out.println("=============================================================================\n");
				
				
				
				//Giving confirmation to the user about whether or not the operation was successful.
				System.out.println("File created successfully.\n");
				
				//Updating the list, re-sorting, and closing the writer.Back to menu.
				pw.close();
				updateList();
				Arrays.parallelSort(dir); 
				secondOption();
				break;
			}
			case('2'):
			{
				System.out.println("Please type the name of the file you want to delete:");
				System.out.println("=============================================================================\n");
				sel = input.nextLine();
				System.out.println();
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
				//Updating the list. Back to menu.
				updateList();
				secondOption();
				break;
			}
			case('3'):
			{
				System.out.println("Please type the name of the file you are looking for:");
				System.out.println("=============================================================================\n");
				sel = input.nextLine();
				System.out.println();
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
				
				//Back to menu
				secondOption();	
				break;
			}
			case('4'):
			{
				//Back to mainscreen
				mainScreen();
				break;
			}
		}
	}
	
	private static void updateList()
	{
		//Making sure the directory file list is always updated
		dir = storage.listFiles();
	}
}
