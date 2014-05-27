package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

public class PageScroller {

	JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
	public void scrollTo(String element){
			JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
			jsx.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollTo(WebElement element) {
		int initialLocation = element.getLocation().getY();
		System.out.println("ini loc: " + initialLocation);
		jsx.executeScript("window.scrollTo(0," + (60- initialLocation) + "0);");
		// Point initialLocation = ((Locatable)
		// element).getCoordinates().inViewPort();
	}

	public void DownbScrollTo(WebElement element) {
		int initialLocation = element.getLocation().getY();
		System.out.println("ini loc: " + initialLocation);
		jsx.executeScript("window.scrollTo(0," + ( initialLocation -100) + "0);");

	}
}


/*
System.out.println(BrowserUtil.driver.findElement(By.xpath(".//*[@id='search-submit']")).getLocation());
System.out.println(BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a")).getLocation());
int we = BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a")).getLocation().getY();
WebElement element = BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a"));
//Point initialLocation = ((Locatable) element).getCoordinates().inViewPort();
//System.out.println("x : "+initialLocation.getX());

JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
jsx.executeScript(" window.scrollTo(0,"+(we -50)+"0);");*/