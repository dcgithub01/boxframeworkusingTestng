package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;

public class TrashPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;

	public TrashPage(WebDriver driver) {
		this.driver = driver;
		elementUtil= new ElementUtil(driver);
	}
	
	private By deleteBtn= By.cssSelector("button[data-resin-target='confirmpurge']");
	private By popUpTitle=By.xpath("//div[@class='modal-dialog']//h2/span");
	private By okBtnOnPopUp= By.cssSelector("button[class='btn btn-primary ']");
	private By deleteConfrmationMsg= By.xpath("//span[contains(text(),'The item was deleted.')]");
	private By restoreBtn= By.cssSelector("button[data-resin-target='confirmrestore']");
	private By restoreConfrmationMsg= By.xpath("//span[contains(text(),'The item was restored.')]");
	private By deleteAllBtn= By.cssSelector("button[data-resin-target='deleteall']");
	private By restoreAllBtn= By.cssSelector("button[data-resin-target='restoreall']");
    private By headerText= By.xpath("//h1/span");
    private By popupTitle= By.xpath("//h2/span");
    private By okBtnOnAllPopUp= By.cssSelector("button[data-resin-target='primarybutton']");
    private By cancelBtnOnPopUp= By.cssSelector("button[data-resin-target='cancel']");
    private By trashAllDeletedConfrmMsg= By.xpath("//span[contains(text(),'All the items in the Trash have been deleted.')]");
    private By deleteAllDisableBtn=By.xpath("//div[@class='action-bar-actions prevent-item-deselection']//following-sibling::button[@type='submit']");
	private By closeConfirmationMsgIcon = By.cssSelector("button.close-btn");
	private By selectRow= By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[1]");
	
	public void deleteAllItems()
    {
    	if(elementUtil.isEnabled(deleteAllBtn))
    	{
    		elementUtil.doClick(deleteAllBtn);
    		elementUtil.doWaitforVisibilityOfElement(popupTitle);
    		elementUtil.doClick(okBtnOnAllPopUp);
    		elementUtil.doWaitforVisibilityOfElement(trashAllDeletedConfrmMsg);
    		elementUtil.doClick(closeConfirmationMsgIcon);
    	}
    	else
    	{
    	 System.out.println(" DeleteAll button not enabled ");
    	}
    	
    	
    	
    }
	public void deleteFirstRow()
	{
		elementUtil.doWaitforVisibilityOfElement(selectRow);
		elementUtil.doClick(selectRow);
		elementUtil.doClick(deleteBtn);
		elementUtil.doWaitforVisibilityOfElement(popUpTitle);
		elementUtil.doClick(okBtnOnPopUp);
		elementUtil.doClick(closeConfirmationMsgIcon);
	}
	
	public void restoreFirstRow()
	{
		elementUtil.doWaitforVisibilityOfElement(selectRow);
		elementUtil.doClick(selectRow);
		elementUtil.doClick(restoreBtn);
		elementUtil.doWaitforVisibilityOfElement(popUpTitle);
		elementUtil.doClick(okBtnOnPopUp);
		elementUtil.doClick(closeConfirmationMsgIcon);
	}
}
