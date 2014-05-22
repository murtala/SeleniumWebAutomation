package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageScroller {

	public void scrollTo(String element){
			JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
			jsx.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollTo(WebElement element){
		JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
		jsx.executeScript("arguments[0].scrollIntoView(true);", element);
}
}
