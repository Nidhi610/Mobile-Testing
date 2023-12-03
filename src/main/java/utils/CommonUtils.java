package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.WaitConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonUtils {

	public static void waitForElement(AppiumDriver<WebElement> driver, AndroidElement element) {
		driver.manage().timeouts().implicitlyWait(WaitConstants.WAIT_FOR_ELEMENT, TimeUnit.SECONDS);
		
	}
	public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
