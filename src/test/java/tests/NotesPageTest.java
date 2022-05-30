package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.NotesPage;

public class NotesPageTest extends BaseTest {
	public NotesPage np;
	public HomePage hp;

	@BeforeClass()
	public void NotesPageSetup() {
		hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		np = hp.goToNotesTab(1);
	}

	@Test(priority = 1)
	public void createBlankNoteTest() throws InterruptedException {
		np.doCreateBlankNote();
	}

	@Test(priority = 3)
	public void getNoteHeadingTest() {
		String actualHeading = np.doCheckHeadingOfNote();
		// Assert.assertEquals(actualHeading, null);
	}

	@Test(priority = 2)
	public void VerifyShareButtonDisplayed() {
		Assert.assertTrue(np.doCheckShareBtnDisplayed());
	}

	@Test(priority = 4)
	public void verifyEnterDetailsInNote() {
		np.doEnterNote("testing");
	}

	@Test(priority = 5)
	public void verifyDeleteNoteTest() {
		np.doSwitchToParent();
		try {
			hp.deleteFolder();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
