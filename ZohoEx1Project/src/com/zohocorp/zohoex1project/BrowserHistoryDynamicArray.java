package com.zohocorp.zohoex1project;

import java.io.*;


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
		
		char c='Y' ;
		String browserName;
		int urlNumber;
		
		do
		{
			System.out.println("Enter the browser whose history you want to enter: ");
			browserName = reader.readLine(); 
			
			System.out.println("Enter the number of urls you want to add: ");
			urlNumber = Integer.parseInt(reader.readLine());
			String[] urlName= new String[urlNumber];
			
			System.out.println("Enter the URLS you want to add: ");
			for(int i=0;i<urlNumber;i++)
			{
				urlName[i] = reader.readLine();
			}
			
			if(browserName.equalsIgnoreCase("Google Chrome"))
			{
				Browser googleChrome=new Browser(urlName);
				googleChrome.display();
			}
			
			System.out.println("Do you want to enter more history(Y/N): ");
			c=(char)reader.read(); 
			
		}while(c=='Y');
		
		

	}

}
