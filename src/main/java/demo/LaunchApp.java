package demo;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class LaunchApp {	
		public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
			
			DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability("platformName", "Android");
			dc.setCapability("platformVersion", "14");
			dc.setCapability("deviceName", "Pixel 7 pro");
			dc.setCapability("appPackage", "com.solodroid.solomerce");
			dc.setCapability("appActivity", ".activities.ActivitySplash");
			
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
			driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("watch");
			driver.hideKeyboard();
			Thread.sleep(3000);
			
			WebElement category = driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
			Point categorysize = category.getLocation();
			System.out.println(categorysize.x);
			System.out.println(categorysize.y);
			
			System.out.println("Finished");
			Thread.sleep(3000);
		
	}
}
		
