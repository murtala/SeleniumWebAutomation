package community;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

//import org.junit.Test;







import community.footer.Footer;
import community.header.AccountControls;
import community.header.Header;
import community.header.NotificationsModal;
import community.home.Home;
import community.user.About;
import community.user.Feed;
import community.user.Followers;
import community.user.Following;
import community.user.User;
import utils.BrowserUtil;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CommunityTest {

	
	 @BeforeClass
	 public void oneTimeSetUp() {
//	 WebDriverManager.startDriver();
	 }
	
	 
	 
	@Test
	public void test() {
		// fail("Not yet implemented");
		Date date = Calendar.getInstance().getTime();
		Login l = new Login();
		BrowserUtil.setBrowser("ch");
		l.authenticate("fullscreentester@gmail.com", "fullscreen!!1");
		User u = new User();
		//u.fsUser();
		Header h = new Header();
		//h.homeLink();
		//SessionControls sc = new SessionControls();
		//sc.messages();
		//sc.notifications();
		//sc.accountControls();
		//NotificationsModal nm = new NotificationsModal();
		//nm.openNotifications();
		//nm.openRandomNotification();
		//nm.seeAll();
		//NotificationsPage np = new NotificationsPage();
		//np.openRandomNotification();
		//np.paginationLinks();
		
		//AccountControls ac = new AccountControls();
		//ac.user();
		//ac.editProfile();
		//ac.help();
		//ac.settings();
		//ac.logOut();  //will not work if outsde coommunity cuz mouse click becomes mouse over
		
		Footer f = new Footer();
		
		//f.mobileLink();
		//f.helpCenterLink();
		//f.moreLinks();
		f.selectLanguages();
		
		//u.editProfile("Robot", "011101001", "website", true, true);
		//u.editProfilePic("/Users/madamou/Dropbox/files/Ice-icon.png");
		//u.editCover("/Users/madamou/Dropbox/files/Ice-icon.png");
		//u.profileWebsite();
		//u.twitterNickname();
		//u.editBio("put bio description here");
		//u.feed();
		//Feed f = new Feed();
		//f.post(date.toString());
        //f.comment(date.toString());
		//f.likePost();
		//f.likeUnlikePost();
		//f.likeComment();
		//f.unlikeComment();
		//f.timeStampPermaLink();
		//f.hidePost();
		//f.UnsubscribePost(); 
		//u.followers();
		//Followers fo = new Followers();
		//fo.unFollow();
		//fo.message();
		//Following f1 = new Following();
		//f1.message();
		//About ab = new About();
	//	Home h = new Home();
		
		//f.reportPost();  // not ready
		//u.linkTwitter("fsqa01", "fstester");
		//u.addExpertise("gamer");// not ready
		// u.removeExpertise();
		
		//u.followers();
		//u.following();
		//u.about();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	 @AfterClass
	 public void oneTimeTearDown() {
		 BrowserUtil.driver.quit();
	 }
}
