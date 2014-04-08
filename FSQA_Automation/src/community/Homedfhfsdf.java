package community;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Homedfhfsdf {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://fscreator-platform-staging.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  

  @Test
  public void testHome() throws Exception {
    //  Home 
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("span.fs-menu-item-label.ng-binding")).click();
    // Click my everyone
    driver.findElement(By.linkText("everyone")).click();
    // click my feed
    driver.findElement(By.linkText("my feed")).click();
   
    // like this
    driver.findElement(By.cssSelector("span.like-label.ng-binding")).click();
    // write comment
    // Hide a comment
    driver.findElement(By.xpath("//div[@id='fs-user-feed']/activity-feed-item/div/div/div/div[4]/comment-list/comment-item/div/div/div[3]/a")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Hide')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='fs-user-feed']/activity-feed-item/div/div/div/div[4]/comment-list/comment-item/div/div/div[3]/a")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Hide')])[2]")).click();
    // Unsuscribe
    driver.findElement(By.xpath("//div[@id='fs-user-feed']/activity-feed-item/div/div/div/div/a")).click();
    driver.findElement(By.linkText("Unsubscribe")).click();
    // hide post
    driver.findElement(By.xpath("//div[@id='fs-user-feed']/activity-feed-item/div/div/div/div/a")).click();
    driver.findElement(By.linkText("Hide")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
