package by.epam.transavia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;



public class BaseTest {
	protected WebDriver driver;

	@BeforeClass
	public WebDriver startBrowser() {

		System.setProperty("webdriver.gecko.driver", "d:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	
	protected MainPage navigate(String url) {
		
		driver.get(url);
		
		return new MainPage(driver);
	}

	
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}