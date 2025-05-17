package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectclass.Homepage;
import pageobjectclass.Loginpage;
import testBase.Common;

public class Logintestcase extends Common {
@Test
	public void loginAccount() {
	Homepage h=new Homepage(driver);
	logger.info("starting the login ");
	h.Clickaccount();
	h.Clicklogin();
		Loginpage l=new Loginpage(driver);
		try {
		l.mailid(p.getProperty("mail"));
		l.passwd(p.getProperty("password"));
		l.logged();
		l.Confirmsg();
		Assert.assertEquals(l.Confirmsg(), true);
		logger.info("Successfully login ");
	}
	catch(Exception e) {
		System.out.println("fail");
		Assert.fail();
	}
	
	
}}
