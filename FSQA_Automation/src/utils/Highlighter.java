package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {

	public void highlightElement(WebElement element) {
		//for (int i = 0; i < 2; i++) {
			WebDriver driver = BrowserUtil.driver;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background-color: yellow; outline : 1px solid rgb(136, 255, 136);");
			//js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		//}
	}
}