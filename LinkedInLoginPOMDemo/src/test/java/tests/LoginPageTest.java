package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;


public class LoginPageTest extends TestBaseClassForExcelLogin {

	
	@Test (priority =  1)
	public void testCase1() throws Exception {

		
		try
        {

            File file = new File("F:\\SHRI D\\SKN\\Softwares 2020\\LoginData.xlsx");
            FileInputStream iFile = new FileInputStream(file);

            XSSFWorkbook wb = new XSSFWorkbook(iFile);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
            System.out.println("the no of rows are : " + rowCount);
            for (int row=1; row<=rowCount; row++)
            {	
            	
            System.setProperty("webdriver.chrome.driver", "F:\\SHRI D\\SKN\\Softwares 2020\\chromedriver.exe");
    		driver= new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		driver.get("https://www.linkedin.com/home");

                String UserID = sheet.getRow(row).getCell(0).getStringCellValue();

                String Password = sheet.getRow(row).getCell(1).getStringCellValue();

                System.out.println(UserID + " , " + Password );
                
                LoginPage LIn1= new LoginPage(driver);
        		LIn1.setUserName(UserID);
        		LIn1.setpassword(Password);
        		LIn1.clickOnSignInButton();	
        		HomePage LIn2= new HomePage(driver);
        		String HomePageHeading = LIn2.getHomePageHeader();
        		System.out.println("Heading on Home Page :   " + HomePageHeading);
        		Assert.assertEquals(HomePageHeading, "Welcome, Shrikant!");
        		
        		
//        		if(ITestResult.FAILURE==result.getStatus()) {
//        			CaptureScreenshotUtility.capturescreen(driver,result.getName(),"FAILURE");
//        		}
//        		else {
//        			CaptureScreenshotUtility.capturescreen(driver,result.getName(),"SUCCESS");
//        		}

        		driver.quit();
            }

            iFile.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

		
	}	
//	@Test (priority =  2)
//	public void testCase3() {
//		
//		LoginPage LIn1= new LoginPage(driver);
//		LIn1.setUserName("shrikant.nagane@gmail.com");
//		LIn1.setpassword("Shrikant@123");
//		LIn1.clickOnSignInButton();	
//		HomePage LIn2= new HomePage(driver);
//		String HomePageHeading = LIn2.getHomePageHeader();
//		System.out.println("Heading on Home Page :   " + HomePageHeading);
//		Assert.assertEquals(HomePageHeading, "Welcome, Shrikant!");
//
//	}
	
	
//	@Test (priority =  -1)
//	public void testCase2() {
//		LoginPage LIn= new LoginPage(driver);
//		String LoginPageHeading = LIn.getLoginPageHeader();
//		System.out.println("Heading on Login Page :  " + LoginPageHeading);
//		Assert.assertEquals(LoginPageHeading, "Welcome to your professional community");
//
//	}


}

