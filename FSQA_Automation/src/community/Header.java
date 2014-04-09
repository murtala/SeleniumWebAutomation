package community;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class Header extends BrowserUtil {
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
	
	public void homeLink(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fs-top-bar")));
		driver.findElement(By.id("fs-home-link")).click();
	}

}
