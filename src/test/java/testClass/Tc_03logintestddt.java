package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectclass.Homepage;
import pageobjectclass.Loginpage;
import testBase.Common;
import utilities.Datadriven;

public class Tc_03logintestddt extends Common {
	@Test(dataProvider="logindata",dataProviderClass=Datadriven.class)
	public void Logindata(String mailid,String password,String exp) {
		
		Homepage h=new Homepage(driver);
		logger.info("starting the login ");
		h.Clickaccount();
		h.Clicklogin();
			Loginpage l=new Loginpage(driver);
			try {
			l.mailid(mailid);
			l.passwd(password);
			l.logged();
			l.Confirmsg();
			Assert.assertEquals(l.Confirmsg(), true);
			logger.info("Successfully login ");
			if(exp.equalsIgnoreCase("valid")) {
				if(l.Confirmsg()==true) {
					l.logggedout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(l.Confirmsg()==true) {
					l.logggedout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("fail");
			Assert.fail();
		}
		
		
	}

}
