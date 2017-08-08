package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingOverviewPage extends BasePage {

	@FindBy(xpath = ".//*[@id='top']/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/div[4]/div/p/em/time")
	private WebElement arrivalTimeText;

	public BookingOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getArrivalTime() {

		String arrivalTime = arrivalTimeText.getText();
		return arrivalTime;

	}
}