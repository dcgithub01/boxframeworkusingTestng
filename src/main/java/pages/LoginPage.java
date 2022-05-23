package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private By headerTitle= By.xpath("//h1");
	private By emailID=  By.id("login-email");
	private By  nextBtn= By.id("login-submit");
	private By pwd = By.id("password-login");
	private By  logInBtn= By.id("login-submit-password");
	
	
	public String getPageTitle()
	{
		return elementUtil.doGetPageTitle();
	}
	
	public String getHeaderTitle(By locator)
	{
		return elementUtil.doGetLabel(headerTitle);
	}
	
	public HomePage doLogin(String username,String password )
	{
		elementUtil.doWaitforPresenceOfElement(emailID);
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doClick(nextBtn);
		elementUtil.doWaitforPresenceOfElement(pwd);
		elementUtil.doSendKeys(pwd, password);
		elementUtil.doClick(logInBtn);
		return new HomePage(driver);
	}
	
	

}
