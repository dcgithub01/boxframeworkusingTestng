package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TrashPage;

public class TrashPageTest extends BaseTest {
	HomePage hp;
	TrashPage tp;

	@BeforeClass
	public void trashSetup()
	{
		hp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		tp=hp.goToTrashTab();
	}
	
	
	@Test(enabled=false)
	public void VerifydeleteAllTest()
	{
		tp.deleteAllItems();
	}
	
	@Test
	public void deleteFirstRecord()
	{
		tp.deleteFirstRow();
	}
	
	@Test
	public void restoreFirstRecord()
	{
		
		tp.restoreFirstRow();
	}
	
}
