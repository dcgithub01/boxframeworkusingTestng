package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Constants;

public class LoginTest extends BaseTest {
//	LoginPage lp;
	// WebDriver driver;
	private static Logger log = org.apache.logging.log4j.LogManager.getLogger(tests.LoginTest.class.getName());

	@Test(priority = 1)
	public void verifyTitle() {
		String actualtitle = lp.getPageTitle();
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE);
		//log.info("title verified successfully");
	}

	@Test(priority = 2)
	public void verifyLogin() {
		System.out.println("testing");
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login successfully");
		log.debug("debugging");
	}

}
