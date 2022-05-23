package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest extends BaseTest {

	public HomePage hp;
	
	@BeforeClass
	public void homePageSetup()
	{
		hp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		hp.getPageTitle();
		
	}
	
	@Test(priority=2)
	public void CreateFolderTest()
	{
		hp.createNewFolder("foldernamedc", "apex@gmail.com", "Editor");
	}
	
	@Test(priority=3)
	public void deleteFolder() throws InterruptedException
	{
		hp.deleteFolder();
	}
}
