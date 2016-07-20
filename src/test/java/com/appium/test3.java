package com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class test3 {

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		DesiredCapabilities vDesiredCapabilities=new DesiredCapabilities();
		vDesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		vDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		vDesiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		vDesiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),vDesiredCapabilities);
		driver.get("http://www.gazeta.pl");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean b=true;
		int i=0;
	//	TouchAction t=new TouchAction(driver);
	//	t.moveTo(driver.findElementById("LinkArea:BoxNewsNav"));
		Thread.sleep(900L);
		while(b) {
		try {
			i++;
			driver.findElementByXPath(".//*[@id='LinkArea:BoxSportNav']").click();
			b=false;
		}
		catch (Exception e){
			js.executeScript("javascript:window.scrollBy(0,100)");	
			if (i>100) Assert.assertTrue(false);
		}
		}   

	}
}