package community;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import community.home.Home;
import community.user.About;
import community.user.Feed;
import community.user.Followers;
import community.user.Following;
import community.user.User;
import utils.BrowserUtil;

public class CommunityTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		Date date = Calendar.getInstance().getTime();
		Login l = new Login();
		BrowserUtil.setBrowser("ch");
		l.authenticate("fullscreentester@gmail.com", "th1nkb1g");
		User u = new User();
		u.fsUser();
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
		BrowserUtil.driver.quit();
	}

}
