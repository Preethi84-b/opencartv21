package testClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectclass.Accountregistration;
import pageobjectclass.Homepage;
import testBase.Common;

public class opencartaccountregistration extends Common{
	
	@Test
	public void registration(){
		Homepage h=new Homepage(driver);
		h.Clickaccount();
		h.ClickRegister();
		Accountregistration a=new Accountregistration(driver);
		a.setfirstname(randomstring().toUpperCase());
		a.setlastname(randomstring());
	String randomail=randomstring();
			a.setemail(randomail+"@gmail.com");
		a.settelephone(randomnumber());
		String random =randompassword();
		a.password(random);
		a.conpassword(random);
a.clickagree();
a.clickContinue();
a.confirmation();System.out.println(random);
System.out.println(randomail);

if(a.confirmation().equals("Your Account Has Been Created!")) {
	logger.info("Success");
	Assert.assertTrue(true);
	

}
else {
	logger.error("Registration failed");
	Assert.assertTrue(false);
	
	
}
try{
	Assert.assertTrue(true);}
catch(Exception e) {
		Assert.fail();
		
		}
logger.debug("Successfully registration completed");
	}}



	

