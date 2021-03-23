package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Gustasi.automation.Base;
import PageObjectRepositories.LoginPage;
public class Gustasi extends Base {
	
	public WebDriver driver;
	 PageObjectRepositories.LoginPage login;
	@Test
	public void launchSite() throws IOException {
		
	
	 driver=launchBrowser();
     //driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
      LoginPage login = new LoginPage(driver);
      login.loginButton().click();
}
}