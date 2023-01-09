package TestClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class_2 {

	WebDriver driver;
	public LoginPage lp;
	public HomePage hp;

	@BeforeClass
	public void browserInitialsation() {
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://app-dev.wishup.co/login");

		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.manage().window().maximize();

	}

	@Test
	public void TestLoginPageByInValid() {
		lp.setEmailID("wishup_testuser2@gmail.com");
		lp.setPassword("testpw2");
		lp.clickOnLogin();
		lp.LoginFailed();

	}

	@AfterMethod
	public void Tear_Down() {
		driver.close();
	}

}
