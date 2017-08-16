package by.epam.transavia;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleFlightTest extends BaseTest {
	
	private MainPage mainPage;
	private MultipleFlightPage multipleFlightPage;
	
	private static final String OUTBOUND_COUNTRY_OF_DEPARTURE = "Bologna, Italy";
	private static final String OUTBOUND_COUNTRY_OF_DESTINATION = "Eindhoven, Netherlands";
	private static final String INBOUND_COUNTRY_OF_DEPARTURE = "Amsterdam (Schiphol), Netherlands";
	private static final String INBOUND_COUNTRY_OF_DESTINATION = "Agadir, Morocco";
	private static final String OUTBOUND_DATE="21 Aug 2017";
	private static final String INBOUND_DATE="28 Aug 2017";
	private static final String TEST_AMOUNT = "€ 0.00";
	

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		waiting();
		multipleFlightPage=mainPage.openMultiplePage();
		waiting();
		multipleFlightPage.selectOutboundFlightDeparture(OUTBOUND_COUNTRY_OF_DEPARTURE);
		multipleFlightPage.selectOutboundFlightDestination(OUTBOUND_COUNTRY_OF_DESTINATION);
		multipleFlightPage.selectOutboundDate(OUTBOUND_DATE);
		multipleFlightPage.selectInboundFlightDeparture(INBOUND_COUNTRY_OF_DEPARTURE);
		multipleFlightPage.selectInboundFlightDestination(INBOUND_COUNTRY_OF_DESTINATION);
		multipleFlightPage.selectInboundDate(INBOUND_DATE);
		multipleFlightPage.searchFlight();
		waiting();
		multipleFlightPage.selectOutboundDay();
		WebElement webElement=driver.findElement(By.xpath(".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/section/div[1]/div/div[2]/div/form/ol/li[4]/div/div/span[1]"));
		webElement.sendKeys(Keys.PAGE_DOWN);
		waiting();
		multipleFlightPage.selectInboundDay();
		waiting();

	}
	
	@Test
	public void multipleFlightTest() {
		String totalAmount = multipleFlightPage.getTotalAmount();
		//System.out.println(totalAmount);
		Assert.assertNotEquals(totalAmount, TEST_AMOUNT);
	}
}
