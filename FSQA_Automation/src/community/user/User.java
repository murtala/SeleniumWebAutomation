package community.user;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Service.State;

import utils.BrowserUtil;

public class User extends BrowserUtil {
	static String win[] = null;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	  Actions action = new Actions(driver);

	// click on profile icon
	public void fsUser() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='fs-user']"))));
		driver.findElement(By.id("fs-user")).click();
	}
	
	public void feed(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Feed']")));
		driver.findElement(By.xpath("//a[text()='Feed']")).click();
	}
	
	public void following(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Following']")));
		driver.findElement(By.xpath("//a[text()='Following']")).click();
	}
	public void about(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About']")));
		driver.findElement(By.xpath("//a[text()='About']")).click();
	}
	
	/* use with caution, as for now there is no way to handle tabs in selenium. */
	public void profileWebsite() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='website ng-binding']")));
		driver.findElement(By.xpath("//li[@ng-show='profile.website']")).click();
	}

	public void twitterNickname(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Nickname on Twitter']")));
		driver.findElement(By.xpath("//a[@title='Nickname on Twitter']")).click();
	}
	// click edit profile button
	protected void editProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='profile-edit-actions']/a")));
		driver.findElement(By.xpath("//div[@class='profile-edit-actions']/a")).click();		
	}

	public void editProfilePic(String path) {  //select profile pic .  PC/Mac path are !=
		editProfile();
		driver.findElement(By.xpath("//input[@class='avatar-file-select']")).sendKeys(path);
		doneEditing();
	}
	
	public void editCover(String path) {
		editProfile();
		driver.findElement(By.xpath(".//input[@class='banner-file-select']")).sendKeys(path);
		//click save cover button
		driver.findElement(By.xpath(".//a[@class='profile-btn edit-btn save-btn cancel ng-binding']")).click();;
		doneEditing();
	}
	public void editBio(String bio){
		editProfile();

		driver.findElement(By.name("bioField")).clear();
		driver.findElement(By.name("bioField")).sendKeys(bio);
		driver.findElement(By.xpath(".//*[@id='fs-content-banner-content']/div[2]/div[1]/a")).click();
	}
	
	public void addExpertise(String tag){
		editProfile();		

		try {
			driver.findElement(By.xpath("//div/ul[2]//li//span[text()='"+tag+"']")).click();

		} catch (NoSuchElementException e) {
			System.out.println("tag already added/removed");
		}
	}
	
	protected void removeExpertise(String tag){
		editProfile();		

		try {
			driver.findElement(By.xpath("//div/ul[1]//li//span[text()='"+tag+"']")).click();
		} catch (NoSuchElementException e) {
			System.out.println("tag already added/removed");
		}
	}
	
	
	public void linkFacebook(){
		
	}
	
	public void linkTwitter(String user, String password) {
		editProfile();
		String mainwindow = driver.getWindowHandle();
		System.out.println("main window: " + mainwindow);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
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
		
		 //return to main window
		 driver.switchTo().window(mainwindow);
		 
		WebElement element = driver.findElement(By.xpath(".//*[@id='fs-content-banner-content']/div[2]/div[1]/a"));
			doneEditing();
		 
	}

	public void editProfile(String name, String location, String website, boolean colab, boolean hire ) {
		editProfile();	
		// click pen icon
		driver.findElement(By.cssSelector("button.edit-profile-form-trigger")).click();

		// Edit name
		driver.findElement(By.id("edit-profile-name")).clear();
		
		driver.findElement(By.id("edit-profile-name")).sendKeys(name);
		// edit location

		driver.findElement(By.id("edit-profile-location")).clear();
		
		driver.findElement(By.id("edit-profile-location")).sendKeys(location);

		// edit web site
		driver.findElement(By.id("edit-profile-website")).clear();
		driver.findElement(By.id("edit-profile-website")).sendKeys(website);

		JavascriptExecutor jsx = (JavascriptExecutor)driver;

		// edit collaboration
		if (colab == true) {
			Object state = jsx.executeScript(" return document.getElementById('edit-profile-collaboration').checked");

			if (state.toString().equalsIgnoreCase("true")) {

			} else {
				driver.findElement(By.xpath(".//label[.=' Available for collaboration']")).click();
			}
		}
		if (colab == false) {
			Object state = jsx.executeScript(" return document.getElementById('edit-profile-collaboration').checked");

			if (state.toString().equalsIgnoreCase("false")) {

			} else {
				driver.findElement(By.xpath(".//label[.=' Available for collaboration']")).click();
			}
		}
		// edit for hire
		if (hire == true) {
			Object state = jsx.executeScript(" return document.getElementById('edit-profile-hire').checked");
			if (state.toString().equalsIgnoreCase("true")) {
			}

		} else {
			driver.findElement(By.xpath(".//label[.=' Available for hire']")).click();
		}
		if (hire == false) {
			Object state = jsx.executeScript(" return document.getElementById('edit-profile-hire').checked");
			if (state.toString().equalsIgnoreCase("false")) {
			}

		} else {
			driver.findElement(By.xpath(".//label[.=' Available for hire']")).click();
		}
		
		save();
		doneEditing();
	}
	public void cancel(){
		// click cancel
		driver.findElement(By.xpath("//div[@id='fs-content-banner-content']/div[2]/form[2]/div[4]/label")).click();
	}
	
	protected void save(){
		// click save
				driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	protected void doneEditing(){
		//done editing
				driver.findElement(By.xpath(".//*[@class='fs-button sm fs-light ng-binding']")).click();
	}
}
