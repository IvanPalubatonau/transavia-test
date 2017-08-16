package by.epam.transavia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleFlightPage extends BasePage {
	
	@FindBy(xpath = ".//*[@id='openJawRouteSelection_DepartureStationOutbound-input']")
	private WebElement outboundFlightDeparture;

	@FindBy(xpath = ".//*[@id='openJawRouteSelection_ArrivalStationOutbound-input']")
	private WebElement outboundFlightDestination;

	@FindBy(xpath = ".//*[@id='dateSelection_OutboundDate-datepicker']")
	private WebElement outboundDate;

	@FindBy(xpath = ".//*[@id='openJawRouteSelection_DepartureStationInbound-input']")
	private WebElement inboundFlightDeparture;

	@FindBy(xpath = ".//*[@id='openJawRouteSelection_ArrivalStationInbound-input']")
	private WebElement inboundFlightDestination;

	@FindBy(xpath = ".//*[@id='dateSelection_InboundDate-datepicker']")
	private WebElement inboundDate;

	@FindBy(xpath = ".//*[@id='flights']/div/section/div[3]/div/button[2]")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/section/div[1]/div/div[2]/div/form/ol/li[2]/div/div/span[1]")
	private WebElement outboundDay;
	
	@FindBy(xpath = ".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")
	private WebElement outboundDaySelectButton;
	
	@FindBy(xpath = ".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/section/div[1]/div/div[2]/div/form/ol/li[5]/div/div/span[1]")
	private WebElement inboundDay;
	
	@FindBy(xpath = ".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")
	private WebElement inboundDaySelectButton;
	
	@FindBy(xpath = ".//*[@id='top']/form/div[1]/div/footer/div/div/section/div/div/div[2]/div/div/div[2]")
	private WebElement totalAmount;
	
	public MultipleFlightPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectOutboundFlightDeparture(String country) {

		outboundFlightDeparture.click();
		outboundFlightDeparture.sendKeys(country);
		
		
	}

	public void selectOutboundFlightDestination(String country) {

		outboundFlightDestination.click();
		outboundFlightDestination.sendKeys(country);
		
		
	}
	
	public void selectOutboundDate(String date) {

		outboundDate.click();
		outboundDate.clear();
		outboundDate.sendKeys(date);
		
		
	}
	public void selectInboundFlightDeparture(String country) {

		inboundFlightDeparture.click();
		inboundFlightDeparture.sendKeys(country);
		
		
	}

	public void selectInboundFlightDestination(String country) {

		inboundFlightDestination.click();
		inboundFlightDestination.sendKeys(country);
		
		
	}
	
	public void selectInboundDate(String date) {

		inboundDate.click();
		inboundDate.clear();
		inboundDate.sendKeys(date);
		
		
	}
	
	public void searchFlight() {

		searchButton.click();
		searchButton.click();
		
	}
	public void selectOutboundDay() {

		outboundDay.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='top']/div/div/div[3]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")));
		outboundDaySelectButton.click();

	}
	
	public void selectInboundDay() {

		inboundDay.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='top']/div/div/div[4]/section/section/div/div[1]/div[2]/div/div[3]/div/form/div/button")));
		inboundDaySelectButton.click();

	}
	
	public String getTotalAmount(){
		totalAmount.click();
		String total=totalAmount.getText();
		return total;
	}
}
