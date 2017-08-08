package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogonPage extends BasePage{
	
	@FindBy(xpath = ".//*[@id='retrieveBookingByLastname_RecordLocator']")
	private WebElement bookingNumberField;
	
	@FindBy(xpath = ".//*[@id='retrieveBookingByLastname_LastName']")
	private WebElement lastNameField ;
	
	@FindBy(xpath = ".//*[@id='retrieveBookingByLastname_FlightDate-datepicker']")
	private WebElement flightDateField;
	
	@FindBy(xpath = ".//*[@id='access-booking']/div/div/div[4]/button")
	private WebElement viewBookingButton;
	
	public LogonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterBookingNumber(String bookingNumber) {

		bookingNumberField.click();
		bookingNumberField.sendKeys(bookingNumber);
	}
	
	public void enterFlightDate(String flightDate) {

		flightDateField.click();
		flightDateField.clear();
		flightDateField.sendKeys(flightDate);
		bookingNumberField.click();
	}
	
	public void enterLastName(String lastName) {

		lastNameField.click();
		lastNameField.sendKeys(lastName);
	}
	public BookingOverviewPage transitionBookingOveriew() {

		viewBookingButton.click();
		return new BookingOverviewPage(driver);
	}
}
