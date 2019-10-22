

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Example05 {
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	  public void beforeTest() {
		
		String filePath=System.getProperty("user.dir")+"/extent-reports/report.html";
		reporter=new ExtentHtmlReporter(filePath);
		report=new ExtentReports();
		report.attachReporter(reporter);
	  }
	
	@AfterTest
	  public void afterTest() {
		  report.flush();
	  }
	
	 @Test
	  public void testPass() {
		 
		 test=report.createTest("Test Pass");
		 test.log(Status.PASS,"The test is passed");
		 Assert.assertTrue(true);
		 
	  }
	 @Test
	  public void testFail() {
		 test=report.createTest("Test Fail");
		 test.log(Status.FAIL,"The test is Failed");
		 Assert.assertTrue(false);
		 
	  }
	 @Test
	  public void testSkip() {
		 test=report.createTest("Test Skip");
		 test.log(Status.SKIP,"The test is Skipped");
		 throw new SkipException("Skips the test");
		 
	  }
}
