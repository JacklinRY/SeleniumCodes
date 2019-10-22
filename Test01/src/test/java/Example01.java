


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class Example01 {
	@Test
	public void testCreditCard()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.rachal.yoburaj\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		 driver.navigate().to("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[13]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div[2]/ul/li[2]/a/span[2]"))).click().perform();;
		act1.click(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[13]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div[2]/ul/li[2]/ul/li[2]/ul/li[2]/a/span")));
	}
	
}
