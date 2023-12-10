package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Logoutpage;
import pageObjects.Myaccount;
import testBase.BaseClass;

public class TC_004_logout extends BaseClass
{
@Test(groups= {"logout"})	
public void verify_logout() throws InterruptedException
{
	logger.info("******Starting TC_004******");
	Homepage hp=new Homepage(driver);
	hp.clickmyaccount();
	hp.clicklogin();
	Loginpage lp = new Loginpage(driver);
	lp.setusername(p.getProperty("email"));
	lp.setpwd(p.getProperty("password"));
	lp.clicklogin();
	Logoutpage lo=new Logoutpage(driver);
	hp.clickmyaccount();
	Thread.sleep(2000);
	Myaccount my = new Myaccount(driver);
	my.click_drpdownlogout();
	Thread.sleep(2000);
	String text1 = lo.verify_logintxt();
    if(text1 .equals("Login"))
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.assertTrue(false);
    }
	
	
	Thread.sleep(2000);
	lo.clickcontinue();
	
	if(driver.getTitle().equals ("Your Store"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}
}
