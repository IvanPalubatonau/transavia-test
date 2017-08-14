package by.epam.transavia;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuestFlightTest extends BaseTest {

	private static final String COUNTRY_OF_DEPARTURE = "Dubai, United Arab Emirates";
	private static final String COUNTRY_OF_DESTINATION = "Agadir, Morocco";
    private static final String EXCPECTED_MESSAGE = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco. However, we do fly from Dubai, United Arab Emirates to other destinations. Please change your destination and try again.";
	
	private MainPage mainPage;
	private BookFlightPage bookFlightPage;

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		waiting();
		mainPage.selectCountryOfDeparture(COUNTRY_OF_DEPARTURE);
		mainPage.selectCountryOfDestination(COUNTRY_OF_DESTINATION);
		bookFlightPage = mainPage.searchFlight();
	}
	
	@Test(priority = 1)
	public void titleTest() {
		String attantionMessage = bookFlightPage.getAttantionMessage();
		Assert.assertEquals(attantionMessage, EXCPECTED_MESSAGE);
	}
}
