package com.zohocorp.zohoex2project;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Browser {
	private static ArrayList<String> url = new ArrayList<>();
	
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
	
	public void whoAmI() {
		System.out.println("I am a browser");
	}
}

class GoogleChrome extends Browser{
	private boolean isLocationAccessible=false,isCameraAccessible=false, isMicrophoneAccessible=false;
	final String versionNumber="1.0";
	static int countGoogleTabs=0;
	
	GoogleChrome(){
		countGoogleTabs++; //To count the number of google tabs opened
	}

	GoogleChrome(String urlHistory[]){
		super(urlHistory);
	}
	
	public void setAccessibility(boolean isLocationAccessible) {
		this.isLocationAccessible=isLocationAccessible;
		permissionDisplay();
		
	}
	public void setAccessibility(boolean isCameraAccessible,int n) {
		this.isCameraAccessible=isCameraAccessible;
		permissionDisplay();
	}
	public void setAccessibility(int n) {
		if (n==1)
			this.isMicrophoneAccessible=true;
		else
			this.isMicrophoneAccessible=false;
		permissionDisplay();
	}
	public void setAccessibility(boolean isLocationAccessible, boolean isCameraAccessible, boolean isMicrophoneAccessible) {
		this.isLocationAccessible=isLocationAccessible;
		this.isCameraAccessible=isCameraAccessible;
		this.isMicrophoneAccessible=isMicrophoneAccessible;
		permissionDisplay();
	}
	public void permissionDisplay() {
		System.out.println("Location Permission:" + this.isLocationAccessible);
		System.out.println("Camera Permission:" + this.isCameraAccessible);
		System.out.println("Microphone Permission:" + this.isMicrophoneAccessible);
	}
	
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
}

interface MultipleAccountContainers {
	void addContainer(String s);
	void removeContainer(String s);
}

class Firefox extends Browser implements MultipleAccountContainers {
	
	private static ArrayList<String> container = new ArrayList<>();
	
	Firefox(){
		//empty constructor
	}
	
	Firefox(String urlHistory[]){
		super(urlHistory);
	}
	public void whoAmI() {
		System.out.println("I am Firefox");
	}

	@Override
	public void addContainer(String s) {
		container.add(s);
		System.out.println("Container List:"+ container);
	}

	@Override
	public void removeContainer(String s) {
		if (container.size()==0)
		{
			System.out.println("Container List is empty");
		}
		else {
			if (container.contains(s)==false) {
				System.out.println("Container not present");
			}
			else {	
				container.removeIf(n -> (n.equals(s)));
				System.out.println("Container List:"+container);
			}
		}
	}
}

public class BrowserOops{
	
	public static void numberGoogleTab(Browser b[]){
		int countGoogleChrome=0;
		for(int j=0;j<b.length;j++) {
			if(b[j] instanceof GoogleChrome) {
				countGoogleChrome++;
			}
		}
		System.out.println("Number of GoogleChrome tabs: "+ countGoogleChrome);
	}
	
	
	public static void main(String[] args)throws IOException
	{
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		
		char c='Y' ;
		//String browserName;
		//int urlNumber;
		//int countGoogleChrome=0;
		int choice;
		//int indexAllBrowsers=5;
		
		//MultipleAccountContainers firefoxContainer = new Firefox();
		
		Browser tabOne=new GoogleChrome();
		Browser tabTwo=new Firefox();
		Browser tabThree=new Firefox();
		Browser tabFour=new GoogleChrome();
		Browser tabFive=new GoogleChrome();
		Browser[] allBrowsers=new Browser[5];
		
		allBrowsers[0]=tabOne;
		allBrowsers[1]=tabTwo;
		allBrowsers[2]=tabThree;
		allBrowsers[3]=tabFour;
		allBrowsers[4]=tabFive;
		
		do
		{
			System.out.println("\n Main Menu \n 1.Add URLs \n 2.Find my Browser name \n 3.Set Permissions"
					+ "\n 4.Number of Google Tabs \n 5.Container \n 6.Quit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(reader.readLine()); 
			
			switch(choice)
			{
			/*case 1:
				System.out.println("Enter the browser whose history you want to enter/display: ");
				browserName = reader.readLine(); 
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
					GoogleChrome tabSix=new GoogleChrome(urlName);
					tabSix.display(urlNumber);
					allBrowsers[indexAllBrowsers++]=tabSix;
					browserOops.numberGoogleTab(allBrowsers);
				}
				
				System.out.println("Do you want to enter more history(Y/N): ");
				c=in.next().charAt(0);
				break;
				*/
			case 2:
				System.out.println("The open browser tabs are :");
				for(int j=0;j<allBrowsers.length;j++) {
					allBrowsers[j].whoAmI();
				}
				break;
				
			case 3:
				int permissionChoice,permissionNumber=0;
				boolean permissionOption=false;
				System.out.println("\n Set Permissions \n 1.All Permissions \n 2.Location \n 3.Camera \n 4.Microphone");
				System.out.println("Enter your choice:");
				permissionChoice = Integer.parseInt(reader.readLine()); 
				if (permissionChoice==2 || permissionChoice==3 || permissionChoice==4) 
				{
					System.out.println("Enter permission(true/false): ");
					permissionOption=in.nextBoolean();
					if (permissionOption==true)
						permissionNumber=1;
					else
						permissionNumber=0;
					
				}
				switch(permissionChoice)
				{
				case 1:
					boolean permissionOptionArray[]=new boolean[3];
					System.out.println("Enter permission for location, camera and microphone: ");
					for(int j=0;j<3;j++) {
						permissionOptionArray[j]=in.nextBoolean();
					}
					((GoogleChrome) tabOne).setAccessibility(permissionOptionArray[0],permissionOptionArray[1],permissionOptionArray[2]);
					break;
				case 2:
					((GoogleChrome) tabOne).setAccessibility(permissionOption);
					break;
				case 3:
					((GoogleChrome) tabOne).setAccessibility(permissionOption,permissionNumber);
					break;
				case 4:
					((GoogleChrome) tabOne).setAccessibility(permissionNumber);
					break;
				default:
					System.out.println("Wrong choice");
				}
				break;
			case 4:
				numberGoogleTab(allBrowsers);
				break;
			case 5:
				String containerName;
				int containerChoice;
				System.out.println("\n Container \n 1.Add Container \n 2.Remove Container");
				System.out.println("Enter your choice:");
				containerChoice = Integer.parseInt(reader.readLine()); 
				switch(containerChoice)
				{
				case 1:
					System.out.println("Enter the name of container you want to add: ");
					containerName = reader.readLine();
					((Firefox) tabTwo).addContainer(containerName);
					break;
				case 2:
					System.out.println("Enter the name of container you want to remove: ");
					containerName = reader.readLine();
					((Firefox) tabTwo).removeContainer(containerName);
					break;
				default:
					System.out.println("Wrong choice");
				}
				break;
			case 6:
				System.out.println("Do you want to continue(Y/N): ");
				c=in.next().charAt(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
			
		}while(c=='Y');
		System.out.println("Goodbye");
		in.close();

	}
}

