package PageObjectRepositories;

import org.openqa.selenium.WebDriver;

public class SuccessfulLogin extends LoginPage {
	private WebDriver driver;

	public SuccessfulLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void loginForValidUser() throws InterruptedException {
		
		//loginButton.click();
		userName().sendKeys("pathuri.thirumalesh19@gmail.com");
		password().sendKeys("13579Thiru@");
		Thread.sleep(5000);
		submitButton().click();
		
	}
}
