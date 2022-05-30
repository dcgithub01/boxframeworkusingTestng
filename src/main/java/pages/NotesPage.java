package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class NotesPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	public NotesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By shareBtn = By.xpath("(//button[@class='btn btn-primary ' and @id='box-share-button'])[2]");
	private By notesPopUpHeading = By.xpath("//h2[@id='modal2-label']");
	private By blankNoteSelection = By.cssSelector("div[title='Blank Note']");
	private By createBtnOnPopUp = By.cssSelector("button[class*='modal-create-button']");
	private By defaultNoteName = By.cssSelector("span[title*='Untitled Note']");
	private By addATitle = By.id("titleEditor");
	private By typeInArea = By.xpath("//div[contains(@id,'magicdomid')]");
	private By frameName = By.name("service_iframe");
	private By notesFrameMain = By.name("service_iframe");
	private By innerFrame = By.name("ace_inner");

	public boolean doCheckShareBtnDisplayed() {
		elementUtil.doswitchToFrame(notesFrameMain);
		elementUtil.doWaitforVisibilityOfElement(shareBtn);
		elementUtil.doWaitforAttributeToBe(shareBtn, "title", "Share");
		return elementUtil.isDisplayed(shareBtn);
	}

	public String doCheckHeadingOfNote() {
		return elementUtil.doGetLabel(defaultNoteName);
	}

	public void doEnterNote(String enterNoteDetails) {
		elementUtil.doswitchToFrame(innerFrame);
		elementUtil.doSendKeys(typeInArea, enterNoteDetails);
	}

	public void doCreateBlankNote() throws InterruptedException {
		elementUtil.doswitchToFrame(frameName);
		elementUtil.doWaitforPresenceOfElement(notesPopUpHeading);
		elementUtil.doWaitforAttributeToBe(notesPopUpHeading, "id", "modal2-label");
		elementUtil.doMoveToElementUsingAction(blankNoteSelection);
		elementUtil.doClick(blankNoteSelection);
		elementUtil.doClick(createBtnOnPopUp);
		elementUtil.doGoBackToDefault();

	}

	public void doSwitchToParent() {
		elementUtil.doGetParentWindow();
	}
}
