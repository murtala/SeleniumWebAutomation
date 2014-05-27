package community;

//import static org.junit.Assert.*;
import forums.ForumsPage;
import groups.GroupsHome;

import java.util.Calendar;
import java.util.Date;

//import org.junit.Test;














import utils.BrowserUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import community.header.AccountControls;
import community.header.NotificationsModal;
import community.header.SessionControls;
import community.home.Home;
import community.user.Feed;
import community.user.User;
import creators.CreatorsSearch;
public class CommunityTest {

	
	 @BeforeClass
	 public void oneTimeSetUp() {
//	 WebDriverManager.startDriver();
	 }
	
	@Test
	public void test() throws InterruptedException {
		// fail("Not yet implemented");
		Date date = Calendar.getInstance().getTime();
		Login l = new Login();
		BrowserUtil.setBrowser("chrome");
		l.authenticate("tester@fullscreen.net", "");
		Feed f = new Feed();
		Thread.sleep(2000);
		f.post("This is a post on: " + date.toString());
		Thread.sleep(2000);
        f.comment("This is a comment : " + date.toString());
		Thread.sleep(2000);
        f.activityFilter("Forums");//All, "Status Posts", "Video Uploads, "Forums", "Milestones"
        Thread.sleep(2000);
		
        Home h = new Home();
        h.playFeaturedVideos(); //********************** work on playing next after 30 secs
        Thread.sleep(2000);
        GroupsHome g = new GroupsHome();
        Thread.sleep(2000);
        g.searchGroup("beauty");
        Thread.sleep(2000);
        g.youGroupsTab();
        Thread.sleep(2000);
        CreatorsSearch cs = new CreatorsSearch();
        cs.search("actors");
        Thread.sleep(2000);
        ForumsPage forum = new ForumsPage();
        forum.newCategoryThread("Welcome Center", "welcome to Fullscreen !", "Hello, I am new here");
        Thread.sleep(2000);
        SessionControls sc = new SessionControls();
		sc.messages("This message was written on : " +  date.toString() + "" , "murtala");
		Thread.sleep(2000);
		AccountControls ac = new AccountControls();
		ac.logOut();  //will not work if outsde coommunity cuz mouse click becomes mouse over
		
		
        
		/*****************************************************************/
		//top bar
		/*SessionControls sc = new SessionControls();
		sc.messages("This message was written on : " +  date.toString() + "" , "murtala");
		NotificationsModal nm = new NotificationsModal();
		nm.openRandomNotification();
		nm.seeAll();*/
		
		// notifications
		//NotificationsPage np = new NotificationsPage();
		//np.openRandomNotification();
		//np.paginationLinks();
		
	//	User u = new User();
		//u.editProfile("FullofTests", "011101001", "website","tester", true, true);
		//u.profileWebsite();
		
		/** feeds  **/
				//Feed f = new Feed();
			//	f.post("This is a post on: " + date.toString());
		      //  f.comment("This is a comment : " + date.toString());
			    //f.activityFilter("Milestones");//All, "Status Posts", "Video Uploads, "Forums", "Milestones"
		        //f.activityFilter("Forums");    // use: All, Status Posts, Video Uploads, Forums, Milestones
				//f.hidePost(); // *** top nav obstructs
				//f.likePost();
				//f.likeUnlikePost();
				//f.likeComment();
				//f.unlikeComment();
				//f.timeStampPermaLink();
				//f.hidePost();
				//f.UnsubscribePost(); 
		
		
		
		
		
		
		//u.editProfilePic("G:\\Users\\Moortala\\Documents\\GitHub\\SeleniumWebA.omation\\FSQA_Automation\\src\\community\\user\\388135main_PIA11667_full.jpg");
		//u.editCover("G:\\Users\\Moortala\\Documents\\GitHub\\SeleniumWebAutomation\\FSQA_Automation\\src\\community\\user\\388135main_PIA11667_full.jpg");
		//u.profileWebsite();
		//u.twitterNickname();
		//u.editBio("put bio description here");  /** creates new tab, need tab handler
		//u.addExpertise("musical"); /*****************************
		//u.addExpertise("music interpreter");
		//u.addExpertise("music arranger");
		//u.removeExpertise("musical");

		

		//Header h = new Header();
		//h.homeLink();
		
	
		
		
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
		

		//GroupsHome g = new GroupsHome();
		//g.createGroup( date.toString(), date.toString(), "Closed", true, false);
		//g.allGroupsTab();
		//g.allUavatar();//********** needs scroll fix
		//g.ranMPgroup();//**
		//g.ranNewgroup();//**
		//g.ranUserAvatar();//** size issues
		//g.searchGroup("beauty");
		//g.youGroupsTab();
		

		
		
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
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	 @AfterClass
	 public void oneTimeTearDown() {
		
		//BrowserUtil.driver.quit();
	 }
}
