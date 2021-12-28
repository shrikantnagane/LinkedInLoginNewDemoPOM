package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By userName= By.id("session_key");
	By password= By.id("session_password");
	By signInButton= By.xpath("//button[contains(text(),'Sign in')]");
	By homePageHeader= By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/h4[1]");
	By loginPageHeader= By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/h1[1]");



	public void setUserName(String UN) {
		driver.findElement(userName).sendKeys(UN);	

	}
	public void setpassword(String PW) {
		driver.findElement(password).sendKeys(PW);	

	}

	public void clickOnSignInButton() {
		driver.findElement(signInButton).click();

	}



	public  String getLoginPageHeader() {
		return driver.findElement(loginPageHeader).getText();
	}
}

