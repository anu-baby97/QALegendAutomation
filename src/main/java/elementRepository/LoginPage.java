package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(tagName = "button")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='username']//parent::div//span//strong")
	WebElement invalidLoginErrorMessage;
	
	@FindBy(linkText = "Forgot Your Password?")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement successMessageResetLink;
	
	@FindBy(xpath = "//input[@id='email']//parent::div//span//strong")
	WebElement errorMessageResetLink;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Demo POS')]")
	WebElement loginPageHeader;
	
	@FindBy(xpath = "//button[contains(text(),'End tour')]")
	WebElement popup;
	
	
	public void enterUsername(String uname) {
		gu.sendkeysToWebElement(username, uname);	
	}
	
	public void enterPassword(String pwd) {
		gu.sendkeysToWebElement(password, pwd);	
	}
	
	public void clickLoginButton() {
		gu.clickWebElement(loginButton);
	}
	
	public boolean isErrorMessageDisplayedForInvalidLogin() {
		return gu.isElementDisplayed(invalidLoginErrorMessage);
	}
	
	public void clickForgotPasswordLink() {
		gu.clickWebElement(forgotPasswordLink);
	}
	
	public void enterEmailtoSendResetLink(String email) {
		gu.sendkeysToWebElement(emailField, email);
	}
	
	public void clickSendResetPasswordLink() {
		gu.clickWebElement(submitButton);
	}
	
	public boolean isSuccessMessageDisplayedForResetLink() {
		return gu.isElementDisplayed(successMessageResetLink);
	}
	
	public boolean isErrorMessageDisplayedForResetLink() {
		return gu.isElementDisplayed(errorMessageResetLink);
	}
	
	public void performLogin(String uname, String pwd) {
		gu.sendkeysToWebElement(username, uname);
		gu.sendkeysToWebElement(password, pwd);
		gu.clickWebElement(loginButton);
		gu.clickWebElement(popup);
	}
	
	public boolean isLoginPageDisplayed() {
		return gu.isElementDisplayed(loginPageHeader);
	}
}
