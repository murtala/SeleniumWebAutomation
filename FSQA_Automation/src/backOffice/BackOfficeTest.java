package backOffice;

import static org.junit.Assert.*;

import org.junit.Test;

public class BackOfficeTest {

	@Test
	public void testAuthenticate() {
		//fail("Not yet implemented");
		BackOffice b = new BackOffice();
		b.openPage();
		b.authenticate("fsqaautomation2@gmail.com","fstester");
	}

}
