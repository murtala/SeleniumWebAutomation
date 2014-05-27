package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

public class SamplePage {

	
	public void test1 ()  {
		BrowserUtil bu = new BrowserUtil();
		PageUtil pu = new PageUtil();
		bu.setBrowser("chrome");
		bu.navigateTo("https://www.yahoo.com/");
		
		System.out.println(BrowserUtil.driver.findElement(By.xpath(".//*[@id='search-submit']")).getLocation());
		System.out.println(BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a")).getLocation());
		int we = BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a")).getLocation().getY();
		WebElement element = BrowserUtil.driver.findElement(By.xpath(".//*[@id='default-p_24803755-bd']/ul/li[1]/a"));
		//Point initialLocation = ((Locatable) element).getCoordinates().inViewPort();
		//System.out.println("x : "+initialLocation.getX());
		
		JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
		jsx.executeScript(" window.scrollTo(0,"+(we -50)+"0);");
       
        
		//pu.login("fsqaautomation2@gmail.com", "fstester");
		//PrimaryNav  pn = new PrimaryNav();
		//pn.apps();
		//UserNav un = new UserNav();
		//un.settings();
		//un.logOut();
		//bu.driver.quit();
		
	}
}
