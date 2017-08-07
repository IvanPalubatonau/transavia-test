package by.epam.transavia;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TotalTicketSumTest extends BaseTest {
	private MainPage mainPage;
	private BookFlightPage bookFlightPage;
	private ExtraInfornationTripPage extraInfornationTripPage;

	private static final String COUNTRY_OF_DEPARTURE = "Lisbon, Portugal";
	private static final String COUNTRY_OF_DESTINATION = "Paris (Orly South), France";
	private static final int QUANTITY_OF_ADULT = 2;
	private static final int QUANTITY_OF_CHILDREN = 1;

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mainPage.selectCountryOfDeparture(COUNTRY_OF_DEPARTURE);
		mainPage.selectCountryOfDestination(COUNTRY_OF_DESTINATION);
		mainPage.selectQuantityOfPassenger(QUANTITY_OF_ADULT, QUANTITY_OF_CHILDREN);
		bookFlightPage = mainPage.searchFlight();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bookFlightPage.selectOutboundFlight();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bookFlightPage.selectInboundFlight();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		extraInfornationTripPage = bookFlightPage.transitionNextPage();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		extraInfornationTripPage.selectPlusFare();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void totalPriceTest() {
		String totalPrice = extraInfornationTripPage.getTotalPrice();
		System.out.println(totalPrice);
		Assert.assertEquals(totalPrice, "€ 1,095.00");

	}

}