
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtiltity {
	
	public static WebDriver getDriverInstance(String browser)
	{
		if(browser.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\j.rachal.yoburaj\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.contentEquals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src/test/resources/Drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if(browser.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
			return new FirefoxDriver();
		}
		else
		{
			return null;
		}
	}

}