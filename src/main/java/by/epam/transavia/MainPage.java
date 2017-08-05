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
	private WebElement countOfBookingPassengers;
	
	@FindBy(xpath = ".//*[@id='desktop']/section/div[3]/div/button")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/div[1]/div/div[1]/div/h4")
	private WebElement flight;
	

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
		String countOfPassengers = countOfBookingPassengers.getAttribute("innerHTML");
		return countOfPassengers;

	}

	public String searchFlight() {

		searchButton.click();
		String flightNumber = flight.getAttribute("innerHTML");
		return flightNumber;
		

	}
}
