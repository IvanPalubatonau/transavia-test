package by.epam.transavia;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
	String textOnMainPage;
	@BeforeClass
	public void openMainPage() {

		MainPage mainPage = navigate(MainPage.URL);
		 textOnMainPage=mainPage.textOfMainPageTitle();
	}

	@Test
	public void doLogin() {

		System.out.println(textOnMainPage);
		
	}
}
