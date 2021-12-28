package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;


public class LoginPageTest extends TestBaseClass {

	
	@Test (priority =  1)
	public void testCase1() {
		
		LoginPage LIn1= new LoginPage(driver);
		LIn1.setUserName("shrikant.nagane2106@gmail.com");
		LIn1.setpassword("Shrikant@123");
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


}

