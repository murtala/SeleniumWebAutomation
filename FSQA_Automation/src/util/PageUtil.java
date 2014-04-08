package util;

import java.util.List;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {

	public static WebDriver driver;

//public static 	WebDriverWait wait = new WebDriverWait(driver, 30);

	
	
	static String Browser;

	public void HeaderMenu(){
		WebElement header = driver.findElement(By.xpath(".//*[@class='fs-container']"));
		WebElement headerPrimaryNav = header.findElement(By.id("fs-primary-nav"));
		
		List<WebElement> headerPrimaryNavItems = headerPrimaryNav.findElements(By.tagName("li"));
		for (WebElement webElement : headerPrimaryNavItems) {
			System.out.println(webElement.getText());
		}
		WebElement headerSessionNav = header.findElement(By.id("fs-session-nav"));

	}
	
	public void login(String emailId, String password){
		String email=emailId;
		String pw = password;
		
		if (driver.getTitle().equalsIgnoreCase("Fullscreen")){
			
			email = email.substring(0, email.lastIndexOf('@') );
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Passwd")).sendKeys(pw);
			driver.findElement(By.id("signIn")).click();;
			
			
		}else {
	//	System.out.println(" vals " + driver.findElement(By.id("Email")).getAttribute("id"));
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(pw);
		driver.findElement(By.xpath(".//*[@id='new_user']/input")).click();}
	}
	
	public void ExplicitWait(String WebElement, String TimeInSecs){
	//	Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));

	}
	
	public boolean verifyPageTitle(String exp) {
		String acttitle = driver.getTitle();
		if (acttitle.equals(exp))
			return true;
		else
			return false;
	}

	public void openMenu(String link) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText(link));
		action.moveToElement(element).build().perform();
	}

	public static void setBrowser(String browser) {
		Browser = browser;

		if (Browser.equalsIgnoreCase("firefox") || Browser.equalsIgnoreCase("ff")) {

			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("ie") || Browser.equalsIgnoreCase("InternetExplorer") || Browser.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Libraries\\IEDriverServer_Win32_2.33.0\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver();

		} else if (Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/madamou/Documents/Libraries/chromedriver");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else

		{

			System.out.println("ERROR - Unknown browser type");

		}

	}

	/*
	 * public static void OpenLink(String url) {
	 * 
	 * theDriver.get(url); }
	 * 
	 * public static WebDriver setUpIEdriver() {
	 * System.setProperty("webdriver.ie.driver",
	 * "F:\\JAVA\\Libraries\\IEDriverServer_Win32_2.33.0\\IEDriverServer.exe");
	 * DesiredCapabilities capabilities =
	 * DesiredCapabilities.internetExplorer(); return IEdriver = new
	 * InternetExplorerDriver(); }
	 * 
	 * public static WebDriver setUpFireFoxDriver() { return firefoxdriver = new
	 * FirefoxDriver(); }
	 * 
	 * public static WebDriver setUpChromeDriver() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "/Users/madamou/Documents/Libraries/chromedriver"); return
	 * chromedriver = new ChromeDriver(); }
	 * 
	 * public static void OpenLinkInFirefoxBrowser(String url) { //
	 * firefoxdriver= new FirefoxDriver(); firefoxdriver.get(url);
	 * 
	 * }
	 * 
	 * public static void OpenLinkInChromeBrowser(String url) {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "F:/JAVA/Libraries/chromedriver_win32_2.0/chromedriver.exe");
	 * 
	 * chromedriver.get(url); }
	 * 
	 * public static void OpenLinkISafariBrowser() { }
	 */

}
