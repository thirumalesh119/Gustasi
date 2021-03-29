package PageObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicObjects {
public WebDriver driver;

public BasicObjects(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this );
}
@FindBy(xpath="//input[@type=\"text\"]")
WebElement searchBox;

public WebElement searchBox() {
	return searchBox;
}
@FindBy(xpath="//*[@class=\"serach-icon-bar\"]/button")
WebElement searchIcon;
public WebElement searchIcon() {
	return searchIcon;
}
@FindBy(xpath="//div[@class=\"top-features-area seach-area\"]/div[1]")
WebElement areaSearch;

public WebElement areaSearch() {
	return areaSearch;
}
}
