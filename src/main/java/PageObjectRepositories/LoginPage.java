package PageObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;



public LoginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[contains(text(),'Login')]")
WebElement loginButton;

public WebElement loginButton() {
	return loginButton;
}


}
