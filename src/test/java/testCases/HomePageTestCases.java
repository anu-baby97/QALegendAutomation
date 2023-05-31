package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;
	
	@Test(priority = 1,groups = {"Smoke"})
	public void isCalculatorDisplayedOnIconClick() {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		hp=new HomePage(driver);
		hp.clickCalcIcon();	
		Assert.assertTrue(hp.isCalculatorDisplayed(),"Calculator not displayed on clicking calculator icon");
	}
	
	@Test(priority = 2,groups = {"Regression","Smoke"})
	public void isUserAbleToLogOut() {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		hp=new HomePage(driver);
		hp.clickProfileName();
		hp.clickLogOutButton();
		Assert.assertTrue(lp.isLoginPageDisplayed(), "User is unable to log out");
	}
}
