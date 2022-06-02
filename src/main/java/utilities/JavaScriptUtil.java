package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	private WebDriver driver;
	JavascriptExecutor js;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) (driver);
	}

	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {

		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void doScrollDownByLength(int length) {
		js.executeScript("window.scrollBy(" + length + ")");
	}

	public void doScrollDownTo() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void doScrollUpTo() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollIntoView(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void drawBorder(WebElement element) {

		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public String getPageInnerText() {

		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void clickElementByJS(WebElement element) {

		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingWithId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
}
