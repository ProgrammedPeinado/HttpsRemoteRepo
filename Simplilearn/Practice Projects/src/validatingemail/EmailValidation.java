package validatingemail;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation 
{
	private static String emp_emails[] = new String[] {"sarahJ@bestcompany.com",
			"pedroM@bestcompany.com",
			"joshA@bestcompany.com",
			"michaelO@bestcompany.com",
			"lauraM@bestcompany.com",
			"isabelM@bestcompany.com"};
	
	public static void main(String[] args)
	{
		//Establishing the list of arrays, 
		//format firstname, last name initial @ company.com
		//
		Boolean complete = false;
		Scanner kb = new Scanner(System.in);
		String confirmation = null;
		String email = null;
		
		
		try
		{
			while(!complete)
			{
				System.out.println("Please enter the email to be validated");
				email = kb.nextLine();
				
				checkEmail(email);
				
				System.out.println("Would you like to verify another email?");
				confirmation = kb.nextLine();
				
				if(confirmation.toLowerCase().startsWith("y"))
				{
					complete = false;
				}
				else
				{
					complete = true;
				}
				
			}
		}
		catch (Exception e) 
		{
			System.out.println(e.getCause());
			System.out.println("Email address not found, would you like to try again?");
		}
		finally
		{
			System.out.println("Thank you for using this validation program by Hector Alarcon");
			kb.close();
		}
	}
	
	private static void checkEmail(String email) throws Exception
	{			
		Pattern p = Pattern.compile("[a-z]{0,10}[A-Z]{1}@bestcompany.com");
		Matcher m = p.matcher(email);
		
		if(m.matches())
		{
			for(int i = 0 ; i < emp_emails.length ; i++)
			{
				if(emp_emails[i].equals(email))
					System.out.println("The email address you provided exists in index number: " +i);
			}
		}
		else 
		{
			System.out.println("The adress you provided cannot be found in the array.");
		}
	}
}
