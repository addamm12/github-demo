package com.appium;

import java.io.IOException;
import org.testng.annotations.BeforeSuite;

public class Before {	
	@BeforeSuite
	public void run() throws IOException, InterruptedException{
		Runtime.getRuntime().exec("cmd /c start C:\\Appium\\com.appium\\startappium");	
		Thread.sleep(100000L);
	}
}
