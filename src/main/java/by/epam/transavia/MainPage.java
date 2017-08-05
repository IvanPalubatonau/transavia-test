package by.epam.transavia;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
	public static final String URL = "https://www.transavia.com/en-UK/home/";

	@FindBy(id = ".//*[@id='desktop']/section/div[1]/h1")
	private WebElement inscriptionOfPage;

	@FindBy(id = ".//*[@id='routeSelection_DepartureStation-input']")
	private WebElement departureWindow;

	@FindBy(id = ".//*[@id='routeSelection_ArrivalStation-input']")
	private WebElement destinationWindow;

	@FindBy(id = ".//*[@id='dateSelection_OutboundDate-datepicker']")
	private WebElement outboundDateWindow;

	@FindBy(id = ".//*[@id='dateSelection_IsReturnFlight-datepicker']")
	private WebElement returnDateWindow;

	@FindBy(id = ".//*[@id='desktop']/section/div[2]/div[2]/div/div/div[2]/div/div[1]/label")
	private WebElement checkBox;

	@FindBy(id = ".//*[@id='booking-passengers-input']")
	private WebElement bookingPassengersWindow;

	@FindBy(id = ".//*[@id='desktop']/section/div[3]/div/button")
	private WebElement searchButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String textOfMainPageTitle(){
		
		String text=inscriptionOfPage.getText();
		
		return text;
		
	}
}
