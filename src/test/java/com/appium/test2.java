package com.appium;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class test2 {

	@Test
	public void test() throws MalformedURLException {
		DesiredCapabilities vDesiredCapabilities=new DesiredCapabilities();
		vDesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		vDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		vDesiredCapabilities.setCapability("appPackage", "com.raaga.android");
		vDesiredCapabilities.setCapability("appActivity", "com.raaga.android.SplashScreen");
		vDesiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");		
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),vDesiredCapabilities);
		//driver.findElementById("com.raaga.android:id/skip_text").click();
		//driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
	}

}
