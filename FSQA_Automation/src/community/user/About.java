package community.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.Randomizer;

public class About {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);

	public About() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")));
		// h.highlightElement(driver.findElement(By.cssSelector(".avatar.sm.circle")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About']")));
		BrowserUtil.driver.findElement(By.xpath("//a[text()='About']")).click();
	}
	public void clickTags(){
		
		Randomizer r = new Randomizer();
		WebElement allTags = BrowserUtil.driver.findElement(By.xpath(".//*[@class='fs-tag-list-primary']"));
		List<WebElement> tags = allTags.findElements(By.tagName("a"));
		r.randomClick(tags);
	}

}
