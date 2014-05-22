package community.home;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ActivityFeed;
import utils.BrowserUtil;
import utils.PageScroller;
import utils.Randomizer;

public class Home {
	static WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	String path = "";

	String path2 = "";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	ActivityFeed af = new ActivityFeed();
	
	public String menuXpathLoc(String path) {
		return path = ".//*[@class='fs-menu-list clearfix']/li//a/span[.='" + path + "']";
	}

	public Home() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-home']")));
		driver = BrowserUtil.driver;
		driver.findElement(By.xpath(".//*[@id='menu-home']")).click();
	}

	public void timeLink(){
		af.timeStampPermaLink();
	}
	public void repostComm() {
		af.reportComment();
	}

	public void reportPost() {
		af.reportPost();
	}

	public void unsubPost() {
		af.UnsubscribePost();
	}

	public void hidePost() {
		af.hidePost();
	}

	public void rateComment() {
		af.likeUnlikeComment();
	}

	public void ratePost() {
		af.likeUnlikePost();
	}
	
	
	// clikc on a random similar creator in the right side bar
	public void rsSimCreator() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='media-list tall-list']")));
		PageScroller ps = new PageScroller();
		ps.scrollTo((driver.findElement(By.xpath(".//*[@class='fs-content-supporting-module ng-scope']"))));
		WebElement allSc = BrowserUtil.driver.findElement(By.xpath(".//*[@class='media-list tall-list']"));
		List<WebElement> vids = allSc.findElements(By.xpath(".//*[@class='media-heading']//a"));
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		driver.navigate().back();
	}

	// folow/unollow similar creator
	public void rsFUCreator() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='media-list tall-list']")));
		PageScroller ps = new PageScroller();
		ps.scrollTo((driver.findElement(By.xpath(".//*[@class='fs-content-supporting-module ng-scope']"))));
		WebElement allSc = BrowserUtil.driver.findElement(By.xpath(".//*[@class='media-list tall-list']"));
		List<WebElement> vids = allSc.findElements(By.xpath(".//follow-button/a"));
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		driver.navigate().back();
	}
	//click on a link from blog in the right sidebar
	public void rsBlogLink(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[4]")));
		PageScroller ps = new PageScroller();
		ps.scrollTo((driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[4]"))));
		WebElement allSc = BrowserUtil.driver.findElement(By.xpath(".//*[@class='summary-list']"));
		List<WebElement> vids = allSc.findElements(By.xpath("/div/a"));
		
		System.out.println(vids.size() + vids.get(1).getText());
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		driver.navigate().back();
	}
	//clik on a blog tag
	public void rsBlogLinkTag(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[4]")));
		PageScroller ps = new PageScroller();
		ps.scrollTo((driver.findElement(By.xpath(".//*[@class='fs-content-supporting-module blog-module ng-scope']"))));
		WebElement allSc = BrowserUtil.driver.findElement(By.xpath(".//*[@class='summary-list']"));
		List<WebElement> vids = allSc.findElements(By.xpath(".//*[@class='blog-module-categories']/a"));
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		driver.navigate().back();
	}
	//post a comment on a random post
	public void postComment(String comment){
		wait.until(ExpectedConditions.visibilityOf(BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"))));
		WebElement allPosts = BrowserUtil.driver.findElement(By.xpath("//div[@class='activity-feed']"));
		//List<WebElement> commentFields = allPosts.findElements(By.xpath(".//div[@class='form-group comment-form-field-wrapper']"));
		List<WebElement> commentFields = BrowserUtil.driver.findElements(By.xpath("//div[@class='activity-item-interact']"));
		System.out.println( " size: "+commentFields.size());
		
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
	// change the filters
	public void changeFilterTo(String filter){
		ActivityFeed af = new ActivityFeed();
		af.activityFilter(filter);
	}
	//click Everyone tab
	public void everyoneTab(){
		driver.findElement(By.xpath(".//*/activity-filter/ul/li[2]/a")).click();
	}
	//click Feed Tab
	public void myFeedTab(){
		driver.findElement(By.xpath(".//*/activity-filter/ul/li[1]/a")).click();
	}
	//post a status
	public void post(String statusText){
		ActivityFeed af = new ActivityFeed();
		af.postStatus(statusText);
	}
	//play a random video from the list
	public void playFeaturedVideos(){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ss-icon.ss-play")));
		
		WebElement allVideos = BrowserUtil.driver.findElement(By.xpath(".//*[@class='pull-left video-thumb ng-isolate-scope']"));		
		List<WebElement> vids = allVideos.findElements(By.xpath(".//*[@class='ss-icon ss-play']"));
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		
		String mainwindow = driver.getWindowHandle();
		WebElement container = driver.findElement(By.className("player-container"));
		WebElement frame = container.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath(".//*[@class='html5-video-loader html5-center-overlay ytp-scalable-icon-grow']")).click();
		//go back to main frame
		driver.switchTo().window(mainwindow);
		//wait for next video
	    driver.findElement(By.xpath("//div[5]/div/div/div/span")).click();
	}
	
	public void earnings(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpathLoc("Earnings"))));
		driver.findElement(By.xpath(menuXpathLoc("Earnings"))).click();
	}
	public void stats(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpathLoc("Stats"))));
		driver.findElement(By.xpath(menuXpathLoc("Stats"))).click();
	}
	public void creators(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpathLoc("Creators"))));
		driver.findElement(By.xpath(menuXpathLoc("Creators"))).click();
	}
	public void forums(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpathLoc("Forums"))));
		driver.findElement(By.xpath(menuXpathLoc("Forums"))).click();
	}
	public void apps(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpathLoc("Apps"))));
		driver.findElement(By.xpath(menuXpathLoc("Apps"))).click();
	}
	
	public void everyone(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("everyone")));
		driver.findElement(By.linkText("everyone")).click();

	}
	

	public void whoToFollow() { // set only to follow, cannot unfollow right
								// away as the list gets updated after a follow
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/suggested-creators/div/ul/li/div/follow-button/a")).click();
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/suggested-creators/div/ul/li[2]/div/follow-button/a")).click();
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/suggested-creators/div/ul/li[3]/div/follow-button/a")).click();
	}

	public void creatorLikeYou() {
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/similar-creators/div/ul/li/div/follow-button/a")).click();
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/similar-creators/div/ul/li[2]/div/follow-button/a")).click();
		driver.findElement(By.xpath("//div[@id='fs-page-container']/div[2]/div[2]/div[2]/similar-creators/div/ul/li[3]/div/follow-button/a")).click();

	}
	
	
}
