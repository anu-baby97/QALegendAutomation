package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath = "//section[@class='content-header']/h1")
	WebElement welcomeMessage;
	
	@FindBy(xpath = "//button[contains(text(),'End tour')]")
	WebElement popup;
	
	@FindBy(xpath = "//i[@class='fa fa-calculator fa-lg']")
	WebElement calc_icon;
	
	@FindBy(xpath = "//div[@class='calcBG col-md-12 text-center']")
	WebElement calculator;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement profile;
	
	@FindBy(linkText = "Sign Out" )
	WebElement logoutButton;
	
	public boolean isWelcomeMessageDisplayed() {
		return gu.isElementDisplayed(welcomeMessage);
	}
	
	public void closeAppTourPopup() {
		gu.clickWebElement(popup);
	}
	
	public void clickCalcIcon() {
		gu.clickWebElement(calc_icon);

	}
	
	public boolean isCalculatorDisplayed() {
		return gu.isElementDisplayed(calculator);	
	}
	
	public String clickProfileName() {
		gu.clickWebElement(profile);
		return driver.getCurrentUrl();
	}
	
	public void clickLogOutButton() {
		gu.clickWebElement(logoutButton);
	}
	
	
}
