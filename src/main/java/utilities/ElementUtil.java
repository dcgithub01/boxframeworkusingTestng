package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public WebDriver driver;
	public WebDriverWait wait;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement doGetElement(By locator) {
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
	
	// ********************************************SelectValueFromDropdown**************************

	public void doGetValueFromDropdownUsingSelect(By locator,String valueToBeSelected) {

		Select sel = new Select(doGetElement(locator));
		sel.selectByVisibleText(valueToBeSelected);
	}
}
