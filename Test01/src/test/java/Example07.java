import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Example07 {
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.rachal.yoburaj\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-mm");
		String filePath=System.getProperty("user.dir")+"/extent-reports/report.html"+sdf.format(new Date())+".html";
		reporter=new ExtentHtmlReporter(filePath);
		report=new ExtentReports();
		report.attachReporter(reporter);
	  }
	
	@AfterTest
	  public void afterTest() {
		  report.flush();
	  }
	
	
	
	 @BeforeMethod
	  public void beforeMethod(ITestResult result) {
		  test=report.createTest(result.getMethod().getMethodName());
	  }
	 @AfterMethod
	  public void afterMethod(ITestResult result) {
		 if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 test.log(Status.PASS,"The" +result.getMethod().getMethodName()+" passed");
		 }
		 else if(result.getStatus()==ITestResult.FAILURE)
		 {
			 test.log(Status.FAIL,"The" +result.getMethod().getMethodName()+" Failed");
		 }
		 else if(result.getStatus()==ITestResult.SKIP)
		 {
			 test.log(Status.SKIP,"The" +result.getMethod().getMethodName()+" skipped");
		 }
			 
	  }
	
	 @Test
	  public void testPass() {
		 
		 driver.get("http://demowebshop.tricentis.com/login");
		 driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		 driver.findElement(By.id("Password")).sendKeys("abc123");
		 
		 
		 //test=report.createTest("Test Pass");
		 //test.log(Status.PASS,"The test is passed");
		 Assert.assertTrue(true);
		 
	  }
	 @Test
	  public void testFail() {
		 //test=report.createTest("Test Fail");
		 //test.log(Status.FAIL,"The test is Failed");
		 Assert.assertTrue(false);
		 
	  }
	 @Test
	  public void testSkip() {
		 //test=report.createTest("Test Skip");
		 //test.log(Status.SKIP,"The test is Skipped");
		 throw new SkipException("Skips the test");
		 
	  }
}
