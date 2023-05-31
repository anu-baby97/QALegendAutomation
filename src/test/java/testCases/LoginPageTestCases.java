package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.CONSTANT;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTestCases extends BaseClass{
	LoginPage lp;
	HomePage hp;
	
	@Test(priority = 1,groups = {"Regression","Smoke","Sanity"})
	public void loginUsingValidCredentials() {
		lp = new LoginPage(driver);
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		hp=new HomePage(driver);
		Assert.assertTrue(hp.isWelcomeMessageDisplayed(), "Login is not successful");		
	}
	
	@Test(priority = 2, groups = {"Regression","Smoke"})
	public void loginUsingInvalidCredentials() {
		lp = new LoginPage(driver);
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword("123");
		lp.clickLoginButton();
		
		Assert.assertTrue(lp.isErrorMessageDisplayedForInvalidLogin(),CONSTANT.errorMessageLogin);
	}
	
	@Test(priority = 3, groups = {"Regression","Smoke","Sanity"})
	public void passwordResetWithValidEmail() {
		lp = new LoginPage(driver);
		lp.clickForgotPasswordLink();
		lp.enterEmailtoSendResetLink(CONSTANT.mailID);
		lp.clickSendResetPasswordLink();
		
		Assert.assertTrue(lp.isSuccessMessageDisplayedForResetLink(),"Reset Password Link could not be sent");
	}
	
	@Test(priority = 4,groups = {"Regression","Smoke"})
	public void passwordResetWithInvalidEmail() {
		lp = new LoginPage(driver);
		lp.clickForgotPasswordLink();
		lp.enterEmailtoSendResetLink("abc@gmail.com");
		lp.clickSendResetPasswordLink();
		
		Assert.assertTrue(lp.isErrorMessageDisplayedForResetLink(),"Reset Password Link sent for invalid email");
	}
	
	
}
