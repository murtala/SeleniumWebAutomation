package community.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Highlighter;

public class Feed  {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);

	public void post(String someText){
		
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='fs-content-main']"))));		
		//click feed tab
		BrowserUtil.driver.findElement(By.xpath("//*[@data-tab='feed']")).click();
		//clear text area and insert text
		BrowserUtil.driver.findElement(By.name("statusPostText")).clear();	
		BrowserUtil.driver.findElement(By.name("statusPostText")).sendKeys(someText);;
		//click post
		BrowserUtil.driver.findElement(By.xpath("//div/button")).click();
	}
	
	public void comment(String comment) { //not ready
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"))));
		
		System.out.println(BrowserUtil.driver.getTitle());
		
		Actions action = new Actions(BrowserUtil.driver);
		 				
		JavascriptExecutor jsx = (JavascriptExecutor)BrowserUtil.driver;
		jsx.executeScript("window.scrollBy(0,300)", "");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-page-container']//activity-feed/div/activity-feed-item[1]//comment-list/comment-form/form/textarea")).click();;
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-page-container']//activity-feed/div/activity-feed-item[1]//comment-list/comment-form/form/textarea")).sendKeys(comment);;;
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-page-container']//activity-feed/div/activity-feed-item[1]//comment-list/comment-form/form/textarea")).sendKeys(Keys.ENTER);;;
	}
	
	
	public void likeComment() { // make sure a comment exist first before using
		// wait for load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='comment-header media-header']//like//span")));
		// define element
		WebElement element = BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span"));
		// scroll to element
		WebElement scrollPt = BrowserUtil.driver
				.findElement(By.xpath(".//*[@class='activity-item-header media-header activity-status-item-header']"));

		BrowserUtil.scrollToElement(scrollPt);
		// check like/unlike
		String text = element.getText();
		Highlighter h = new Highlighter();
		h.highlightElement(element);

		if (text.toLowerCase().contains("unlike")) {
			BrowserUtil.driver.findElement(By.xpath(".//comment-item//like//span[contains(@class,'like-label' )]")).click();
		} else {

		}

	}

	public void unlikeComment() { // make sure a comment exist first before
		// wait for load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='comment-header media-header']//like//span")));
		// define element
		WebElement element = BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span"));
		// scroll to element
		WebElement scrollPt = BrowserUtil.driver
				.findElement(By.xpath(".//*[@class='activity-item-header media-header activity-status-item-header']"));

		BrowserUtil.scrollToElement(scrollPt);
		// check like/unlike
		String text = element.getText();
		Highlighter h = new Highlighter();
		h.highlightElement(element);

		if (text.toLowerCase().contains("unlike")) {
		} else {
			BrowserUtil.driver.findElement(By.xpath(".//comment-item//like//span[contains(@class,'like-label' )]")).click();
		}

	}

	public void likeUnlikeComment() {
		// wait for load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='comment-header media-header']//like//span")));
		// define element
		WebElement element = BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span"));
		// scroll to element
		BrowserUtil.scrollToElement(element);
		// check like/unlike
		String text = BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")).getText();
		BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")).click();
	}
	
	public void likePost() {
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='activity-item-like']")));
		WebElement element = BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']"));

		BrowserUtil.scrollToElement(element);
		String text =BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).getText();
		//String text =BrowserUtil.driver.findElement(By.xpath("//span[@class='like ng-scope like-inactive']")).getText();
		if ( text.equalsIgnoreCase("Like")){
			BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).click();
		}
		else{
			System.out.println("Post already liked. try unliking it");
		}
	}

	public void unlikePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='activity-item-like']")));
		WebElement element = BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']"));

		BrowserUtil.scrollToElement(element);
		String text =BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).getText();
		//String text =BrowserUtil.driver.findElement(By.xpath("//span[@class='like ng-scope like-active']")).getText();
		if ( text.equalsIgnoreCase("Unlike")){
			BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).click();
		}
		else{
			System.out.println("Post already unliked. try liking it");
		}
	}
	
	public void likeUnlikePost() {
		String text="";
		JavascriptExecutor jsx = (JavascriptExecutor)BrowserUtil.driver;
		jsx.executeScript("window.scrollBy(0,100)", "");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='activity-item-like']//span[contains(@class,'active' )]")));
		BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-item-like']//span[contains(@class,'active' )]")).click();		
	}
	
	public void timeStampPermaLink(){ // click on perma link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='media-activity-header-timestamp permalink ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath("//a[@class='media-activity-header-timestamp permalink ng-binding']")).click();
	}
	
	public void hidePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Hide")).click();;
	}
	
	public void UnsubscribePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")).click();
		//click unsub on the pop over
		BrowserUtil.driver.findElement(By.linkText("Unsubscribe")).click();;
		
	}
	
	public void reportPost() { //cannot report in feed. only in home
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("report")).click();;
	}
	
	public void reportComment() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='activity-item-interact']//div[@class='dropdown popover activity-item-actions ng-scope']")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath("//*[@class='dropdown popover activity-item-actions ng-scope']")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("report()")).click();;
		
	}
	
	
	
	
		
}
