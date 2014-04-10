package community;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class SessionControls {
	BrowserUtil bu = new BrowserUtil();
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	Header h = new Header();
	public void messages(){
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a/span")));
		BrowserUtil.driver.findElement(By.xpath("//li/a/span")).click();
	}
	
	public void notifications(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@collection='notifications']//span")));
		BrowserUtil.driver.findElement(By.xpath("//div[@collection='notifications']//span")).click();
	}
	
	public void accountControls(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@type='account']//a[@class='dropdown-toggle']//span")));
		BrowserUtil.driver.findElement(By.xpath("//div[@type='account']//a[@class='dropdown-toggle']//span")).click();
	}

}
