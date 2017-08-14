package by.epam.transavia;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrivalTimeTest extends BaseTest {

	private MainPage mainPage;
	private LogonPage logonPage;
	private BookingOverviewPage bookingOverviewPage;
	
	private static final String BOOKING_NUMBER = "MF8C9R";
	private static final String LAST_NAME = "kukharau";
	private static final String FLIGHT_DATE = "9 June 2016";
	private static final String EXPECTED_ARRIVAL_TIME = "23:35";
	
	

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		waiting();
		mainPage.manageBooking();
		logonPage = mainPage.viewBooking();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logonPage.enterBookingNumber(BOOKING_NUMBER);
		logonPage.enterLastName(LAST_NAME);
		logonPage.enterFlightDate(FLIGHT_DATE);
		bookingOverviewPage=logonPage.transitionBookingOveriew();
	}

	@Test
	public void arrivalTimeTest() {
		String arrivalTime = bookingOverviewPage.getArrivalTime();
		Assert.assertEquals(arrivalTime, EXPECTED_ARRIVAL_TIME);
	}
}