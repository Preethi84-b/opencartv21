package testBase;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageobjectclass.Accountregistration;
import pageobjectclass.Homepage;


public  class Common {
	public static WebDriver driver ;
	public Logger logger;
	public Properties p;
		
	    
			
	@BeforeTest
	@Parameters({"os","browser"})
    public void setup(String os,String browser) throws IOException {
		FileInputStream f=new FileInputStream("./src//test//resources//data.properties");
		p= new Properties();
		p.load(f);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap =new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WIN10);}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);}
			else {
				System.out.println("invalid operating system ");
			}
			driver=new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"),cap);
			
			switch(browser) {
			case "chrome":cap.setBrowserName("chrome"); break ;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("invalid browser");return;
			
			}
			
		
			
		}
        // Initialize the class-level driver variable
       // System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"));{
		switch(browser) {
		case "chrome" :driver = new ChromeDriver();break ;
		case "edge" :driver = new EdgeDriver();break;
		case "firefox" :driver = new FirefoxDriver();break;
		default:System.out.println("invalid browser ");return;
		}}
         // Assign to class-level driver
      
        

        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
			
			public String randomstring () {
				
				@SuppressWarnings("deprecation")
				String i=RandomStringUtils.randomAlphabetic(8);
					return i;}
		
		public String randomnumber  () {
			
			@SuppressWarnings("deprecation")
			String j=RandomStringUtils.randomNumeric(10);
				return j;}
	public String randompassword() {
			
			@SuppressWarnings("deprecation")
			String k=RandomStringUtils.randomAlphanumeric(7);
				return k;
			
			
			
		}
	public String  CaptureScreenshot(String tname) throws IOException {
		
		
		String timestamp =new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File  Sourcefile=ts.getScreenshotAs(OutputType.FILE);
		String targetfile=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp +".png";
		File target =new File(targetfile);
		Sourcefile.renameTo(target);
		return targetfile;
		}
	}





