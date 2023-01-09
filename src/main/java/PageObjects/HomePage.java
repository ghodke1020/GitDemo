package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]")
	private WebElement Test_Combo_Button;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[6]")
	private WebElement logout_Button;

	public void clickOnLogout() {

		Actions s = new Actions(driver);
		s.moveToElement(Test_Combo_Button);
		s.build().perform();
		logout_Button.click();
		// Logout_Button.click();
		// Logout_Button.click();
	}

}
