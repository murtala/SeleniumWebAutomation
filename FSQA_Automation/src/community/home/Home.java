package community.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Randomizer;

public class Home {
static WebDriver driver = BrowserUtil.driver;
WebDriverWait wait = new WebDriverWait(driver, 30);
String path="";

String path2="";
public String menuXpathLoc(String path){
	 return path=".//*[@class='fs-menu-list clearfix']/li//a/span[.='"+path+"']";
}

	public Home() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-home']")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='menu-home']")).click();
	}
	//play a random video from the list
	public void playFeaturedVideos(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='featured-videos clearfix']")));
		WebElement allVideos = BrowserUtil.driver.findElement(By.xpath(".//*[@class='featured-videos clearfix']"));
		List<WebElement> vids = allVideos.findElements(By.tagName("span"));
		Randomizer r = new Randomizer();
		r.randomClick(vids);
		
		
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
