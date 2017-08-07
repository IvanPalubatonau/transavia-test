package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage extends BasePage {

	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/section/div[1]/div/div[2]/div/form/ol/li[3]/div/div/span[1]")
	private WebElement dateOutboundFlight;

	@FindBy(xpath = ".//button[@class='button button-secondary close-trigger']")
	private WebElement closeButton;

	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")
	private WebElement selectOutboundFlightButton;

	@FindBy(xpath = ".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/section/div[1]/div/div[2]/div/form/ol/li[1]/div/div/span[1]")
	private WebElement dateInboundFlight;

	@FindBy(xpath = ".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")
	private WebElement selectInboundFlightButton;

	@FindBy(xpath = ".//*[@id='top']/form/div[1]/div/footer/div/div/section/div/button")
	private WebElement nextPageButton;

	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/div[1]/div/div[1]/div/h4")
	private WebElement flightInformation;

	public BookFlightPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectOutboundFlight() {

		dateOutboundFlight.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectOutboundFlightButton.click();

	}

	public void selectInboundFlight() {

		dateInboundFlight.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectInboundFlightButton.click();

	}

	public ExtraInfornationTripPage transitionNextPage() {

		nextPageButton.click();
		return new ExtraInfornationTripPage(driver);

	}

	public String getFlightInformation() {

		String flight = flightInformation.getAttribute("innerHTML");
		return flight;

	}

}
