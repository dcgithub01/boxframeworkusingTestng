package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public WebDriver driver;
	public WebDriverWait wait;
    public JavaScriptUtil js;
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		js= new JavaScriptUtil(driver);
	}

	public WebElement doGetElement(By locator) {
		js.flash(driver.findElement(locator));
		return driver.findElement(locator);
	}

	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public void doSendKeys(By locator, String text) {
		doGetElement(locator).sendKeys(text);
	}

	public String doGetPageTitle() {
		return driver.getTitle();
	}

	public String doGetLabel(By locator) {
		return doGetElement(locator).getText();
	}
	public boolean isDisplayed(By locator)
	{
		return doGetElement(locator).isDisplayed();
	}
	public boolean isEnabled(By locator)
	{
		return doGetElement(locator).isEnabled();
	}

	// ****************************WebDriverWait Functions
	// ***************************************************

	public WebElement doWaitforPresenceOfElement(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void doWaitForInvisibilityOfElement(By locator)
	{
		wait.until(ExpectedConditions.invisibilityOf(doGetElement(locator)));
	}
public  WebElement doWaitforVisibilityOfElement(By locator)
{
	return wait.until(ExpectedConditions.visibilityOf(doGetElement(locator)));
}

public  Boolean doWaitforInvisibilityOfElement(By locator)
{
	return wait.until(ExpectedConditions.invisibilityOf(doGetElement(locator)));
}
public  Boolean doWaitforAttributeToBe(By locator,String attribute,String attributeValue)
{
	return wait.until(ExpectedConditions.attributeToBe(doGetElement(locator),attribute,attributeValue));
}
	
	
	// ********************************************SelectValueFromDropdown**************************

	public void doGetValueFromDropdownUsingSelect(By locator,String valueToBeSelected) {

		Select sel = new Select(doGetElement(locator));
		sel.selectByVisibleText(valueToBeSelected);
	}
	
	public ArrayList<String> doGetWindowHandles()
	{
		Set<String> handles=driver.getWindowHandles();
		ArrayList<String> listOfhandles = new ArrayList<String>(handles);
		return listOfhandles;
		//String parentIDWindow= listOfhandles.get(0);
		//String childIDWindow = listOfhandles.get(1);
		//driver.switchTo().window(childIDWindow);
	}
	
	//*****************************Window handles *******************************************
	
	
	public void doGetChildWindow(int index )
	{
		ArrayList<String> listOfhandles =doGetWindowHandles();
		
	String value= listOfhandles.get(index);
	driver.switchTo().window(value);
	}
	
	
	public void doGetParentWindow()
	{
		ArrayList<String> listOfhandles =doGetWindowHandles();
		
		String parentID= listOfhandles.get(0);
		driver.switchTo().window(parentID);
		//driver.switchTo().defaultContent();
	}
	
	//************************* Frames *******************************
	
	public void doswitchToFrame(By Locator)
	{
		driver.switchTo().frame(doGetElement(Locator));
	}
	public void doswitchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void doGoBackToDefault()
	{
		driver.switchTo().defaultContent();
	}
	//**************ACTIONS CLASS METHODS****************************
	
	public void doMoveToElementUsingAction(By locator)
	{
		Actions act = new Actions(driver);
		act.moveToElement(doGetElement(locator)).build().perform();
	}
	public void doClickUsingAction(By locator)
	{
		Actions act = new Actions(driver);
		act.click(doGetElement(locator)).build().perform();
	}
	public void doDragAndDropUsingActions(By srcLocator,By destLocator)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(doGetElement(srcLocator),doGetElement(destLocator)).build().perform();
	}
}
