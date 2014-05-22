package utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityFeed {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	PageScroller ps = new PageScroller();

	public void postStatus(String someText) {
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='fs-content-main']"))));
		// clear text area and insert text
		BrowserUtil.driver.findElement(By.name("statusPostText")).clear();
		BrowserUtil.driver.findElement(By.name("statusPostText")).sendKeys(someText);
		;
		// click post
		BrowserUtil.driver.findElement(By.xpath("//div/button")).click();
	}

	// select from the drop down. arguments are : All, "Status Posts",
	// "Video Uploads, "Forums", "Milestones"
	public void activityFilter(String by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-menu bottom']")));
		Actions action = new Actions(BrowserUtil.driver);
		action.click(BrowserUtil.driver.findElement(By.xpath(".//*[@class='dropdown-toggle ss-navigatedown right']")));
		action.build().perform();
		action.moveToElement(BrowserUtil.driver.findElement(By.xpath("//a[text()='" + by + "']")));
		action.click();
		action.build().perform();
	}

	// post a comment on a random post
	public void comment(String comment) { // not ready
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"))));
		WebElement allPosts = BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"));
		List<WebElement> commentFields = allPosts.findElements(By.tagName("textarea"));

		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
		System.out.println(" size: " + commentFields.size());
		Random r = new Random();
		int ran;
		WebElement listItem;
		if (commentFields.size() == 1) {
			ran = 1;
			listItem = commentFields.get((0));
		} else {
			ran = r.nextInt(commentFields.size());
			listItem = commentFields.get(r.nextInt(ran));

		}

		WebElement listedItem = listItem.findElement(By.tagName("textarea"));
		BrowserUtil.scrollToElement(listedItem);
		listedItem.click();
		listedItem.sendKeys(comment);
		listedItem.sendKeys(Keys.ENTER);

	}

	//click a a time link
	public void timeStampPermaLink(){ // click on perma link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='media-timestamp permalink ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath("//a[@class='media-timestamp permalink ng-binding']")).click();
	}
	
	public void likeUnlikeComment() {
		// wait for load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='comment-header media-header']//like//span")));
		// define element
		WebElement element = BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-item-interact']//like//span"));
		// scroll to element
		BrowserUtil.scrollToElement(element);
		// check like/unlike
		String text = BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")).getText();
		BrowserUtil.driver.findElement(By.xpath("//div[@class='comment-header media-header']//like//span")).click();
	}

	// like or unlike a post
	public void likeUnlikePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='activity-item-like']")));
		ps.scrollTo(BrowserUtil.driver.findElement(By.xpath(".//*[@class='activity-item-content-container']")));
		BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-item-like']")).click();
	}

	public void hidePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		// click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		// click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Remove")).click();
		;
	}

	public void UnsubscribePost() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		// click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		// click unsub on the pop over
		BrowserUtil.driver.findElement(By.linkText("Unsubscribe")).click();
		;

	}

	public void reportPost() { // cannot report in feed. only in home
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")));
		// click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		// click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Report")).click();
		;
	}

	public void reportComment() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='activity-item-interact']//div[@class='dropdown popover activity-item-actions ng-scope']")));
		// click on the icon
		BrowserUtil.driver.findElement(By.xpath(".//div[@class='dropdown popover activity-item-actions ng-scope']/a")).click();
		// click hide on the pop over
		BrowserUtil.driver.findElement(By.linkText("Report")).click();
		;

	}

}
