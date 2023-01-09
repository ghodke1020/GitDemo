package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="email") private WebElement Login_ID;
	
	@FindBy(name="password") private WebElement Login_Password;
	
	@FindBy(xpath="//input[@class='ui wishup_green_button fluid circular button']") private WebElement Login_Button;
	
	@FindBy(xpath="//div[contains(text(),'Please correct error in form')]") private WebElement Login_Error;
	
	public void setEmailID(String email)
	{
		Login_ID.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		Login_Password.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		Login_Button.click();
	}
	
	public void LoginFailed()
	{
				
		SoftAssert s=new SoftAssert();
		s.assertEquals(Login_Error.isDisplayed(), false);
		
	}

}
