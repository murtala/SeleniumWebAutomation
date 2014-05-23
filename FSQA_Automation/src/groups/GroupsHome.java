package groups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.PageScroller;
import utils.Randomizer;

public class GroupsHome {

	WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Randomizer ran = new Randomizer();
	PageScroller scroller = new PageScroller();
	public GroupsHome() {
		driver.get("https://staging-community.fullscreen.net/groups");
	}
	
	//click all groups tab
	public void allGroupsTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@class='nav-pill nav']")));
		driver.findElement(By.xpath(".//*[@class='nav-pill nav']/li[2]/a")).click();
	}
	//your groups tab
	public void youGroupsTab(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@class='nav-pill nav']")));
		driver.findElement(By.xpath(".//*[@class='nav-pill nav']/li[3]/a")).click();
	}
	//search 
	public void searchGroup(String query){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Search groups']")));
		driver.findElement(By.xpath(".//*[@placeholder='Search groups']")).sendKeys(query);
		driver.findElement(By.xpath(".//*[@placeholder='Search groups']")).sendKeys(Keys.ENTER);
		
		//add random selection of group based on search
	}
	//click on a random most popular group
	public void ranMPgroup() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@collection='popular']")));
		//WebElement allGroups = BrowserUtil.driver.findElement(By.xpath(".//*[@collection='popular' ] /*[@class='group-list-wrapper' ]"));
		WebElement allGroups = BrowserUtil.driver.findElement(By.xpath(".//*[@collection='popular' ]"));
		List<WebElement> groups = allGroups.findElements(By.tagName("a"));
		System.out.println(groups.size());
		scroller.scrollTo(driver.findElement(By.xpath(".//*[@collection='popular' ]/hgroup")));
		ran.randomClick(groups);
	}
	
	//click on a random newest group
	public void ranNewgroup(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@collection='newest']")));
	
		WebElement allGroups = BrowserUtil.driver.findElement(By.xpath(".//*[@collection='newest' ] /*[@class='group-list-wrapper' ]"));
		List<WebElement> groups = allGroups.findElements(By.tagName("a"));
		scroller.scrollTo(driver.findElement(By.xpath(".//*[@collection='newest' ]/hgroup")));
		ran.randomClick(groups);
	}
	//click on a random avatar on any random group
		public void ranUserAvatar(){
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@collection='newest']")));
			
			//WebElement allGroups = BrowserUtil.driver.findElement(By.xpath("[@class='group-list-wrapper']"));
			List<WebElement> groups = driver.findElements(By.xpath(".//*[@class='user-avatar-list' ]/avatar//a"));
			scroller.scrollTo(driver.findElement(By.xpath(".//*[@class='user-avatar-list' ]/avatar//a")));
			ran.randomClick(groups);
		}

	// click on the all members avatr
	public void allUavatar() {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@collection='newest']")));

		// WebElement allGroups =
		// BrowserUtil.driver.findElement(By.xpath("[@class='group-list-wrapper']"));
		List<WebElement> groups =driver.findElements(By.xpath(".//*[@class='user-avatar-list' ]/a"));
		scroller.scrollTo(driver.findElement(By.xpath(".//*[@class='user-avatar-list']/..//..")));
		driver.findElement(By.xpath(".//*[@class='user-avatar-list' ]/a")).click();
		ran.randomClick(groups);
	}
	/*create a group
	 * for visibility, only "Secret", "Open", and "closed" are available
	 * there should be no erro on page, or else won't create
	 */
	public void createGroup(String groupName, String groupDesc, String visibility, Boolean playlist, Boolean limit){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@ng-click='createGroup()']")));
		//create the group
		driver.findElement(By.xpath(".//button[@ng-click='createGroup()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("groupEditForm")));
		//enter name and decription
		driver.findElement(By.id("group-edit-name")).sendKeys(groupName);
		driver.findElement(By.id("group-edit-description")).sendKeys(groupDesc);
		//visibility of the group
		switch (visibility) {
		case "Secret":
			driver.findElement(By.xpath(".//*[@class='radio'][3]//input")).click();
			break;
		case "Open":
			driver.findElement(By.xpath(".//*[@class='radio'][1]//input")).click();
			break;
		case "Closed":
			driver.findElement(By.xpath(".//*[@class='radio'][2]//input")).click();
			break;
		default:
			System.out.println("No supported option selected or wirtten");
			break;
		}
		//addd playlist or not
		if (!playlist){
			driver.findElement(By.xpath(".//input[@ng-checked='changes.create_playlists']")).click();
		}
		//limit membership to 100
		if (limit){
			driver.findElement(By.xpath(".//input[@ng-checked='changes.limit_by_reach']")).click();
		}
		//create the group
		driver.findElement(By.xpath(".//button[@ng-click='submit()']")).click();
	}
}


//.//*[@class='form-group'][3]