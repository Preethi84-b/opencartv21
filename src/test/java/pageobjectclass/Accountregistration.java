package pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistration extends Baseclass{

	
	public Accountregistration(WebDriver driver) {
		super(driver);
		
	}
	//locators
		@FindBy(xpath="//*[@name='username']") WebElement  username;
		@FindBy(xpath="//*[@name='firstname']") WebElement  firstname;
		@FindBy(xpath="//*[@name='lastname']") WebElement  lastname;
		@FindBy(xpath="//*[@name='email']") WebElement  email;
		@FindBy(xpath="//*[@name='telephone']") WebElement tele;
		@FindBy(xpath="//*[@name='password']") WebElement  password;
		@FindBy(xpath="//*[@name='confirm']") WebElement  conpassword;
		@FindBy(xpath="//*[@id='content']/h1") WebElement conmsg;
		@FindBy(xpath="//*[@name='agree']") WebElement agree;
		@FindBy(xpath="//*[@value='Continue']") WebElement Continue;
		
		
		//action methods 
		
		
		public void setusername(String user) {
	
	username.sendKeys(user);
	}
		
		public void setfirstname(String first) {
			firstname.sendKeys(first);
			}
public void setlastname(String last) {
			
			lastname.sendKeys(last);
			}
public void setemail (String mailid) {
	
	email.sendKeys(mailid);
	}

public void settelephone (String  phonenum) {
	
	
	
	
	tele.sendKeys(phonenum);
}

public void password (String passid) {
	
	password.sendKeys(passid);
	}

public void conpassword (String conpassid) {
	
	conpassword.sendKeys(conpassid);
	}

	


public void clickagree() {
	
	agree.click();
}

public void clickContinue() {
	
	Continue.click();
}
public String  confirmation () {
	try {
	return conmsg.getText();}
	
	catch(Exception e) {
		
		return e.getMessage();}
		
	}
}
	
	
	
	
	


