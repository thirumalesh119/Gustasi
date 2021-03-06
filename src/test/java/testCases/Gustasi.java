package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Gustasi.automation.Base;
import PageObjectRepositories.BasicObjects;
import PageObjectRepositories.LoginPage;
public class Gustasi extends Base {
	
	public WebDriver driver;
	 PageObjectRepositories.LoginPage login;
	 BasicObjects basic;
	 Actions action;
	
	@Test
	public void launchSite() throws IOException {
		
	 driver=launchBrowser();
     //driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
       login = new LoginPage(driver);
     action = new Actions(driver);
	}
	@Test(dataProvider="getData")
	public void loginTestCases(String username,String password) throws InterruptedException, IOException {
		launchBrowser();
		 login.loginButton().click();
	     login.userName().sendKeys(username);
	     login.password().sendKeys(password);
	     login.submitButton().click();
	     Thread.sleep(3000);
	   login.homeButton().click();
	     
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] object = new Object[2][2];
		object[0][0]="pathuri.thirumalesh19@gmail.com";
		object[0][1]="13579Thiru!";
		object[1][0]="pathuri.thirumalesh19@gmail.com";
		object[1][1]="13579Thiru@";
		return object;
	}
	@Test
	public void addProductsToBag() throws IOException {
		driver=launchBrowser();
		driver.close();
		
        
	}
	

}