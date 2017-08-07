package by.epam.transavia;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
	private static final String MAIN_PAGE_TITLE = "Where do you want to go?";
	private static final String COUNTRY_OF_DEPARTURE = "Barcelona, Spain";
	private static final String COUNTRY_OF_DESTINATION = "Munich, Germany";
	private static final String OUTBOUND_DATE = "21 Aug 2017";

	private MainPage mainPage;
	private BookFlightPage bookFlightPage;

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void titleTest() {
		String textOnMainPage = mainPage.textOfMainPageTitle();
		Assert.assertEquals(textOnMainPage, MAIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void departureCountryTest() {
		String departureCountry = mainPage.selectCountryOfDeparture(COUNTRY_OF_DEPARTURE);
		Assert.assertEquals(departureCountry, COUNTRY_OF_DEPARTURE);
	}

	@Test(priority = 3)
	public void destinationCountryTest() {
		String destinationCountry = mainPage.selectCountryOfDestination(COUNTRY_OF_DESTINATION);
		Assert.assertEquals(destinationCountry, COUNTRY_OF_DESTINATION);
	}

	@Test(priority = 4)
	public void outboundDateTest() {
		String outboundDate = mainPage.selectOutboundDate(OUTBOUND_DATE);
		Assert.assertEquals(outboundDate, OUTBOUND_DATE);
	}

	@Test(priority = 5)
	public void checkboxTest() {
		boolean checked = mainPage.returnOnToUncheked();
		Assert.assertEquals(checked, false);

	}

	@Test(priority = 6)
	public void arrivalDateTest() {
		String arrivalDate = mainPage.selectArrivakDate();
		Assert.assertEquals(arrivalDate, "Single flight");
	}

	@Test(priority = 7)
	public void bookingPassengerTest() {
		String countOfPassengers = mainPage.bookingPassenger();
		Assert.assertEquals(countOfPassengers, "1 Adult");
	}
	@Test(priority = 8)
	public void flightTest() {
		bookFlightPage = mainPage.searchFlight();
		String flightInformation=bookFlightPage.getFlightInformation();
		Assert.assertEquals(flightInformation, "Barcelona – Munich");
	}
}
