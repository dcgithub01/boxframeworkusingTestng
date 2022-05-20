package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.Constants;

public class LoginTest extends BaseTest {
//	LoginPage lp;
	//WebDriver driver;
	
	@Test(priority =1 )
	public void verifyTitle()
	{
		String actualtitle= lp.getPageTitle();
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyLogin()
	{
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
