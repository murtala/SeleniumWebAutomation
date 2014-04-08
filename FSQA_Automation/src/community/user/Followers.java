package community.user;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class Followers {
	
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);

	public Followers(){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Followers']")));
			BrowserUtil.driver.findElement(By.xpath("//a[text()='Followers']")).click();
	}
	
	public void message(){
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath(".//*[@class='profile-nav secondary-nav']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fs-button mini fs-light fs-button-message ng-isolate-scope ng-scope ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@class='fs-button mini fs-light fs-button-message ng-isolate-scope ng-scope ng-binding']")).click();	
	}
	
	public void follow(){ // can't. ppl not being followed will not appear in that list
		
	}
	
	public void unFollow(){
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath(".//*[@class='user-list ng-isolate-scope ng-scope']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//follow-button")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@class='fs-button mini fs-button-follow ng-scope fs-secondary following']")).click();
		//System.out.println(BrowserUtil.driver.findElement(By.xpath(".//*[@class='fs-button mini fs-button-follow ng-scope fs-secondary following']")).getText());

	}
	
}
