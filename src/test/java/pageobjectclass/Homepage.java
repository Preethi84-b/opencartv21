package pageobjectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Baseclass{




	        
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// Initialize @FindBy elements here
	    
		//locators
		//@FindBy(xpath="//span[text()='My Account']") 
		//WebElement  myaccount;
		//@FindBy(xpath="/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]") 
		//WebElement  Register;
		
		By myaccount=By.xpath("//span[normalize-space()='My Account']");
		By Register=By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]");
		By login =By.xpath("//*[text()='Login']");
		//Action
		
		public  void Clickaccount() {
			driver.findElement(myaccount).click();
			}
		public  void ClickRegister() {
			driver.findElement(Register).click();
		}
		public  void Clicklogin() {
			driver.findElement(login).click();
		}
		
		
		
		

	}



