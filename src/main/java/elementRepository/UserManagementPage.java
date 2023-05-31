package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class UserManagementPage {

	WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtilities gu = new GeneralUtilities();

	@FindBy(linkText = "User Management")
	WebElement userManagementLink;

	@FindBys({ @FindBy(xpath = "//ul[@class='treeview-menu menu-open']/li") })
	List<WebElement> menuItems;

	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span[@class='title']")
	WebElement userLink;
	
	@FindBy(xpath = "//a/span[contains(text(),'Roles')]")
	WebElement rolesLink;

	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addButton;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath = "//select[@id='role']")
	WebElement roleSelect;

	@FindBy(id = "username")
	WebElement uname;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirm_password;

	@FindBy(id = "cmmsn_percent")
	WebElement sales_percent;

	@FindBy(id = "submit_user_button")
	WebElement submitButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBys({@FindBy(xpath = "//table[@id='users_table']/tbody/tr")})
	List<WebElement> tableRow;
	
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	WebElement editButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Brand')]//parent::div//following-sibling::div/div/label/div")
	WebElement brandPermissionsCheckbox;
	
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateRolePermissionButton;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement successMessage;
	
	@FindBy(id = "username-error")
	WebElement usernameError;
	
	public void clickUserManagementMenuLink() {
		gu.clickWebElement(userManagementLink);

	}

	public boolean isMenuItemsDisplayed() {
		boolean menuItemDisplay = true;
		for (int i = 0; i < menuItems.size(); i++) {
			menuItemDisplay = gu.isElementDisplayed(menuItems.get(i));
		}
		return menuItemDisplay;
	}

	public void clickUserLink() {
		gu.clickWebElement(userLink);
	}

	public void clickAddButton() {
		gu.clickWebElement(addButton);

	}

	public void enterFirstName(String fname) {
		gu.sendkeysToWebElement(firstName, fname);
	}
	
	public void enterLastName(String lname) {
		gu.sendkeysToWebElement(lastName, lname);
	}

	public void enterEmail(String emailText) {
		gu.sendkeysToWebElement(email, emailText);
	}

	public void selectRole(String text) {
		gu.selectElementFromDropdown(roleSelect, text);
	}

	public void enterUname(String unameText) {
		gu.sendkeysToWebElement(uname, unameText);
	}

	public void enterPassword(String pwd) {
		gu.sendkeysToWebElement(password, pwd);
	}

	public void enterConfirmPassword(String pwd) {
		gu.sendkeysToWebElement(confirm_password, pwd);
	}

	public void enterSalesPercent(String sales_per) {
		gu.sendkeysToWebElement(sales_percent, sales_per);
	}

	public void clickSubmitButton() {
		gu.clickWebElement(submitButton);
	}
	
	public boolean checkSearch(String searchText) throws InterruptedException {
		gu.sendkeysToWebElement(searchField, searchText);
		Thread.sleep(3000);
		boolean found=true;
		int rowsize = tableRow.size();
		for(int i=1;i<rowsize;i++) {
			if (!(driver.findElement(By.xpath("//table[@id='users_table']/tbody/tr[" + i + "]//td[2]"))
					.getText().toLowerCase().contains(searchText.toLowerCase()))) {
				found=false;
				break;
			}
	
		}
		return found;
	}
	
	public void clickRolesLink() {
		gu.clickWebElement(rolesLink);
	}
	
	
	public void searchEditRole(String role) {
		gu.sendkeysToWebElement(searchField, role);
		
	}
	
	public void clickEditButton() {
		gu.clickWebElement(editButton);
	}
	
	public void clickbrandPermissionsCheckbox() {
		gu.clickWebElement(brandPermissionsCheckbox);
	} 

	public void clickUpdateButton() {
		gu.clickWebElement(updateRolePermissionButton);
	}
	
	public boolean isSucessMessageDisplayed() {
		return gu.isElementDisplayed(successMessage);
	}
	
	public boolean isUserNameErrorDisplayed() {
		return gu.isElementDisplayed(usernameError);
	}
}
