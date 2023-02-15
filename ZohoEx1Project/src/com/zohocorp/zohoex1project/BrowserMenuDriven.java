package com.zohocorp.zohoex1project;

import java.io.*;
import java.util.*;

class Browser {
	private String[] url=new String[1];
	private int urlIndex=0;

	Browser()
	{
	//empty constructor
	}
	
	public void addUrl(String s)
	{
		if(url.length==urlIndex)
		{	
			String[] newUrl=Arrays.copyOf(url, 2*urlIndex);	
			url=newUrl;
		}
		url[urlIndex++]=s;
	}
	
	public void removeUrl(int n)
	{
		int originalUrlIndex=urlIndex;
		
		if (n>url.length)
			n=url.length;
		
		for(int j=url.length-1;j>url.length-(n+1);j--)
		{
			url[j]="";
			urlIndex--;
		}
		while(url.length <= originalUrlIndex/2)
		{
			String newUrl[]=new String[originalUrlIndex/2];
			
			for(int j=0;j<url.length;j++)
				newUrl[j]=url[j];
			
			url=newUrl;	
		}
	}
	
	public void resetHistory()
	{
		//Arrays.fill(url, "");
		removeUrl(url.length);
	}
	
	public String getURL(int p)
	{
		return url[p];
	}
	
	public void display()
	{
		System.out.println("Browser History \n");
		for(int j=0;j<urlIndex;j++)
			System.out.println(getURL(j)+"\n");
	}
}

public class BrowserMenuDriven 
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		Scanner in=new Scanner(System.in);

		char d, c='Y' ;
		String browserName;
		ArrayList<String> browserNameArray = new ArrayList<String>();
		float browserVersion;
		int urlNumber, choice, historyChoice;
		String browserChoice;
		Browser[] browserArray=new Browser[5];
		
		for(int i=0;i<5;i++)
			browserArray[i]=new Browser();


		do
		{
			System.out.println("\n Main Menu \n 1.Show all Browsers \n 2.Add New Browser"
			+ "\n 3.Remove a browser \n 4.Browser History \n 5.Exit");
	
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(reader.readLine()); 
	
			switch(choice)
			{
			case 1:
				if (browserNameArray.size()==0)
					System.out.println("Browser's list is empty");
				else
				{
					for(int i=0;i<browserNameArray.size();i++)
						System.out.println(browserNameArray.get(i));
				}
				break;
	
			case 2:
	
				System.out.println("Enter name of browser: ");
				browserName = reader.readLine(); 
				browserNameArray.add(browserName);
		
				System.out.println("Enter the version: ");
				browserVersion = Float.parseFloat(reader.readLine()); 
		
				System.out.println("Enter the number of urls you want to add: ");
				urlNumber = Integer.parseInt(reader.readLine());
				String[] urlName= new String[urlNumber];
		
				System.out.println("Enter the URLS you want to add: ");
				for(int i=0;i<urlNumber;i++)
				{
					System.out.println("Enter URL-"+ (i+1));
					urlName[i] = reader.readLine();
					if(browserName.equalsIgnoreCase("Google Chrome"))
					{
						browserArray[0].addUrl(urlName[i]);
					}
			
					if(browserName.equalsIgnoreCase("Microsoft Edge"))
					{
						browserArray[1].addUrl(urlName[i]);
					}
				}
				System.out.println("Do you want to see the browser details(Y/N)?");
				d=in.next().charAt(0);
				if (d=='Y')
				{
					System.out.println(" Name: " + browserName + "\n Version: " + browserVersion + "\n History: \n" );
					for(int i=0;i<urlNumber;i++)
						System.out.println(urlName[i]); 
				}
				break;
	
			case 3:
		
				System.out.println("Enter the browser you want to delete: ");
				browserName = reader.readLine(); 
		
				browserNameArray.remove(browserName);
		
				if (browserNameArray.size()==0)
					System.out.println("Browser's list is empty");
				else
				{
					System.out.println("Browser List after deletion:");
					for(int i=0;i<browserNameArray.size();i++)
					System.out.println(browserNameArray.get(i));
				}
				break;
	
			case 4:
				System.out.println("Select a Browser(enter string)");
				for(int i=0;i<browserNameArray.size();i++)
					System.out.println((i+1) + ". " + browserNameArray.get(i));
				browserChoice=reader.readLine(); 
				
				System.out.println(" 1. Add New History Entry \n 2. Remove a History Entry \n 3. Reset History \n 4. View History");
				historyChoice=Integer.parseInt(reader.readLine());
				
				switch(historyChoice)
				{
				case 1:
					System.out.println("Enter the number of urls you want to add: ");
					urlNumber = Integer.parseInt(reader.readLine());
					String newUrlName;
			
					System.out.println("Enter the URLS you want to add: ");
					for(int i=0;i<urlNumber;i++)
					{
						System.out.println("Enter URL-"+(i+1));
						newUrlName = reader.readLine();
						if(browserChoice.equalsIgnoreCase("Google Chrome"))
						{
							browserArray[0].addUrl(newUrlName);
						}
				
						if(browserChoice.equalsIgnoreCase("Microsoft Edge"))
						{
							browserArray[1].addUrl(newUrlName);
						}
					}
					break;
		
				case 2:
					System.out.println("Enter the number of urls you want to delete: ");
					urlNumber = Integer.parseInt(reader.readLine());
					if(browserChoice.equalsIgnoreCase("Google Chrome"))
					{
						browserArray[0].removeUrl(urlNumber);
						browserArray[0].display();
					}
			
					if(browserChoice.equalsIgnoreCase("Microsoft Edge"))
					{
						browserArray[1].removeUrl(urlNumber);
						browserArray[1].display();
					}
					break;
		
				case 3:
					if(browserChoice.equalsIgnoreCase("Google Chrome"))
						browserArray[0].resetHistory();
					else if(browserChoice.equalsIgnoreCase("Microsoft Edge"))
						browserArray[1].resetHistory();
					
					break; 
			
					case 4:
					if(browserChoice.equalsIgnoreCase("Google Chrome"))
						browserArray[0].display();
					else if(browserChoice.equalsIgnoreCase("Microsoft Edge"))
						browserArray[1].display();
					
					break; 
			
					default:
						System.out.println("Wrong choice");
					}
					break;
	
			case 5:
				System.out.println("Do you want to continue(Y/N): ");
				c=in.next().charAt(0);
				break;
	
			default:
				System.out.println("Wrong choice");
			}
		}while(c=='Y');

		in.close();
		System.out.println("Goodbye");
	}

}
