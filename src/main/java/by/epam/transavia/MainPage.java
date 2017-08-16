package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

	public static final String URL = "https://www.transavia.com/en-UK/home/";

	@FindBy(xpath = "//*[@id='desktop']/section/div[1]/h1")
	private WebElement inscriptionOfPage;

	@FindBy(xpath = ".//*[@id='routeSelection_DepartureStation-input']")
	private WebElement departureWindow;

	@FindBy(xpath = "//input[@id='routeSelection_DepartureStation-input']/../../../div[2]/span[1]")
	private WebElement textInDepartureWindow;

	@FindBy(xpath = ".//*[@id='routeSelection_ArrivalStation-input']")
	private WebElement destinationWindow;

	@FindBy(xpath = "//input[@id='routeSelection_ArrivalStation-input']/../../../div[2]/span[1]")
	private WebElement textInDestinationWindow;

	@FindBy(xpath = ".//*[@id='dateSelection_OutboundDate-datepicker']")
	private WebElement outboundDateWindow;

	@FindBy(xpath = ".//*[@id='dateSelection_IsReturnFlight-datepicker']")
	private WebElement returnDateWindow;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[2]/div/div/div[2]/div/div[1]/label")
	private WebElement checkBox;

	@FindBy(xpath = ".//*[@id='booking-passengers-input']")
	private WebElement bookingPassengersWindow;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[3]/div/div[1]/div/div")
	private WebElement quantityOfBookingPassengers;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/button[2]")
	private WebElement addAdultButton;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/div/button[2]")
	private WebElement addChildrenButton;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/div/button[2]")
	private WebElement addBabyButton;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[2]/button")
	private WebElement saveQuantityOfPassengerButton;

	@FindBy(xpath = ".//*[@id='desktop']/section/div[3]/div/button")
	private WebElement searchButton;
	
	@FindBy(xpath = "html/body/header/nav/div[1]/div[1]/ul/li[3]/a")
	private WebElement manageBookingButton;
	
	@FindBy(xpath = ".//*[@id='horizontal-sub-navigation-manageyourbooking']/div/div[2]/div/div[1]/div/ul/li[2]/a/div/span[2]")
	private WebElement viewBookingButton;
	
	@FindBy(xpath = ".//*[@id='desktop']/section/div[3]/ul/li[2]/a")
	private WebElement multipleDestinationButtton;
	

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String textOfMainPageTitle() {

		String text = inscriptionOfPage.getText();
		return text;
	}

	public String selectCountryOfDeparture(String country) {

		departureWindow.click();
		departureWindow.sendKeys(country);
		inscriptionOfPage.click();
		String nameOfCountry = textInDepartureWindow.getAttribute("innerHTML");
		return nameOfCountry;

	}

	public String selectCountryOfDestination(String country) {

		destinationWindow.click();
		destinationWindow.sendKeys(country);
		inscriptionOfPage.click();
		String nameOfCountry = textInDestinationWindow.getAttribute("innerHTML");
		return nameOfCountry;

	}

	public String selectOutboundDate(String date) {

		outboundDateWindow.click();
		outboundDateWindow.clear();
		outboundDateWindow.sendKeys(date);
		String dateOfDeparture = outboundDateWindow.getAttribute("value");
		return dateOfDeparture;

	}

	public boolean returnOnToUncheked() {

		checkBox.click();
		boolean check = checkBox.isSelected();
		return check;

	}

	public String selectArrivakDate() {

		returnDateWindow.click();
		String dateOfDeparture = returnDateWindow.getAttribute("placeholder");
		return dateOfDeparture;

	}

	public String bookingPassenger() {

		bookingPassengersWindow.click();
		String quantityOfPassengers = quantityOfBookingPassengers.getAttribute("innerHTML");
		return quantityOfPassengers;

	}

	public BookFlightPage searchFlight() {

		searchButton.click();
		return new BookFlightPage(driver);

	}

	public String selectQuantityOfPassenger(int addAdult, int addChildren) {

		bookingPassengersWindow.click();

		if (addAdult > 1) {
			for (int i = 0; i < addAdult - 1; i++) {
				addAdultButton.click();
			}
		}

		if (addChildren > 0) {
			for (int i = 0; i < addChildren; i++) {
				addChildrenButton.click();
			}
		}

		saveQuantityOfPassengerButton.click();
		String quantityOfPassengers = quantityOfBookingPassengers.getAttribute("innerHTML");
		return quantityOfPassengers;

	}
	
	public void manageBooking() {

		manageBookingButton.click();
		
	}
	
	public LogonPage viewBooking() {

		viewBookingButton.click();
		return new LogonPage(driver);
		
	}

	public MultipleFlightPage openMultiplePage() {

		multipleDestinationButtton.click();
		return new MultipleFlightPage(driver);
		
	}
}
