package com.zohocorp.zohoex1project;

import java.io.*;
import java.util.*;

class Browser {
	private ArrayList<String> url = new ArrayList<>();
	
	Browser()
	{
			addURL("url1");
	}
	
	Browser(String urlHistory[])	
	{
		int l=urlHistory.length;
		for(int i=0;i<l;i++)
			addURL(urlHistory[i]);
	}

	public void addURL(String s)
	{
		url.add(s); 
	}
	
	
	public void display(int urlNo)  
	{  
		System.out.println("Browser History \n");
		for(int i=0;i<urlNo;i++)
			System.out.println(url.get(i)+"\n");
	}
}

public class BrowserHistory 
{
	public static void main(String[] args)throws IOException
	{
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		
		char c='Y' ;
		String browserName;
		int urlNumber;
		
		do
		{
			System.out.println("Enter the browser whose history you want to enter: ");
			browserName = reader.readLine(); /*Scanner not used because it reads everything 
			in the buffer up to the text end-of-line,and returns an empty String. */
			
			System.out.println("Enter the number of urls you want to add: ");
			urlNumber = in.nextInt();
			String[] urlName= new String[urlNumber];
			
			System.out.println("Enter the URLS you want to add: ");
			for(int i=0;i<urlNumber;i++)
			{
				urlName[i] = reader.readLine();
			}
			
			if(browserName.equalsIgnoreCase("Google Chrome"))
			{
				Browser googleChrome=new Browser(urlName);
				googleChrome.display(urlNumber);
			}
			
			System.out.println("Do you want to enter more history(Y/N): ");
			c=in.next().charAt(0);
			
		}while(c=='Y');
		
		in.close();

	}

}
