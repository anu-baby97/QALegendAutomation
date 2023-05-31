package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void sendkeysToWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public String getTextOfWebElemenet(WebElement element) {
		return element.getText();
	}
	
	public void clickWebElement(WebElement element) {
		element.click();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	
	public void selectElementFromDropdown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
