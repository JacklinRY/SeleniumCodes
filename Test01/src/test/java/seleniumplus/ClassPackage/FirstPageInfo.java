package seleniumplus.ClassPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import seleniumplus.Page.LoginPageDemoWebShop;
import seleniumplus.Page.RegisterDemoWebShop;
import seleniumplus.Page.WelcomeDemoWebShop;


public class FirstPageInfo {
	WebDriver driver;
	WelcomeDemoWebShop wp;
	RegisterDemoWebShop rp;
	LoginPageDemoWebShop lp;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.rachal.yoburaj\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		wp=PageFactory.initElements(driver, WelcomeDemoWebShop.class);
		rp=PageFactory.initElements(driver, RegisterDemoWebShop.class);
		lp=PageFactory.initElements(driver, LoginPageDemoWebShop.class);
	}
	@AfterTest
	public void afterTest()
	{
		
	}
	@Test(dependsOnMethods = "testLoginLink")
	public void testLoginInfo()
	{
		WebElement logout=lp.loginInfo();
		Assert.assertTrue(logout.isDisplayed());
		logout.click();
	}
	@Test
	public void testLoginLink()
	{
		String url=wp.clickLoginLink();
		Assert.assertTrue(url.contains("login"));
	}
}
