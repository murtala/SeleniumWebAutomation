package creators;

import org.openqa.selenium.By;
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
	}
	
	//click on an expertise tag
	public void checkExpertise(String tag){
		//TODO complete this function, xpaths stuff
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[2]/div[2]/div/div")));
		scroller.scrollTo(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[2]/div[1]");
		//*[@id='creator-type-actor' and text()=' actor']
		//"       actor     "
		//input[starts-with(@id,'creator-type') ]/../text()='       videographer     '
	}
	
	//search an expertise tag
	public void searchExpertise(String query){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@placeholder='Search for more types...']")));
		driver.findElement(By.xpath(".//input[@placeholder='Search for more types...']")).sendKeys(query);
		driver.findElement(By.xpath(".//input[@placeholder='Search for more types...']")).sendKeys(Keys.ENTER);
		
	}
	//select radius  , accepted values " 25 miles, 50 miles, 100 miles, 500 miles, 1000 miles
	public void radius(String radius){
		String xpathExpression=".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[1]/div[2]/div/radius-select/div[1]/p[3]/div/select";
		Select select  = new Select(driver.findElement(By.xpath(xpathExpression)));
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
	//search creators
	public void search(String query){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='search']")));
	driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(query);	
	driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(Keys.ENTER);	
		
	}
	//save a search, use only after a search has been done and has results
	public void saveSearch(String title){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[1]/div/div[1]")));
		driver.findElement(By.cssSelector(".fs-button.sm.ng-isolate-scope.ng-binding")).click();
		//enter title of search
		driver.findElement(By.xpath(".//input[@name='title']")).sendKeys(title);
		//click save button
		driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[3]/button[2]")).click();
	}
	//open a saved search
	public void openSavedSearch(String savedSearch){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[5]/div[2]/div")));
		driver.findElement(By.xpath(".//p[.=' "+savedSearch+"']")).click();
	}

	//delete a search
	public void delSavedSearch(String savedSearch){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div/form/div[2]/search-sidebar/div[5]/div[2]/div")));
		driver.findElement(By.xpath(".//p[.=' "+savedSearch+"']/../div")).click();
	}
}