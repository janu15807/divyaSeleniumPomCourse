package com.qa.hubspt.utill;

public class Utill {
	  
	public static void shortTime() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void mediumTime() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void longTime() 
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}


