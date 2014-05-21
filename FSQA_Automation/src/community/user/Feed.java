package community.user;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Highlighter;

public class Feed  {
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
	public Feed(){
		System.out.println("Opening Feed Tab");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")));
		//h.highlightElement(driver.findElement(By.cssSelector(".avatar.sm.circle")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Feed']")));
		BrowserUtil.driver.findElement(By.xpath("//a[text()='Feed']")).click();
	}
	

	//select from the drop down. arguments are : All, "Status Posts", "Video Uploads, "Forums", "Milestones"
	public void activityFilter(String by){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-menu bottom']")));
		Actions action = new Actions(BrowserUtil.driver);
		action.click(BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div/a/span")));
		action.build().perform();
		action.moveToElement(BrowserUtil.driver.findElement(By.xpath("//a[text()='"+by+"']")));
		action.click();
		action.build().perform();
		
	}
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
	
	//post a comment on a random post
	public void comment(String comment) { //not ready
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"))));
		WebElement allPosts = BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"));
		List<WebElement> commentFields = allPosts.findElements(By.name("commentForm"));
				
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
				
		Random r = new Random();
		int ran;
		WebElement listItem;
		if(commentFields.size() == 1){
			 ran = 1;
			  listItem = commentFields.get((0));
		}else{
		 ran = r.nextInt(commentFields.size());
		  listItem = commentFields.get(r.nextInt(ran));
			
		}
		
		
		WebElement listedItem = listItem.findElement(By.tagName("textarea"));
		BrowserUtil.scrollToElement(listedItem);
		listedItem.click();
		listedItem.sendKeys(comment);
		listedItem.sendKeys(Keys.ENTER);

		
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
		BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-item-like']")).click();		
	}
	
	public void timeStampPermaLink(){ // click on perma link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='media-timestamp permalink ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath("//a[@class='media-timestamp permalink ng-binding']")).click();
	}
	
	public void hidePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Remove")).click();;
	}
	
	public void UnsubscribePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		//click unsub on the pop over
		BrowserUtil.driver.findElement(By.linkText("Unsubscribe")).click();;
		
	}
	
	public void reportPost() { //cannot report in feed. only in home
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Report")).click();;
	}
	
	public void reportComment() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='activity-item-interact']//div[@class='dropdown popover activity-item-actions ng-scope']")));
		//click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		//click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Report")).click();;
		
	}
	
	
	
	
		
}
