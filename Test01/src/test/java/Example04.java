import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example04 {

	
	@Test
	public void testProduct()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.rachal.yoburaj\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
		WebElement loans=driver.findElement(By.xpath("//li[contains(text(),'Loans')]"));
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", new Object[]{loans});
		
		
		WebElement dropdown2=driver.findElement(By.className("drp2"));
		List<WebElement> list= dropdown2.findElements(By.tagName("li"));
		Assert.assertEquals(18, list.size()-1);
		
		//js.executeScript("alert('helo');alert('Welcome')");
		
		//driver.findElement(By.xpath("//li[contains(text),'Loans')]")).click();
		
		
	}
	
}
