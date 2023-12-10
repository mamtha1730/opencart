package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage
{

	public WebDriver driver;
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkregister;
	
	@FindBy(linkText="Login")
	WebElement lnklogin;
	
	public void clickmyaccount()
	{
		lnkmyaccount.click();	
	}
	
	public void clickregister()
	{
		lnkregister.click();
	}
	
	public void clicklogin()
	{
		lnklogin.click();
	}
}
