package by.epam.transavia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;



public class BaseTest {
	private WebDriver driver;

	@BeforeClass
	public WebDriver startBrowser() {

		System.setProperty("webdriver.gecko.driver", "d:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}

	
	protected MainPage navigate(String url) {
		
		driver.get(url);
		
		return new MainPage(driver);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}