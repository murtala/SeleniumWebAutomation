package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomFinder {

	public static void locateXpath(String xpath, boolean highlight, boolean log) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));	
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
		BrowserUtil.driver.findElement(By.xpath(xpath)).click();
		
		if (highlight == true){  //higlight the element
			Highlighter.highlightElement(BrowserUtil.driver.findElement(By.xpath(xpath)));	
		}
		
		if (log == true){  //enable the logger
			
		}
	}
}
