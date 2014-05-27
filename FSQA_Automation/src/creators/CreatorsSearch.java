package creators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.PageScroller;
import utils.Randomizer;

public class CreatorsSearch {

	WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Randomizer ran = new Randomizer();
	PageScroller scroller = new PageScroller();
	CustomFinder find = new CustomFinder();

	public CreatorsSearch() {
		driver.get("https://staging-community.fullscreen.net/creators");
		find.byXpathNSNC(".//*[@id='menu-creators']");
	}
	public void message(){
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath("//message-button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//message-button")));
		BrowserUtil.driver.findElement(By.xpath("//message-button")).click();
		BrowserUtil.driver.navigate().back();;	
	}
	
	public void followUnfollow(){ // can't. ppl not being followed will not appear in that list
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//follow-button")));
			BrowserUtil.driver.findElement(By.xpath("//follow-button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No followers ... ");
		}	
	}
	// filter by audience gender
	public void filterByGender() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-slider-03K']")));
		driver.findElement(By.xpath(".//*[@id='search-slider-03K']")).click();
	}

	// filter by avail for hire
	public void filterByHire() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='available-for-hire']")));
		driver.findElement(By.xpath(".//*[@id='available-for-hire']")).click();
	}

	// filter availability by collaboration
	public void filterByCollab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='available-for-collaboration']")));
		driver.findElement(By.xpath(".//*[@id='available-for-collaboration']")).click();
	}

	// filter by subs
	public void filterBySubs() {
		// activate the check box
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-slider-03D']")));
		driver.findElement(By.xpath(".//*[@id='search-slider-03D']")).click();

	}

	// click on an expertise tag
	public void checkExpertise(String tag) {
		// TODO complete this function, xpaths stuff

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[2]/div[2]/div/div")));
		scroller.scrollTo(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[2]/div[1]");
		scroller.scrollTo(driver.findElement(By.xpath(".//input[contains(@id,'" + tag + "') ]")));
		driver.findElement(By.xpath(".//input[contains(@id,'" + tag + "') ]")).click();
		;
	}

	// search an expertise tag
	public void searchExpertise(String query) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@placeholder='Search for more types...']")));
		driver.findElement(By.xpath(".//input[@placeholder='Search for more types...']")).sendKeys(query);
		driver.findElement(By.xpath(".//input[@placeholder='Search for more types...']")).sendKeys(Keys.ENTER);

	}

	// select radius , accepted values " 25 miles, 50 miles, 100 miles, 500
	// miles, 1000 miles
	public void radius(String radius) {
		String xpathExpression = ".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[1]/div[2]/div/radius-select/div[1]/p[3]/div/select";
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		switch (radius) {
		case "25 miles":
			select.selectByValue("0");
			break;
		case "1000 miles":
			select.selectByValue("4");
			break;
		case "50 miles":
			select.selectByValue("1");
			break;
		case "100 miles":
			select.selectByValue("2");
			break;
		case "500 miles":
			select.selectByValue("3");
			break;

		default:
			break;
		}

	}

	// search creators
	public void search(String query) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='search']")));
		find.byXpathNSNC(".//input[@name='search']");
		driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(query);
		driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(Keys.ENTER);

	}

	// save a search, use only after a search has been done and has results
	public void saveSearch(String title) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[1]/div/div[1]")));
		driver.findElement(By.cssSelector(".fs-button.sm.ng-isolate-scope.ng-binding")).click();
		// enter title of search
		driver.findElement(By.xpath(".//input[@name='title']")).sendKeys(title);
		// click save button
		driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[3]/button[2]")).click();
	}

	// open a saved search
	public void openSavedSearch(String savedSearch) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[5]/div[2]/div")));
		driver.findElement(By.xpath(".//p[.=' " + savedSearch + "']")).click();
	}

	// delete a search
	public void delSavedSearch(String savedSearch) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[5]/div[2]/div")));
		driver.findElement(By.xpath(".//p[.=' " + savedSearch + "']/../div")).click();
	}
}