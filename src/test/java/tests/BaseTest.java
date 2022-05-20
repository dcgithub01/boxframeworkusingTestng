package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pages.BasePage;
import pages.LoginPage;

public class BaseTest {
	public Properties prop;
	public WebDriver driver;
	public LoginPage lp;
	@BeforeMethod
	public LoginPage init_setup()
	{
		BasePage bp= new BasePage();
		prop=bp.init_prop();
		driver=bp.init_driver(prop.getProperty("browser"));
		 lp= new LoginPage(driver);
		return lp;
	}
	
	@AfterMethod
	public void tear_down()
	{
		driver.quit();
	}

}
