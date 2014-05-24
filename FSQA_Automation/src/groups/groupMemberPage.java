package groups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.PageScroller;
import utils.Randomizer;

public class groupMemberPage {

	WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Randomizer ran = new Randomizer();
	PageScroller scroller = new PageScroller();
	CustomFinder find = new CustomFinder();
	
	//go to a specified group with url  -- make sure its not a private group
		public void openGroup(String url){
			driver.get(url);
		}
		//post a status
		public void statusPost(String status){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//textarea[@name='statusPostText']")));
			driver.findElement(By.xpath(".//textarea[@name='statusPostText']")).sendKeys(status);
			driver.findElement(By.xpath(".//button[@ng-click='postStatus()']")).click();
		}
	//leave a group
	public void joinLeaveGroup(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//join-button")));
		find.locateXpath(".//join-button");
	}
	//clikc Feed tab
	public void feedTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//a[.='Feed']")));
		driver.findElement(By.xpath(".//a[.='Feed']")).click();
	}
	
	public void videosTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//a[.='Videos']")));
		driver.findElement(By.xpath(".//a[.='Videos']")).click();
	}
	
	public void membersTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//a[.='Members']")));
		driver.findElement(By.xpath(".//a[.='Members']")).click();
	}
	public void settingsTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//a[.='Settings']")));
		driver.findElement(By.xpath(".//a[.='Settings']")).click();
	}
	
	public void playCarouselVid(){
		
	}
	
}
