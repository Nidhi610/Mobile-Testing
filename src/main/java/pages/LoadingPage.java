package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.CommonUtils;


public class LoadingPage {

	private String prdTitle;
	public AppiumDriver<WebElement> driver;
	


    public LoadingPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search")
	public AndroidElement Search;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search_src_text")
	public AndroidElement SearctTxt;
	
	@AndroidFindBy(className  = "android.widget.FrameLayout")
	public AndroidElement ItemBlock;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/category_image")
	public AndroidElement CategoryImg;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/product_name")
	public AndroidElement productName;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/btn_add_cart")
	public AndroidElement btnAddToCart;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/userInputDialog")
	public AndroidElement NoOfOrder;
	
	@AndroidFindBy(className = "android.widget.LinearLayout")
	public AndroidElement btnLayout;
	
	@AndroidFindBy(className = "android.widget.FrameLayout")
	public AndroidElement productLayout;
	
	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement btnAdd;
	
	@AndroidFindBy(androidDataMatcher = "CANCEL")
	public AndroidElement btnCancel;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/cart")
	public AndroidElement AddToCart;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/clear")
	public AndroidElement DeleteFromCart;
	
	@AndroidFindBy(androidDataMatcher = "YES")
	public AndroidElement btnYes;
	
	@AndroidFindBy(androidDataMatcher = "NO")
	public AndroidElement btnNo;
	
	@AndroidFindBy(className = "android.widget.ImageButton")
	public AndroidElement btnBack;
	
	@AndroidFindBy(className = "com.solodroid.solomerce:id/btn_continue")
	public AndroidElement btnContinueShop;
	
	

	public void SearchItem() {
		CommonUtils.waitForElement(driver, Search);
		if(Search.isDisplayed()) {
			Search.click();
		}
	}
	public void EnterSearchText(String searchtxt) {
		CommonUtils.waitForElement(driver, SearctTxt);
		if(SearctTxt.isDisplayed()) {
			SearctTxt.sendKeys(searchtxt);
		}
	}

	public void HideKeyBoard() {
		driver.hideKeyboard();
	}
	
	public void ClickItem() throws InterruptedException {
		CommonUtils.waitForElement(driver, productLayout);
		if(productLayout.isDisplayed()) {
			productLayout.click();
		}
		Thread.sleep(1000);
		CommonUtils.waitForElement(driver, productName);
		if(productName.isDisplayed()) {
			prdTitle = productName.getText();
		}

		Thread.sleep(3000);
		System.out.println("Clicked on product");
		System.out.println("Product Title:" + prdTitle);
	}
	
	public void AddToCart() throws InterruptedException {
		CommonUtils.waitForElement(driver, btnAddToCart);
		if(btnAddToCart.isDisplayed()) {
			btnAddToCart.click();
		}
		Thread.sleep(3000);

		System.out.println("Clicked on AddToCart");
		System.out.println("prdTitle: " + prdTitle);
	}
	
	public void AddNoOfItem() throws InterruptedException {
	    try {
	        CommonUtils.waitForElement(driver, NoOfOrder);
	        if (NoOfOrder.isDisplayed()) {
	            NoOfOrder.sendKeys("1");
	        }
	        System.out.println("Entered Item No");
	        Thread.sleep(3000);
	    } catch (StaleElementReferenceException e) {
	        // Handle the stale element exception by re-locating the element
	        NoOfOrder = (AndroidElement) driver.findElement(By.id("com.solodroid.solomerce:id/userInputDialog"));
	        if (NoOfOrder.isDisplayed()) {
	            NoOfOrder.sendKeys("1");
	        }
	        System.out.println("Entered Item No");
	        System.out.println("prdTitle: " + prdTitle);
	        Thread.sleep(3000);
	    }
	}

	public void ClickAddBtn() throws InterruptedException {
		CommonUtils.waitForElement(driver, btnLayout);
		CommonUtils.waitForElement(driver, btnAdd);
		if(btnAdd.isDisplayed()) {
			btnAdd.click();
		}
		System.out.println("Clickded on Addto cart Btn");
		System.out.println("prdTitle: " + prdTitle);
	}
	

	public void GoToCart() throws InterruptedException {
		CommonUtils.waitForElement(driver, AddToCart);
		if(AddToCart.isDisplayed()) {
			AddToCart.click();
		}
		System.out.println("Clickded on Addto cart");
		System.out.println("prdTitle: " + prdTitle);
		
	}
	
	public void VerifyCart() throws InterruptedException {

		String searchText = prdTitle;

		// Create a selector using AndroidUIAutomator to find elements containing the text
		By selector = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + searchText + "\")");

		// Find elements using the selector
		List<WebElement> itemList = driver.findElements(selector);

		// Loop through the elements and do your verification
		for (WebElement item : itemList) {
		    String prdName = item.getText().trim();
		    System.out.println("prdName: " + prdName);

		    if (prdName.contains(searchText)) {
		        System.out.println("Item added into the Cart");
		    } else {
		        System.out.println("Itemis not added into the cart");
		    }
		}
	}
	
}
