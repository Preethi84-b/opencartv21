package pageobjectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Loginpage extends Baseclass {

	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	
	By mail =By.xpath("//*[@name=\"email\"]");
	By password =By.xpath("//*[@name=\"password\"]");
	By loginbutton=By.xpath("//*[@type=\"submit\"]");
	By confirm =By.xpath("//h2[text()=\"My Account\"]");
	By logout =By.xpath("/html/body/div[2]/div/aside/div/a[13]");
	
	
	//Actions
	
	
public void mailid(String username) {
	
	driver.findElement(mail).sendKeys(username);
}
public void passwd(String passid) {
	
	driver.findElement(password).sendKeys(passid);
}

public void logged() {
	
	driver.findElement(loginbutton).click();
}

public boolean  Confirmsg() {
	WebElement g=driver.findElement(confirm);
	
	
		return g.isDisplayed();
		
	
}
public void logggedout() {
	driver.findElement(logout).click();
	
}
}