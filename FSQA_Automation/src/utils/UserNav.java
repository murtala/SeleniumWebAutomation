package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserNav extends Header {
	
	Actions action = new Actions(BrowserUtil.driver);
	WebElement sessionDropDown = Header.sessionNav;
	ReportUtil ru = new ReportUtil();
	public void messages(){
		ru.startLog("messages");	
		
		BrowserUtil.driver.navigate().to("https://dashboard.fullscreen.net/conversations"); //go to link
		/* end logs */
		ru.stopLog();
	}
	public void notifications(){
		ru.startLog("notifications");	
		
		BrowserUtil.driver.navigate().to("https://accounts.fullscreen.net/notifications"); //go to link
		/* end logs */
		ru.stopLog();
	}
	public void settings(){
		ru.startLog("settings");
		
		WebElement dropdown = BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-session-nav']/li[3]/a"));
		action.moveToElement(dropdown);
		action.build().perform();
		WebElement settings = driver.findElement(By.xpath(".//*[@id='fs-session-nav-dropdown-settings']/a"));
		action.moveToElement(settings).click();
		action.build().perform();	

		/* end logs */
		ru.stopLog();
	}
	
	public void logOut(){
		ru.startLog("logOut");	
		
		WebElement dropdown = BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-session-nav']/li[3]/a"));
		action.moveToElement(dropdown);
		action.build().perform();
		WebElement settings = driver.findElement(By.xpath(".//*[@id='fs-session-nav-dropdown-logout']/a"));
		action.moveToElement(settings).click();
		action.build().perform();

		/* end logs */
		ru.stopLog();
	}
	
	
}
