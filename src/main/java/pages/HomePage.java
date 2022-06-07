package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class HomePage extends BasePage{
	String foldername=null;
	WebDriver driver;
	ElementUtil elementUtil;

	public HomePage(WebDriver driver) {
     
		this.driver = driver;
		elementUtil= new ElementUtil(driver);
	}
    
	private By PageHeader= By.xpath("(//h1[@class='ItemListBreadcrumb-currentItemTitle page-title'])[1]");
	private By newBtn = By.cssSelector("button[class=\"btn create-dropdown-menu-toggle-button\"]");
	private By newFolder = By.cssSelector("li[aria-label='Create a new Folder']");
	private By newFolderTitle = By.xpath("//h2/span[text()='Create a New Folder']");
	private By folderName= By.name("folder-name");
	private By inviteEmail = By.xpath("//textarea[@aria-autocomplete='list']");
	private By permissionDropdown = By.cssSelector("select[name=invite-permission]");
	private By submitBtnOnPopUP=By.cssSelector("button[data-resin-target='primarybutton']");
	private By cancelBtnOnPopUP=By.cssSelector("button[data-resin-target='cancel']");
	private By confirmationMsg= By.xpath("//span[contains(text(),'created successfully')]");
	private By closeConfirmationMsgIcon = By.cssSelector("button.close-btn");
	private By folderNameVerify= By.xpath("//div/a[text()='"+foldername+"']");
	private By selectRow= By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[1]");
	private By clickTrash = By.cssSelector("button[aria-label='Trash']");
	private By deleteItemPopUpHeading = By.xpath("//h2/span[text()='Delete Item']");
	private By clickOKOnPopUp = By.cssSelector("button[data-resin-target='primarybutton']");
	private By deleteConfirmationMsg= By.xpath("//span[contains(text(),'Item successfully moved to trash.')]");  
	private By notesLink= By.cssSelector("a[data-resin-target='boxnotes']");

	
	public String getPageTitle()
	{
		return elementUtil.doGetPageTitle();
	}


public String getHeaderTitle(By locator)
{
	return elementUtil.doGetLabel(PageHeader);
}

public void createNewFolder(String nameOfFolder,String emailInvite,String PermissionValue)
{
elementUtil.doWaitforPresenceOfElement(newBtn);
elementUtil.doClick(newBtn);
elementUtil.doClick(newFolder);
elementUtil.doGetLabel(newFolderTitle);
elementUtil.doSendKeys(folderName,nameOfFolder);
elementUtil.doSendKeys(inviteEmail, emailInvite);
elementUtil.doGetValueFromDropdownUsingSelect(permissionDropdown, PermissionValue);
elementUtil.doClick(submitBtnOnPopUP);
//elementUtil.doWaitforPresenceOfElement(confirmationMsg);
elementUtil.doClick(closeConfirmationMsgIcon);

}

public synchronized void deleteFolder() throws InterruptedException
{  // this.foldername=foldername;
	//elementUtil.doWaitForInvisibilityOfElement(confirmationMsg);
	//elementUtil.doWaitforVisibilityOfElement(folderNameVerify);
	Thread.sleep(5000);
	elementUtil.doClick(selectRow);
	elementUtil.doClick(clickTrash);
	elementUtil.doGetLabel(deleteItemPopUpHeading);
	elementUtil.doWaitforPresenceOfElement(clickOKOnPopUp).click();
	elementUtil.doGetLabel(deleteConfirmationMsg);
	elementUtil.doClick(closeConfirmationMsgIcon);
	
}
public NotesPage goToNotesTab(int index )
{
	elementUtil.doClick(notesLink);
	elementUtil.doGetChildWindow(index);
	return new NotesPage(driver);
	
	
}

}