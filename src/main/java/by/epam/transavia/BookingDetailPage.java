package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingDetailPage extends BasePage {
	
	@FindBy(xpath = ".//*[@id='top']/div/div[5]/div/div/div/section/div[5]/div/div[2]/div/div/div")
	private WebElement sumText;
	
	@FindBy(xpath = ".//*[@id='top']/div/div[6]/section/div/div[2]/div/div/div[2]/div")
	private WebElement paymentAmountText ;
	
	public BookingDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getSum() {

		String sum = sumText.getText();
		return sum;

	}
	public String getPaymentAmount() {

		String paymentAmount = paymentAmountText.getText();
		return paymentAmount;

	}
}
