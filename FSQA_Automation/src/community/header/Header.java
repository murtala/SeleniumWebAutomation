package community.header;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Highlighter;

public class Header extends BrowserUtil {
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
	Highlighter h =  new Highlighter();
	public void homeLink(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fs-top-bar")));
		h.highlightElement(driver.findElement(By.id("fs-home-link")));
		driver.findElement(By.id("fs-home-link")).click();
	}

}
