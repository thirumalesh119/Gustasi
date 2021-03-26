package Gustasi.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;

	Properties prop;

	public WebDriver launchBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fp = new FileInputStream(
				"/home/THIRUMALESH.PATURI/Music/Gustasi/src/main/java/Gustasi/automation/dataproperties");
		prop.load(fp);
		String browserName = prop.getProperty("browser");
		String siteurl = prop.getProperty("url");

		if (browserName.equals("chrome")) {

			String path = prop.getProperty("chromeBrowserPath");
			System.setProperty("webdriver.chrome.driver", "/home/THIRUMALESH.PATURI/Music/chromedriver_linux64 (1)/chromedriver");
			driver = new ChromeDriver();
			driver.get(siteurl);
			driver.manage().window().maximize();
		}
		if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "firefoxpath");
		}
		return driver;

	}
}
