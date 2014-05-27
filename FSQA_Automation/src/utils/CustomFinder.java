package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomFinder {

	PageScroller scroller = new PageScroller();

	private  void locateXpath(String xpath, boolean highlight, boolean log) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
		BrowserUtil.driver.findElement(By.xpath(xpath)).click();

		if (highlight == true) { // higlight the element
			Highlighter.highlightElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
		}

		if (log == true) { // enable the logger

		}
	}

	public  void byXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		scroller.scrollTo(BrowserUtil.driver.findElement(By.xpath(xpath)));
		BrowserUtil.driver.findElement(By.xpath(xpath)).click();
		Highlighter.highlightElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
	}
	public  void byXpathNS(String xpath) { // without the scrolls
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		BrowserUtil.driver.findElement(By.xpath(xpath)).click();
		Highlighter.highlightElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
	}
	
	public  void byXpathNSNC(String xpath) { // without the scrolls
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		Highlighter.highlightElement(BrowserUtil.driver.findElement(By.xpath(xpath)));
	}
	public  void byIdNS(String Id) { // without the scrolls
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(Id)));
		//scroller.scrollTo(BrowserUtil.driver.findElement(By.xpath(xpath)));
		BrowserUtil.driver.findElement(By.id(Id)).click();
		Highlighter.highlightElement(BrowserUtil.driver.findElement(By.id(Id)));
	}

	private  void locateLinkText(String linkText, boolean highlight, boolean log) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.linkText(linkText)));
		BrowserUtil.driver.findElement(By.linkText(linkText)).click();

		if (highlight == true) { // higlight the element
			Highlighter.highlightElement(BrowserUtil.driver.findElement(By.linkText(linkText)));
		}

		if (log == true) { // enable the logger

		}

	}

	public void byElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		scroller.scrollTo(webElement);
		Highlighter.highlightElement(webElement);
		webElement.click();
	}
	public void byElementNS(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		Highlighter.highlightElement(webElement);
		webElement.click();
	}
	public void byElementNSNC(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		Highlighter.highlightElement(webElement);
	}
	public void byElementNC(WebElement webElement) { // noclicks
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		Highlighter.highlightElement(webElement);
	}

	
}
