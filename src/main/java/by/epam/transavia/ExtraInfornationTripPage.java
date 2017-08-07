package by.epam.transavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtraInfornationTripPage extends BasePage {
	
	@FindBy(xpath = ".//*[@id='top']/div[1]/div[1]/div/div/div[2]/div/div[2]/table/thead/tr/th[3]")
	private WebElement selectPlusFare;

	@FindBy(xpath = ".//*[@id='top']/div[2]/form/div[1]/div/footer/div/div/a/section/p/span")
	private WebElement detailsOfFlight;
		
	@FindBy(xpath = "html/body/div[5]/div[3]/div/div/aside/div/div[9]/div/div[2]/p")
	private WebElement totalPrice;

	public ExtraInfornationTripPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectPlusFare(){
		selectPlusFare.click();
	}
	
	public String getTotalPrice(){
		detailsOfFlight.click();
		String price=totalPrice.getText();
		return price;
	}

}
