package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClassForExcelLogin {


	WebDriver  driver;
//	@BeforeMethod
//	public void openBrowser() {
//		System.setProperty("webdriver.chrome.driver", "F:\\SHRI D\\SKN\\Softwares 2020\\chromedriver.exe");
//		driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://www.linkedin.com/home");
//	}

	@AfterMethod
	public void ScreenShot(ITestResult result) {

		if(ITestResult.FAILURE==result.getStatus()) {
			CaptureScreenshotUtility.capturescreen(driver,result.getName(),"FAILURE");
		}
		else {
			CaptureScreenshotUtility.capturescreen(driver,result.getName(),"SUCCESS");
		}

			}
	
	


}
