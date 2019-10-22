
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example02 {
	@Test
	public void testDragAndDrop() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.rachal.yoburaj\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		 driver.navigate().to("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		WebElement pack = driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement price =driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		
		Thread.sleep(2000);
		Actions act1=new Actions(driver);
		act1.clickAndHold(pack).release(price).perform();
		//act1.dragAndDrop(pack1, price).perform();
		
		//Thread.sleep(10000);
		
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),"Drop a package here to check price"));
		
		String label= driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(label);
		
		Assert.assertTrue(label.endsWith("$3999"));
		
		
	}
}
