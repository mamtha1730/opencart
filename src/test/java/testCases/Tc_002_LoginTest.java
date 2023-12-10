package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount;
import testBase.BaseClass;

public class Tc_002_LoginTest extends BaseClass 
{
	
@Test(groups= {"sanity","master"})
public void verify_login()
{
	logger.info("******Starting TC_002 test******");
	logger.debug("capturing appln debug logs");
	try {
	Homepage hp=new Homepage(driver);
	hp.clickmyaccount();
	logger.info("clicked on myaccount link");
	hp.clicklogin();
	logger.info("clicked on login link");
	
	// 
	Loginpage lp= new Loginpage(driver);
	logger.info("entering valid email and pwd");
	lp.setusername(p.getProperty("email"));
	logger.info("entering valid email");
	lp.setpwd(p.getProperty("password"));
	logger.info("entering valid  pwd");
	lp.clicklogin();
	logger.info("Login button has been clicked");
	
	//my account page
	Myaccount my = new Myaccount(driver);
	boolean bool= my.isMyAccountPageExists();
	if(bool == true)
	{
		logger.info("Login Test is passed");
		Assert.assertTrue(true);
		
	}
	else
	{
		logger.error("Login Test is failed");
		Assert.fail();
	}
	logger.info("******Login Test is finished******");
	}catch(Exception e)
	{
		Assert.fail();
		logger.info("login test failed"); 
	}
}

}
