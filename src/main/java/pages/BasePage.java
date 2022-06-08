package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	@SuppressWarnings("deprecation")
	public WebDriver init_driver(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver= new ChromeDriver();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				try {
					
					ChromeOptions co = new ChromeOptions();
					co.setCapability("browserName", "chrome");

					tl.set(new RemoteWebDriver(new URL(prop.getProperty("remoteURL")), co));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				tl.set(new ChromeDriver());
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver= new FirefoxDriver();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				try {

					FirefoxOptions fo = new FirefoxOptions();
					fo.setCapability("browserName", "firefox");
					tl.set(new RemoteWebDriver(new URL(prop.getProperty("remoteURL")), fo));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				tl.set(new FirefoxDriver());
			}
		}
			getdriver().manage().window().maximize();
			getdriver().manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
			getdriver().manage().deleteAllCookies();
			getdriver().get("https://app.box.com/login");
			return getdriver();
		
	}

	public synchronized WebDriver getdriver() {
		return tl.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.FILE);
		String dest_path = System.getProperty("user.dir") + "Screenshots" + System.currentTimeMillis() + ".png";
		File destination = new File(dest_path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest_path;
	}
}
