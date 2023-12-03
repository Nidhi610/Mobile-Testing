package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Actions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "14");
		dc.setCapability("deviceName", "Pixel 7 pro");
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));
		
//		TouchAction swipeAction = new TouchAction<>(driver);
//		swipeAction.press(PointOption.point(655, 866)).waitAction().moveTo(PointOption.point(55, 866)).release().perform();
//		Thread.sleep(2000);
//		swipeAction.press(PointOption.point(655, 866)).waitAction().moveTo(PointOption.point(655, 866)).release().perform();
		
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.solodroid.solomerce:id/viewpager\"))"
				+ ".scrollForward().scrollIntoView(new UiSelector()"
				+ ".textContains(\"Money Counter Kozure MC-101\"))");
		
		WebElement moneyC = driver.findElementByAndroidUIAutomator("new UiSelector()"
				+ ".textContains(\"Money Counter Kozure MC-101\")");
		moneyC.click();
		
		driver.findElementByAndroidUIAutomator("new UiSelector()"
						+ ".resourceId(\"com.solodroid.solomerce:id/product_image\")").click();
				
		MultiTouchAction action = new MultiTouchAction(driver);
		TouchAction touch1 = new TouchAction<>(driver);
		TouchAction touch2 = new TouchAction<>(driver);
		
		touch1.press(PointOption.point(200, 600)).moveTo(PointOption.point(200, 400)).release();
		touch1.press(PointOption.point(200, 650)).moveTo(PointOption.point(200,780)).release();
		action.add(touch1);
		action.add(touch2);
		action.perform();
		
	}
}
