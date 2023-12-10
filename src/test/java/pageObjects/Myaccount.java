package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends Basepage
{
 public Myaccount(WebDriver driver)
 {
	 super(driver);
 }
 
 @FindBy(xpath="//h2[normalize-space()=\"My Account\"]")
 WebElement msgheading;
 
 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
 WebElement lnklogout;
 
 @FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()=\"Logout\"]")
 WebElement drpdown_logout;
 
 
 
 public boolean isMyAccountPageExists()
 {
	 try
	 {
		 return(msgheading.isDisplayed());
	 }catch(Exception e)
	 {
		 return(false);
	 }
 }
 
 public void clicklogout()
 {
	 lnklogout.click();
 }
 
 public void click_drpdownlogout()
 {
	 drpdown_logout.click(); 
 }
 
}
