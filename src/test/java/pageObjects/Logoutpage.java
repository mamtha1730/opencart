package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logoutpage extends Basepage
{

	public Logoutpage(WebDriver driver)
	 {
		 super(driver);
	 }
	
	@FindBy(xpath="//a[normalize-space()=\"Continue\"]")
	WebElement btn_continue;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()=\"Login\"]")
	WebElement txt_login;
	
	public String verify_logintxt() throws InterruptedException
	{
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		String txt = txt_login.getText();
		Thread.sleep(2000);
		return txt;
	}
	public void clickcontinue()
	{
		btn_continue.click();
	}
	
		

}
