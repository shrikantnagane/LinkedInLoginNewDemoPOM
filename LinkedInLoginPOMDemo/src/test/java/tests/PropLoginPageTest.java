package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFileForLogin;
import pages.HomePage;
import pages.LoginPage;


public class PropLoginPageTest extends PropertiesFileForLogin {

	WebDriver  driver;
		
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\SHRI D\\SKN\\Softwares 2020\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/home");
				
	}
	
	@Test (priority =  1)
	public void testCase1() throws IOException {
		
		LoginPage LIn1= new LoginPage(driver);
		LIn1.setUserName(getCredentials("UserName"));
		LIn1.setpassword(getCredentials("Password"));
		LIn1.clickOnSignInButton();	
		HomePage LIn2= new HomePage(driver);
		String HomePageHeading = LIn2.getHomePageHeader();
		System.out.println("Heading on Home Page :   " + HomePageHeading);
		Assert.assertEquals(HomePageHeading, "Welcome, Shrikant!");
		
	}
	
	@Test (priority =  -1)
	public void testCase2() {
		LoginPage LIn= new LoginPage(driver);
		String LoginPageHeading = LIn.getLoginPageHeader();
		System.out.println("Heading on Login Page :  " + LoginPageHeading);
		Assert.assertEquals(LoginPageHeading, "Welcome to your professional community");
		
	}
	
	@AfterMethod
public void ScreenShot(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
            CaptureScreenshotUtility.capturescreen(driver,result.getName(),"FAILURE");
        }
        else {
            CaptureScreenshotUtility.capturescreen(driver,result.getName(),"SUCCESS");
        }
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	


}
