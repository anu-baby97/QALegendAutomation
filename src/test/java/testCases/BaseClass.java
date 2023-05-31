	package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.GeneralUtilities;
import utilities.ScreenshotUtility;

public class BaseClass {
  
	WebDriver driver;
	Properties prop;
	ScreenshotUtility sc;
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "//src//main//resources//config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) {
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if (browserName.equals("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			sc=new ScreenshotUtility();
			sc.takeScreenshotAtEndOfTest(iTestResult.getName(),driver);
		}
		driver.close();
	}


	
}
