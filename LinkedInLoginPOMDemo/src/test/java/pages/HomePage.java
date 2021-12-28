package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}


	By homePageHeader= By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]");



	public  String getHomePageHeader() {
		return driver.findElement(homePageHeader).getText();
	}

}

