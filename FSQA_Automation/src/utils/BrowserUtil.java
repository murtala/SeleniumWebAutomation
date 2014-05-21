package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BrowserUtil extends Util {
	// public WebDriver driver;

	public static WebDriver driver = drivers;
	public static Reporter reports;
	public static void setBrowser(String browser) {
		ReportUtil ru = new ReportUtil();
		ru.startLog("setBrowser");

		/* driver paths for IE and Chrome browser */
		String iePath = "/FSQA/Libraries/IEDriverServer_Win32_2.33.0/IEDriverServer.exe";
		String chromePath = "G:/Dev/JAVA/Libraries/chromedriver_win32/chromedriver.exe";

		/*detect platform and change the correct the paths */
		Platform current = Platform.getCurrent();
		if (Platform.MAC.is(current)) {
			iePath = "/FSQA/Libraries/chromedriver"; // opens chrome mac driver since no IE support yet				
			chromePath = "/FSQA/Libraries/chromedriver";
		}

		/* select and set the driver  */
		if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
			Point targetPosition = new Point(10, 0);
			driver.manage().window().setPosition(targetPosition);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("InternetExplorer") || browser.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", iePath);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("CH")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			Point targetPosition = new Point(10, 0);
			driver.manage().window().setPosition(targetPosition);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("safari") || browser.equalsIgnoreCase("sa")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		} else

		{
			System.out.println("ERROR - Unknown browser type");
		}

		ru.stopLog();
	}
	
	// scroll to a specified web element
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
		jsx.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void scrollToElement(String element) {
		JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
		jsx.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	/* go to a specified URL */
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

}