package community.user;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.Highlighter;
import utils.PageScroller;
import utils.Randomizer;

public class Feed  {
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	CustomFinder find = new CustomFinder();
	Randomizer ran = new Randomizer();
	Highlighter hilite = new Highlighter();
	PageScroller scroller = new PageScroller();
	static WebDriver driver = BrowserUtil.driver;
	JavascriptExecutor jsx = (JavascriptExecutor) BrowserUtil.driver;
	public Feed(){
		String url="https://staging-community.fullscreen.net";
		String slug = driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a/span")).getAttribute("href");
		driver.get(url+slug);
		find.byXpathNSNC(".//*[@id='fs-application-wrapper']/nav/div/a");
		find.byXpath("//a[text()='Feed']");
	}
	

	//select from the drop down. arguments are : All, "Status Posts", "Video Uploads, "Forums", "Milestones"
	public void activityFilter(String by){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-menu bottom']")));
		Actions action = new Actions(BrowserUtil.driver);
		hilite.highlightElement(BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div/a/span")));
		action.click(BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div/a/span")));
		action.build().perform();
		hilite.highlightElement(BrowserUtil.driver.findElement(By.xpath("//a[text()='"+by+"']")));
		action.moveToElement(BrowserUtil.driver.findElement(By.xpath("//a[text()='"+by+"']")));
		action.click();
		action.build().perform();
		
	}
	public void post(String someText){
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='fs-content-main']"))));		
		//click feed tab
		//scroll.scrollTo(BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")));
		WebDriver driver = BrowserUtil.driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		
		find.byXpathNS("//*[@data-tab='feed']");
		//clear text area and insert text
		find.byElementNS(BrowserUtil.driver.findElement(By.name("statusPostText")));
		BrowserUtil.driver.findElement(By.name("statusPostText")).clear();	
		BrowserUtil.driver.findElement(By.name("statusPostText")).sendKeys(someText);;
		//click post
		//find.byXpathNS("//div/button");
	}
	
	//post a comment on a random post
	public void comment(String comment) { // not ready
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath(".//div[@class='activity-feed']//comment-form//textarea"))));
		List<WebElement> commentFields = BrowserUtil.driver.findElements(By.xpath(".//div[@class='activity-feed']//comment-form//textarea"));

		WebElement item = ran.getRandomClick(commentFields);

		Highlighter.highlightElement(item);
		//scroller.scrollTo(element);
		scroller.DownbScrollTo(item);

		item.sendKeys(comment);
		// item.sendKeys(Keys.ENTER);

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
		WebElement element = BrowserUtil.driver.findElement(By.xpath(".//div[@class='activity-item-content']"));
		// scroll to element
		scroller.scrollTo(element);
		// check like/unlike
		find.byElementNS(BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")));
		//BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")).click();
	}
	
	public void likePost() {
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='activity-item-like']")));
		WebElement element = BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']"));

		System.out.println("coord: " + element.getLocation().getY());
		element.getLocation().move(0, element.getLocation().getY() + 300);
		
	//	scroll.scrollTo(element);
		String text =BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).getText();
		//String text =BrowserUtil.driver.findElement(By.xpath("//span[@class='like ng-scope like-inactive']")).getText();
		if ( text.equalsIgnoreCase("Like")){
			//BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-like']")).click();
			
			find.byXpathNS(".//*[@class='activity-item-like']");
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
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='activity-item-like']")));
		WebElement element = BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-item-like']"));
		find.byElement(element);
		
	}
	
	public void timeStampPermaLink(){ // click on perma link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='media-timestamp permalink ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath("//a[@class='media-timestamp permalink ng-binding']")).click();
	}
	
	public void hidePost() {
		//click on the icon
		find.byXpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a");
		//BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		//click hide on the pop over
		find.byElementNS(BrowserUtil.driver.findElement(By.linkText("Remove")));
		//BrowserUtil.driver.findElement(By.linkText("Remove")).click();;
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
