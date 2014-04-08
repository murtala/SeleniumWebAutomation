package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header extends BrowserUtil {

	ReportUtil ru = new ReportUtil();
	WebElement primaryNav = BrowserUtil.driver.findElement(By.id("fs-primary-nav"));
	public static WebElement sessionNav = BrowserUtil.driver.findElement(By.id("fs-session-nav"));
	
}
