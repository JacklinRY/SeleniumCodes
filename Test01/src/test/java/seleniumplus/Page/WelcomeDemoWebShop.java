package seleniumplus.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomeDemoWebShop {
	
	
	WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Register")
	WebElement registerLink;
	@FindBy(how=How.LINK_TEXT,using="Log in")
	WebElement loginLink;
	
	
	public WelcomeDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
		
	}

	public String clickRegisterLink()
	{
		registerLink.click();
		return driver.getTitle();
	}
	/**
	 * this method returns the url of the page
	 * @return String  - Current URL of the Page
	 */
	public String clickLoginLink()
	{
		loginLink.click();
		return driver.getCurrentUrl();
	}

}
