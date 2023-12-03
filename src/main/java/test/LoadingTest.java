package test;

import org.testng.annotations.Test;

import pages.LoadingAppPage;
import pages.LoadingPage;

public class LoadingTest extends BaseTest{

	@Test(priority = 1)
    public void testSearchFunctionality() {
		LoadingPage lp = new LoadingPage(driver);
        lp.SearchItem();
        lp.EnterSearchText("Watch");
        lp.HideKeyBoard();
    }

	@Test(priority = 2)
	public void ClikableItems() throws InterruptedException {

		LoadingPage lp = new LoadingPage(driver);
		lp.ClickItem();
		lp.AddToCart();
		lp.AddNoOfItem();
		lp.ClickAddBtn();
		lp.GoToCart();
		lp.VerifyCart();
	}
	
}
