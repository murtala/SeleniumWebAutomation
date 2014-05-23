package community;

//import static org.junit.Assert.*;
import groups.GroupsHome;

import java.util.Calendar;
import java.util.Date;

//import org.junit.Test;

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
		BrowserUtil.setBrowser("chrome");
		l.authenticate("tester@fullscreen.net", "fullscreen!!1");
		
		//GroupsHome g = new GroupsHome();
		//g.createGroup( date.toString(), date.toString(), "Closed", true, false);
		//g.allGroupsTab();
		//g.allUavatar();//********** needs scroll fix
		//g.ranMPgroup();//**
		//g.ranNewgroup();//**
		//g.ranUserAvatar();//** size issues
		//g.searchGroup("beauty");
		//g.youGroupsTab();
		//Header h = new Header();
		//h.homeLink();
		
		//SessionControls sc = new SessionControls();
		//sc.messages();
		//sc.notifications();fff
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
		
		//Footer f = new Footer();
		//f.mobileLink();
		//f.helpCenterLink();
		//f.moreLinks();
		//f.selectLanguages();
		
		//User u = new User();
		//u.fsUser();
		//u.editProfile("Robot", "011101001", "website","slug", true, true);

		//u.editProfilePic("G:\\Users\\Moortala\\Documents\\GitHub\\SeleniumWebAutomation\\FSQA_Automation\\src\\community\\user\\388135main_PIA11667_full.jpg");
		//u.editCover("G:\\Users\\Moortala\\Documents\\GitHub\\SeleniumWebAutomation\\FSQA_Automation\\src\\community\\user\\388135main_PIA11667_full.jpg");
		//u.profileWebsite();
		//u.twitterNickname();
		//u.editBio("put bio description here");
		//u.addExpertise("musical");
	//	u.addExpertise("music interpreter");
		//u.addExpertise("music arranger");
		//u.removeExpertise("musical");

		
		//on mac
		//u.editProfilePic("//FSQA_Automation//src//community//user//388135main_PIA11667_full.jpg");
		//***********************u.editCover("//FSQA_Automation//src//community//user//388135main_PIA11667_full.jpg");
		//u.profileWebsite();
		//u.twitterNickname();
		//u.editBio("put bio description here");
		//u.addExpertise("gamer"); ************
		//u.removeExpertise("game");***********************
		//u.sidebarGroups();
		//u.sidebarChannel();

		//u.feed();
		//Feed f = new Feed();
		//f.post(date.toString());
     //   f.comment("This is a comment : " + date.toString());
	//	f.activityFilter("");
      //  f.activityFilter("Milestones");    // use: All, Status Posts, Video Uploads, Forums, Milestones
		//f.hidePost();
		//f.likePost();
		//f.likeUnlikePost();
		//f.likeComment();
		//f.unlikeComment();
		//f.timeStampPermaLink();
		//f.hidePost();
		//f.UnsubscribePost(); 
		//u.followers();
		//Followers fo = new Followers();
		//fo.followUnfollow();
		//fo.userList();
		//fo.unFollow();
		//fo.message();
		
		//About ab = new About();
		//ab.clickTags();
		
		//Home h = new Home();
		//h.playFeaturedVideos(); //********************** work on playing next after 30 secs
		//h.post("This is a Status Post : " + date.toString());
		//h.everyoneTab();
		//h.myFeedTab();
		//h.changeFilterTo("Milestones");
		//h.rsSimCreator();
		//h.rsFUCreator();
		//h.rsBlogLink();  //************ to be completed
		//h.rsBlogLinkTag();  // //************ to be completed
		//h.postComment("yoyoy"); //**** not working
		//h.rateComment();
		//h.ratePost();
		
		
		//f.reportPost();  // not ready
		//u.linkTwitter("fsqa01", "fstester");
		//u.addExpertise("gamer");// not ready
		// u.removeExpertise();
		
		//u.followers();
		//u.following();
		//u.about();	
		try {
			Thread.sleep(10000);
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
