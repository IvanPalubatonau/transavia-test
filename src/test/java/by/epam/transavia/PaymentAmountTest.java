package by.epam.transavia;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentAmountTest extends BaseTest {
	private MainPage mainPage;
	private LogonPage logonPage;
	private BookingOverviewPage bookingOverviewPage;
	private BookingDetailPage bookingDetailPage;

	private static final String BOOKING_NUMBER = "MF8C9R";
	private static final String LAST_NAME = "kukharau";
	private static final String FLIGHT_DATE = "9 June 2016";
	

	@BeforeClass
	public void openMainPage() {

		mainPage = navigate(MainPage.URL);
		waiting();
		mainPage.manageBooking();
		logonPage = mainPage.viewBooking();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BOOKING_NUMBER)));
		logonPage.enterBookingNumber(BOOKING_NUMBER);
		logonPage.enterLastName(LAST_NAME);
		logonPage.enterFlightDate(FLIGHT_DATE);
		bookingOverviewPage = logonPage.transitionBookingOveriew();
		bookingDetailPage = bookingOverviewPage.transitionBookingDetail();
	}

	@Test
	public void paymentAmountTest() {
		String sum = bookingDetailPage.getSum();
		String paymentAmount = bookingDetailPage.getPaymentAmount();
		Assert.assertEquals(sum, paymentAmount);
	}
}
