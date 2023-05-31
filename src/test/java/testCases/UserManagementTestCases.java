package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.UserManagementPage;
import utilities.RandomDataGeneration;

public class UserManagementTestCases extends BaseClass {

	LoginPage lp;
	UserManagementPage ump;
	RandomDataGeneration rand = new RandomDataGeneration();

	@Test(priority = 1, groups = { "Regression", "Smoke", "Sanity" })
	public void isMenuExpansionDisplayed() {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));

		ump = new UserManagementPage(driver);
		ump.clickUserManagementMenuLink();
		Assert.assertTrue(ump.isMenuItemsDisplayed(), "Menu items are not displayed when expanded");
	}

	@Test(priority = 2, groups = { "Regression",
			"Smoke" }, dataProvider = "testData", dataProviderClass = utilities.ExcelUtility.class)
	public void addNewUserWithValidData(String fname, String lname, String roles, String password,
			String confirm_password, String sales_percent) {

		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));

		ump = new UserManagementPage(driver);
		ump.clickUserManagementMenuLink();
		ump.clickUserLink();
		ump.clickAddButton();
		ump.enterFirstName(fname);
		ump.enterLastName(lname);
		ump.enterEmail(rand.randomeString() + "@gmail.com");
		ump.selectRole(roles);
		ump.enterUname(rand.randomeString());
		ump.enterPassword(password);
		ump.enterConfirmPassword(password);
		ump.enterSalesPercent(sales_percent);
		ump.clickSubmitButton();
		Assert.assertTrue(ump.isSucessMessageDisplayed(), "New User not added ");
	}

	@Test(priority = 3,dataProvider = "testData", dataProviderClass = utilities.ExcelUtility.class)
	public void addNewUserwithExistingUserName(String fname, String lname, String roles, String password,
			String confirm_password, String sales_percent) {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));

		ump = new UserManagementPage(driver);
		ump.clickUserManagementMenuLink();
		ump.clickUserLink();
		ump.clickAddButton();
		ump.enterFirstName(fname);
		ump.enterLastName(lname);
		ump.enterEmail(rand.randomeString() + "@gmail.com");
		ump.selectRole(roles);
		ump.enterUname("admin");
		ump.enterPassword(password);
		ump.enterConfirmPassword(password);
		ump.enterSalesPercent(sales_percent);
		ump.clickSubmitButton();
		Assert.assertTrue(ump.isUserNameErrorDisplayed(),"User name error not displayed for existing user name");
	}

	@Test(priority = 4, groups = { "Regression" })
	public void checkSearchFunctionality() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));

		ump = new UserManagementPage(driver);
		ump.clickUserManagementMenuLink();
		ump.clickUserLink();
		boolean result = ump.checkSearch("Baby");
		Assert.assertTrue(result, "Search results not found");

	}

	@Test(priority = 4)
	public void editRolePermission() {
		lp = new LoginPage(driver);
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));

		ump = new UserManagementPage(driver);
		ump.clickUserManagementMenuLink();
		ump.clickRolesLink();
		ump.searchEditRole("Developer");
		ump.clickEditButton();
		ump.clickbrandPermissionsCheckbox();
		ump.clickUpdateButton();
		Assert.assertTrue(ump.isSucessMessageDisplayed(), "Role permission not updated ");

	}

}
