package com.zohocorp.zohoex1project;

import java.io.*;
import java.util.Scanner;


class Browser {
	private String url[]=new String[1]; 
	private int urlIndex=0;
	
	Browser()
	{
		//empty constructor

	}
	
	Browser(String urlHistory[])	
	{
		for(int i=0;i<urlHistory.length;i++)
			addUrl(urlHistory[i]);
	}

	public void addUrl(String s)
	{
		if(url.length==urlIndex)
		{
			String newUrl[]=new String[2*urlIndex];
			
			for(int i=0;i<urlIndex;i++)
				newUrl[i]=url[i];
			
			url=newUrl;
		}
		url[urlIndex++]=s;  
	}
	
	public String getURL(int j)
	{
		return url[j];
	}
	
	
	public void display()  
	{  
		System.out.println("Browser History \n");
		for(int i=0;i<urlIndex;i++)
			System.out.println(getURL(i)+"\n");
	}
}

public class BrowserHistoryDynamicArray 
{
	public static void main(String[] args)throws IOException
	{
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		Scanner in=new Scanner(System.in);
		
		char c='Y' ;
		String browserName;
		int urlNumber, choice;
		Browser googleChrome=new Browser();
		Browser microsoftEdge=new Browser();
		
		
		do
		{
			System.out.println("Enter your choice(type 1 to enter history or 2 to view the history:)");
			choice = Integer.parseInt(reader.readLine()); 
			System.out.println("Enter the browser whose history you want to enter/display: ");
			browserName = reader.readLine(); 
			
			switch(choice)
			{
			case 1:
			
				System.out.println("Enter the number of urls you want to add: ");
				urlNumber = Integer.parseInt(reader.readLine());
				String[] urlName= new String[urlNumber];
				
				System.out.println("Enter the URLS you want to add: ");
				for(int i=0;i<urlNumber;i++)
				{
					urlName[i] = reader.readLine();
					if(browserName.equalsIgnoreCase("Google Chrome"))
					{
						googleChrome.addUrl(urlName[i]);
					}
					
					if(browserName.equalsIgnoreCase("Microsoft Edge"))
					{
						microsoftEdge.addUrl(urlName[i]);
					}
				}
				break;
				
			case 2:
				if(browserName.equalsIgnoreCase("Google Chrome"))
				{
					googleChrome.display();
				}
				
				else if(browserName.equalsIgnoreCase("Microsoft Edge"))
				{
					microsoftEdge.display();
				}
				break;	
				default:
					System.out.println("Wrong choice");
			}
			System.out.println("Do you want to continue(Y/N): ");
			c=in.next().charAt(0);
			
		}while(c=='Y');
		
		in.close();
		System.out.println("Goodbye");

	}

}
