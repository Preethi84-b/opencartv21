package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport implements ITestListener {
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String  repname;
	public void onStart(ITestContext testcontext) {
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		repname="testreport"+timestamp+".html";
		sparkreporter =new ExtentSparkReporter(".\\reports\\"+repname);
		
		sparkreporter.config().setDocumentTitle("Opencart Automation reports");
		sparkreporter.config().setReportName("opencart functional testing ");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","Customers");
		extent.setSystemInfo("User name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		String os=testcontext.getCurrentXmlTest().getParameter("os");
		extent .setSystemInfo("operating system", os);
		String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		extent .setSystemInfo("browser", browser);
		List<String> groups=testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty()) {
			extent.setSystemInfo("groups",groups.toString());
		}
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+ "testcasespassed");
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+ "testcasesfailed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try {
			String imgpath=new Common().CaptureScreenshot(result.getName());
	   test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+ "testcaseskipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext testcontext) {
		extent.flush();
		String pathofExtentreport=System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentreport=new File(pathofExtentreport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
	
	
	

}
