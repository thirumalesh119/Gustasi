package PageObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

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
@FindBy(xpath="//input[@id='username']")
WebElement username;
public WebElement userName() {
	return username;
}
@FindBy(xpath="//input[@id='password']")
WebElement password;
public WebElement password() {
	return password;
}
@FindBy(xpath="//button[@type=\"submit\"]")
WebElement submitButton;
public WebElement submitButton() {
	return submitButton;
}
@FindBy(xpath="//a[contains(text(),\"Logout\")]")
WebElement logoutButton;
public WebElement logoutButton() {
	return logoutButton;
}
@FindBy(xpath="//*[@id=\"home\"]/div/nav/div/div[2]")
WebElement homeButton;
public WebElement homeButton() {
	return homeButton;
}
//public void loginToGustasi() {
//	 loginButton().click();
//     userName().sendKeys("pathuri.thirumalesh19@gmail.com");
//     password().sendKeys("13579Thiru@");
//     submitButton().click();
//}

}
