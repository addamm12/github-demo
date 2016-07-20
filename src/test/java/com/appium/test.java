package com.appium;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class test {

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		File appDir=new File("apk");
		File app=new File(appDir,"BookMyShow.apk");
		DesiredCapabilities vDesiredCapabilities=new DesiredCapabilities();
		vDesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		vDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		//vDesiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//vDesiredCapabilities.setCapability(MobileCapabilityType.APP, "/data/app/com.bt.bms-1.apk");
		vDesiredCapabilities.setCapability("appPackage", "com.bt.bms");
		vDesiredCapabilities.setCapability("appActivity", "com.bt.bms.activities.SplashActivity");
		vDesiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),vDesiredCapabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bt.bms:id/btnLogin")));
		driver.findElementById("com.bt.bms:id/btnLogin").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bt.bms:id/signUp")));
		driver.findElementById("com.bt.bms:id/signUp").click();
		int count=driver.findElementsByClassName("android.widget.EditText").size();
		System.out.println(count);
		List<WebElement> list=driver.findElementsByClassName("android.widget.EditText");
		list.get(0).sendKeys("Appium");
		list.get(1).sendKeys("mobile");
		list.get(2).sendKeys("appium@password");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.bt.bms:id/edtPassword").sendKeys("Aaaazz1234_");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.bt.bms:id/etMobile").sendKeys("678453234");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.bt.bms:id/action_icon").click();
		Assert.assertTrue(driver.findElementById("com.bt.bms:id/message").getText().equals("Please enter valid email address."));
		Assert.assertFalse(driver.findElementById("com.bt.bms:id/message").getText().equals("Please valid email address."));
		//MobileElement vMobileElement=(MobileElement)driver.findElementByClassName("");
		//vMobileElement.swipe(SwipeElementDirection.UP, 2000);
		System.out.println(driver.getContext());
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
	}
}
