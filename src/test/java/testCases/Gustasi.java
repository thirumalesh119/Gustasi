package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Gustasi.automation.Base;
import PageObjectRepositories.BasicObjects;
import PageObjectRepositories.LoginPage;
import PageObjectRepositories.SuccessfulLogin;

public class Gustasi extends Base {

	public WebDriver driver;
	PageObjectRepositories.LoginPage login;
	BasicObjects basic;
	Actions action;
	public double price = 500.0;
	// @Test
	public void launchSite() throws IOException {

		driver = launchBrowser();
		// driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		login = new LoginPage(driver);
		action = new Actions(driver);
	}

	// @Test(dataProvider="getData")
	public void loginTestCases(String username, String password) throws InterruptedException, IOException {
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
		object[0][0] = "pathuri.thirumalesh19@gmail.com";
		object[0][1] = "13579Thiru!";
		object[1][0] = "pathuri.thirumalesh19@gmail.com";
		object[1][1] = "13579Thiru@";
		return object;
	}

	@Test
	public void addProductsToBag() throws IOException, InterruptedException {
		driver = launchBrowser();
		basic = new BasicObjects(driver);
		basic.searchBox().sendKeys("hyderabad");
		Thread.sleep(3000);
		List<WebElement> totalAreas = driver.findElements(By.xpath("//div[@class=\'pac-item\']"));
		System.out.println(totalAreas.size());
		for (int i = 0; i < totalAreas.size(); i++) {
			driver.findElements(By.xpath("//div[@class=\'pac-item\']")).get(i).click();
			break;
		}
		Thread.sleep(3000);
		WebElement Hotels = driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12']"));
		Thread.sleep(3000);
		List<WebElement> totalHotels = Hotels.findElements(By.xpath("//a[contains(@href,'gustasi.com')]"));
		System.out.println(totalHotels.size());

		for (int i = 0; i < 1; i++) {
			// String click = Keys.chord(Keys.CONTROL,Keys.ENTER);
			driver.findElements(By.xpath("//a[contains(@href,'gustasi.com/chef')]")).get(i).click();
			Thread.sleep(3000);
			int size = driver.findElements(By.xpath("//div[@class=\'pull-right\']/span")).size();
			for (int j = 0; j < size; j++) {
				String pricing = "";
				driver.findElements(By.xpath("//div[@class=\'pull-right\']/span")).get(j).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class=\'btn btn-success btn-block full-block-cart-btn\']")).click();
				driver.findElement(By.xpath("//*[@id=\"ItemViewPopup\"]/div/div/div[1]/button")).click();
				Thread.sleep(5000);
				pricing = driver.findElement(By.xpath("//div[@class=\'row list-row total\']/div[2]")).getText();
				System.out.println(pricing);
				String[] splitting = pricing.split(" ");
//				System.out.println(splitting.length);
//				System.out.println(splitting[1]);
				double cost = Double.parseDouble(splitting[1]);
				 if(cost>=price) {
					 break;
				 }

			}

		}
		driver.findElement(By.xpath("//div[@class=\"price-section2\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"checkout-section\"]/div/div[1]/div[1]")).click();
        SuccessfulLogin sLogin = new SuccessfulLogin(driver);
        
        sLogin.loginForValidUser();
        
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-xs-12 col-md-8 col-lg-8 col-sm-12\"]/div[2]/div/div[3]/div/div[1]")));
        
        driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-8 col-lg-8 col-sm-12']/div[2]/div/div[3]/div/div[1]")).click();
        WebElement calendar=driver.findElement(By.xpath("//div[@class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 shadow-box\"]/div/div[2]"));
        
        List<WebElement> dates = calendar.findElements(By.xpath("//div[@class=\"col-md-6 col-sm-6 col-xs-12\"][2]/div/div"));
        System.out.println(dates.size());
        
        for(int i=0;i<dates.size();i++) {
        	String text=driver.findElements(By.xpath("//div[@class=\"col-md-6 col-sm-6 col-xs-12\"][2]/div/div")).get(i).getText();
        	if(text.equalsIgnoreCase("10")) {
        		System.out.println("10th got selected by the user");
        		driver.findElements(By.xpath("//div[@class=\"col-md-6 col-sm-6 col-xs-12\"][2]/div/div")).get(i).click();
        		break;
        	}
        			
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-sm-12 col-md-12 col-lg-12\"]/div/div[1]")));

        
       driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-12 col-lg-12\"]/div/div[1]")).click(); 
      
       List<WebElement> deliveryTime = driver.findElements(By.xpath("//div[@class=\"col-sm-12 col-md-12 col-lg-12\"]/div/div/div/div[2]/div[2]/div"));
       System.out.println(deliveryTime.size()); 
       for(int i=0;i<deliveryTime.size();i++) {
        	String text=driver.findElements(By.xpath("//div[@class=\"col-sm-12 col-md-12 col-lg-12\"]/div/div/div/div[2]/div[2]/div")).get(i).getText();
        	if(text.equalsIgnoreCase("11")) {
        		System.out.println("entered into if loop for deliverytime");
        		driver.findElements(By.xpath("//div[@class=\"col-sm-12 col-md-12 col-lg-12\"]/div/div/div/div[2]/div[2]/div")).get(i).click();
        		break;
        	}
        }

        
        /*
		 * Set<String> windows = driver.getWindowHandles();
		 * 
		 * Iterator it = windows.iterator(); while(it.hasNext()) {
		 * 
		 * driver.switchTo().window((String) it.next()); }
		 * 
		 */
		Thread.sleep(3000);

		driver.close();

	}

}