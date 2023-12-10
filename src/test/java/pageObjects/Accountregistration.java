package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistration extends Basepage
{

	public WebDriver driver;
	public Accountregistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void settelephone(String  tele)
	{
		txttelephone.sendKeys(tele);
	}
	
	public void setpassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setconfirmpwd(String confirmpwd)
	{
		txtconfirmpwd.sendKeys(confirmpwd);
	}
	
	public void clickpolicy()
	{
		chkpolicy.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public String getConfirmmsg()
	{
		try
		{
			return (msgconfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
