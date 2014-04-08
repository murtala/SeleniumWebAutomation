package utils;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageUtil extends BrowserUtil {
	ReportUtil ru = new ReportUtil();

	public void login(String userName, String password) {
		ru.startLog("login");

		/* enter username */
		BrowserUtil.driver.findElement(By.id("user_email")).sendKeys(userName);
		// enter password
		BrowserUtil.driver.findElement(By.id("user_password")).sendKeys(password);
		// click log in
		BrowserUtil.driver.findElement(By.name("commit")).click();
		
		ru.stopLog();
	}

}
