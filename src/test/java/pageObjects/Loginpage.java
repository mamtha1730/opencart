package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage
{
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement btnlogin;
	
	public void setusername(String email1)
	{
		txtemail.sendKeys(email1);
	}
	
	public void setpwd(String pwd1)
	{
		txtpwd.sendKeys(pwd1);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
}
