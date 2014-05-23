package forums;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.PageScroller;
import utils.Randomizer;

public class ForumsPage {

	WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Randomizer ran = new Randomizer();
	PageScroller scroller = new PageScroller();
	CustomFinder find = new CustomFinder();

	public ForumsPage() {
		String url = "https://staging-community.fullscreen.net/forums";
		driver.get(url);
	}

	// remove topic
	public void removeTopic() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/ul")));
		driver.findElement(By.xpath(".//a[text()='Remove']")).click();
	}

	// unsubscribe
	public void unsubscribeTopic() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/ul")));
		driver.findElement(By.xpath(".//a[text()='unsubscribe']")).click();
	}

	// edit topic
	public void editTopic(String title) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/ul")));
		driver.findElement(By.xpath(".//a[text()='edit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='postTitle']")));
		driver.findElement(By.xpath(".//input[@name='postTitle']")).sendKeys(title);
		driver.findElement(By.xpath(".//button[@ng-click='submit()']")).click();
	}

	// lock a topic
	public void lockTopic() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/ul")));
		driver.findElement(By.xpath(".//a[text()='lock']")).click();
	}

	// pin a opic
	public void pinTopic() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/ul")));
		driver.findElement(By.xpath(".//a[text()='pin']")).click();
	}

	// move topic
	public void moveTopicTo(String category) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/a")));
		driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/forum-thread/div[2]/div/div/a")).click();
		String xpathExpression = ".//select[@name='categoryId']";
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));

		switch (category) {

		case "Announcements":
			select.selectByValue("0");
			break;
		case "Welcome Center":
			select.selectByValue("1");
			break;
		case "Tutorials and Tips":
			select.selectByValue("2");
			break;
		case "Production":
			select.selectByValue("3");
			break;
		case "Peer Support":
			select.selectByValue("4");
			break;
		case "Collaboratory":
			select.selectByValue("5");
			break;
		case "Meetups":
			select.selectByValue("6");
			break;
		case "Creative Services":
			select.selectByValue("7");
			break;
		case "Wanted":
			select.selectByValue("8");
			break;
		case "For Sale":
			select.selectByValue("9");
			break;
		case "YouTube":
			select.selectByValue("10");
			break;
		case "Promotion Hub":
			select.selectByValue("11");
			break;
		case "Gorilla":
			select.selectByValue("12");
			break;
		case "General Discussion":
			select.selectByValue("13");
			break;
		case "Achievement Bragging":
			select.selectByValue("14");
			break;
		case "Shameless Self-Promotion":
			select.selectByValue("15");
			break;
		case "Ideas and Suggestions":
			select.selectByValue("16");
			break;
		case "Fullscreen em Português":
			select.selectByValue("17");
			break;
		case "Fullscreen en Español":
			select.selectByValue("18");
			break;
		case "Fullscreen en Français":
			select.selectByValue("19");
			break;

		default:
			break;
		}
	}

	// reply to a comment
	public void replyToComment(String message) {
		// TODO complete this
	}

	// reply to a thread
	public void replyToThread(String message) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='postTitle']")));
		driver.findElement(By.xpath(".//textarea[@name='postBody']")).sendKeys(message);
		driver.findElement(By.xpath(".//button[@ng-click='submit()']")).click();
	}

	// new thread, with a topic
	public void startNewThread(String title, String message) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@ng-click='jumpToReply()']")));
		driver.findElement(By.xpath(".//*[@ng-click='jumpToReply()']")).click();
	}

	// search
	public void searchForums(String query) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='search']")));
		driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(query);
		driver.findElement(By.xpath(".//input[@name='search']")).sendKeys(Keys.ENTER);
	}

	// click on a now trending topic in the right side bar
	public void trendingTopic() {
		WebElement allTrending = BrowserUtil.driver.findElement(By.xpath(".//*[@class='topic-list']"));
		List<WebElement> trends = allTrending.findElements(By.tagName("a"));
		Randomizer r = new Randomizer();
		r.randomClick(trends);
	}

	// click on the most recent topic
	public void openMostRecentIn(String topic) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]/div")));
		scroller.scrollTo(driver.findElement(By.xpath(".//h3[text()='" + topic + "']")));
		driver.findElement(By.xpath(".//h3[text()='" + topic + "']/../p/span")).click();
	}

	// create a new post from the home page
	public void newCategoryThread(String category, String title, String message) {
		driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[1]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fs-application-wrapper']/div[3]/div/div[2]")));
		String xpathExpression = ".//select[@name='categoryId']";
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));

		switch (category) {

		case "Announcements":
			select.selectByValue("0");
			break;
		case "Welcome Center":
			select.selectByValue("1");
			break;
		case "Tutorials and Tips":
			select.selectByValue("2");
			break;
		case "Production":
			select.selectByValue("3");
			break;
		case "Peer Support":
			select.selectByValue("4");
			break;
		case "Collaboratory":
			select.selectByValue("5");
			break;
		case "Meetups":
			select.selectByValue("6");
			break;
		case "Creative Services":
			select.selectByValue("7");
			break;
		case "Wanted":
			select.selectByValue("8");
			break;
		case "For Sale":
			select.selectByValue("9");
			break;
		case "YouTube":
			select.selectByValue("10");
			break;
		case "Promotion Hub":
			select.selectByValue("11");
			break;
		case "Gorilla":
			select.selectByValue("12");
			break;
		case "General Discussion":
			select.selectByValue("13");
			break;
		case "Achievement Bragging":
			select.selectByValue("14");
			break;
		case "Shameless Self-Promotion":
			select.selectByValue("15");
			break;
		case "Ideas and Suggestions":
			select.selectByValue("16");
			break;
		case "Fullscreen em Português":
			select.selectByValue("17");
			break;
		case "Fullscreen en Español":
			select.selectByValue("18");
			break;
		case "Fullscreen en Français":
			select.selectByValue("19");
			break;

		default:
			break;
		}

		driver.findElement(By.xpath(".//input[@name='postTitle']")).sendKeys(title);
		driver.findElement(By.xpath(".//textarea")).sendKeys(message);
		driver.findElement(By.xpath(".//button")).click();
	}

	// click on a section
	public void openTopic(String name) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[text()='" + name + "']")));
		scroller.scrollTo(".//h3[text()='" + name + "']");
		driver.findElement(By.xpath(".//h3[text()='" + name + "']")).click();
	}

}
