package by.epam.transavia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected WebDriver driver;

	private static final String LAST_ELEMENT_ON_PAGE = ".//*[@id='routeSelection_DepartureStation-input']";

	@BeforeClass
	public WebDriver startBrowser() {

		System.setProperty("webdriver.gecko.driver", "d:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

	public void waiting() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LAST_ELEMENT_ON_PAGE)));
	}

}