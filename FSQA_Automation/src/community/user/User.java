package community.user;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Highlighter;

public class User extends BrowserUtil {
	static String win[] = null;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Highlighter h = new Highlighter();
	Actions action = new Actions(driver);

	// click on profile icon
	public void fsUser() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")));
		// h.highlightElement(driver.findElement(By.cssSelector(".avatar.sm.circle")));
		driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")).click();
	}

	public void feed() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Feed']")));
		driver.findElement(By.xpath("//a[text()='Feed']")).click();
	}

	public void following() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Following']")));
		driver.findElement(By.xpath("//a[text()='Following']")).click();
	}

	public void about() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About']")));
		driver.findElement(By.xpath("//a[text()='About']")).click();
	}

	/* use with caution, as for now there is no way to handle tabs in selenium. */
	public void profileWebsite() {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='website ng-binding']")));
		try {
			driver.findElement(By.xpath("//li[@ng-show='profile.website']")).click();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("No web site set");
		}
	}

	public void twitterNickname() {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Nickname on Twitter']")));
		try {
			driver.findElement(By.xpath("//a[@title='Nickname on Twitter']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("No Twitter account set");
		}
	}

	// click edit profile button
	protected void editProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='profile-edit-actions']/a")));
		driver.findElement(By.xpath("//div[@class='profile-edit-actions']/a")).click();
	}

	public void editProfilePic(String path) { // select profile pic . PC/Mac
												// path are !=
		editProfile();
		driver.findElement(By.xpath("//input[@class='avatar-file-select']")).sendKeys(path);
		doneEditing();
	}

	public void editCover(String path) {
		editProfile();
		driver.findElement(By.xpath(".//input[@class='banner-file-picker']")).sendKeys(path);
		// click save cover button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='fs-button sm banner-save ng-binding']")));
		driver.findElement(By.xpath("//button[@class='fs-button sm banner-save ng-binding']")).click();
		;
		// doneEditing();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@class='banner-file-picker']")));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// executor.executeScript("document.getElementByClassName('banner-uploader ng-isolate-scope ng-pristine ng-valid').style.display='block';");
		executor.executeScript("document.getElementsByClassName('banner-file-picker')[0].style.display='block';");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(".//input[@class='banner-file-picker']")).sendKeys(path);
		executor.executeScript("document.getElementsByClassName('banner-file-picker')[0].style.display='none';");
		// click save cover button
		executor.executeScript("document.getElementsByClassName('banner-preview')[0].style.display='block';");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(".//button[@class='fs-button sm banner-save ng-binding']")).click();
		;
		doneEditing();
	}

	public void editBio(String bio) {
		editProfile();

		driver.findElement(By.name("bioField")).clear();
		driver.findElement(By.name("bioField")).sendKeys(bio);

		doneEditing();
	}

	public void addExpertise(String tag) {

		editProfile();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fs-tag-list-secondary.editable")));
		// driver.findElement(By.xpath("//div//a[@ng-click='editProfile(false)']")).click();
		try {
			BrowserUtil.scrollToElement(driver.findElement(By.xpath("//section//h3[.='Expertise and interests']")));
			driver.findElement(By.id("creator-type-search")).click();
			driver.findElement(By.id("creator-type-search")).sendKeys(tag);
			driver.findElement(By.xpath("//ul//li//span[.='" + tag + "']")).click();

		} catch (NoSuchElementException e) {
			System.out.println("tag already added/removed");
		}
		// doneEditing();
	}

	public void removeExpertise(String tag) {
		editProfile();

		/*
		 * BrowserUtil.scrollToElement(driver.findElement(By.xpath(
		 * "//section//h3[.='Expertise and interests']")));
		 * wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.cssSelector(
		 * ".fs-tag-list-primary.editable.sortable.ng-pristine.ng-valid.ui-sortable"
		 * ))); doneEditing();
		 */
		try {
			driver.findElement(By.xpath("//ul//li//span[.='" + tag + "']")).click();
		} catch (NoSuchElementException e) {
			System.out.println("tag already added/removed");
		}
		// doneEditing();
		doneEditing();
	}

	public void linkFacebook() {

	}

	public void linkTwitter(String user, String password) {
		editProfile();
		String mainwindow = driver.getWindowHandle();
		System.out.println("main window: " + mainwindow);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,600)", "");

		driver.findElement(By.xpath("//social-link[1]/a")).click();

		Set<String> windows = driver.getWindowHandles();
		int i = 0;

		win = new String[3];
		win[0] = "";
		for (Iterator iterator = windows.iterator(); iterator.hasNext();) {
			String window = (String) iterator.next();
			win[i] = window;
			System.out.println("win :" + win[i]);
			i++;
		}

		driver.switchTo().window(win[1]);
		driver.findElement(By.id("username_or_email")).clear();
		driver.findElement(By.id("username_or_email")).sendKeys(user);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("allow")).click();

		// return to main window
		driver.switchTo().window(mainwindow);

		WebElement element = driver.findElement(By.xpath(".//*[@id='fs-content-banner-content']/div[2]/div[1]/a"));
		doneEditing();

	}

	public void editProfile(String name, String location, String website, String slug, boolean colab, boolean hire) {
		// editProfile();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='profile-edit-actions']")));

		// click pen icon
		driver.findElement(By.xpath(".//div[@class='profile-edit-actions']")).click();
		// Edit name
		driver.findElement(By.xpath(".//button[@class='edit-profile-form-trigger']")).click();
		;
		driver.findElement(By.xpath("//input[@id='edit-profile-name']")).clear();

		driver.findElement(By.id("edit-profile-name")).sendKeys(name);
		// edit location

		driver.findElement(By.id("edit-profile-location")).clear();

		driver.findElement(By.id("edit-profile-location")).sendKeys(location);

		// edit web site
		driver.findElement(By.id("edit-profile-website")).clear();
		driver.findElement(By.id("edit-profile-website")).sendKeys(website);

		// edit profile url
		driver.findElement(By.id("edit-slug")).clear();
		driver.findElement(By.id("edit-slug")).sendKeys(slug);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;

		// edit collaboration
		if (colab == true) {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='edit-profile-collaboration']")));
			boolean state = driver.findElement(By.id("edit-profile-collaboration")).isSelected();
			// Object state =
			// jsx.executeScript(" return document.getElementById('edit-profile-collaboration').checked");

			if (state == true) {

			} else {
				driver.findElement(By.id("edit-profile-collaboration")).click();
			}
		}
		if (colab == false) {
			// Object state =
			// jsx.executeScript(" return document.getElementById('edit-profile-collaboration').checked");
			boolean state = driver.findElement(By.id("edit-profile-collaboration")).isSelected();
			if (state == false) {

			} else {
				driver.findElement(By.id("edit-profile-collaboration")).click();
			}
		}
		// edit for hire
		if (hire == true) {
			boolean state = driver.findElement(By.id("edit-profile-hire")).isSelected();
			if (state == true) {
			}

		} else {
			driver.findElement(By.id("edit-profile-hire")).click();
		}
		if (hire == false) {
			boolean state = driver.findElement(By.id("edit-profile-hire")).isSelected();
			if (state == false) {
			}

		} else {
			driver.findElement(By.id("edit-profile-hire")).click();
		}

		save();
		doneEditing();
	}

	// Click on a random group in the side bar
	public void sidebarGroups() {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='sidebar-table sidebar-table-groups ng-scope']")));
		WebElement Parent = BrowserUtil.driver.findElement(By.xpath("//table[@class='sidebar-table sidebar-table-groups ng-scope']"));
		List<WebElement> list = Parent.findElements(By.className("row-title"));

		Random r = new Random();
		int ran = r.nextInt(list.size());
		WebElement listItem = list.get(r.nextInt(ran));
		WebElement listedItem = listItem.findElement(By.tagName("a"));
		BrowserUtil.scrollToElement(listedItem);
		Highlighter.highlightElement(listedItem);
		listedItem.click();
		BrowserUtil.driver.navigate().back();

	}

	// click on a channel on the right side bar
	public void sidebarChannel() {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='sidebar-table channel-list-table ng-scope']")));
		WebElement Parent = BrowserUtil.driver.findElement(By.xpath("//table[@class='sidebar-table channel-list-table ng-scope']"));
		List<WebElement> list = Parent.findElements(By.className("row-title"));
		System.out.println(list.size());
		int ran;
		WebElement listItem;
		Random r = new Random();
		if (list.size() == 1) {
			ran = 1;
			listItem = list.get((0));
		} else {
			ran = r.nextInt(list.size());
			listItem = list.get(r.nextInt(ran));

		}
		WebElement listedItem = listItem.findElement(By.tagName("a"));
		BrowserUtil.scrollToElement(listedItem);
		Highlighter.highlightElement(listedItem);
		listedItem.click();
		BrowserUtil.driver.navigate().back();
	}

	public void cancel() {
		// click cancel
		driver.findElement(By.xpath("//div[@id='fs-content-banner-content']/div[2]/form[2]/div[4]/label")).click();
	}

	protected void save() {
		// click save
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	protected void doneEditing() {
		// done editing

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ng-click='editProfile(false)']")));
		driver.findElement(By.xpath(".//*[@class='fs-button sm fs-light ng-binding']")).click();
		driver.findElement(By.xpath(".//*[@class='fs-button sm fs-light ng-binding']"));
	}
}
