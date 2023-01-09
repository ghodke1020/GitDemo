package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class_1 {

	WebDriver driver;
	public LoginPage lp;
	public HomePage hp;

	@BeforeClass
	public void browserInitialsation() {
	//	WebDriverManager.chromedriver().setup();
	//	WebDriver driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://app-dev.wishup.co/login");

		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.manage().window().maximize();
		
	}

	@Test(dataProvider = "Valid logindetails")
	public void TestLoginPageByValid(String email, String pass) throws InterruptedException {
		Thread.sleep(3000);
		lp.setEmailID(email);
		lp.setPassword(pass);
		lp.clickOnLogin();
		hp.clickOnLogout();

	}

	@DataProvider(name = "Valid logindetails")
	public Object[][] Valid_login_ID_Password() {

		Object[][] login_ID_Password = new Object[3][2];
		login_ID_Password[0][0] = "wishup_testuser1@gmail.com";
		login_ID_Password[0][1] = "testpw1";

		login_ID_Password[1][0] = "wishup_testuser3@gmail.com";
		login_ID_Password[1][1] = "testpw3";

		login_ID_Password[2][0] = "wishup_testuser4@gmail.com";
		login_ID_Password[2][1] = "testpw4";

		return login_ID_Password;
	}
	

	
	
	

	
}
