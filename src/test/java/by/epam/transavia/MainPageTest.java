package by.epam.transavia;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
	public static final String MAINPAGETITLE = "Where do you want to go?";
	public static final String COUNTRYOFDEPARTURE = "Barcelona, Spain";
	public static final String COUNTRYOFDESTINATION = "Munich, Germany";
	public static final String OUTBOUNDDATE = "21 Aug 2017";

	private MainPage mainPage;

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
		Assert.assertEquals(textOnMainPage, MAINPAGETITLE);
	}

	@Test(priority = 2)
	public void departureCountryTest() {
		String departureCountry = mainPage.selectCountryOfDeparture(COUNTRYOFDEPARTURE);
		Assert.assertEquals(departureCountry, COUNTRYOFDEPARTURE);
	}

	@Test(priority = 3)
	public void destinationCountryTest() {
		String destinationCountry = mainPage.selectCountryOfDestination(COUNTRYOFDESTINATION);
		Assert.assertEquals(destinationCountry, COUNTRYOFDESTINATION);
	}

	@Test(priority = 4)
	public void outboundDateTest() {
		String outboundDate = mainPage.selectOutboundDate(OUTBOUNDDATE);
		Assert.assertEquals(outboundDate, OUTBOUNDDATE);
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
		String flightNumber = mainPage.searchFlight();
		System.out.println(flightNumber);
	}
}
