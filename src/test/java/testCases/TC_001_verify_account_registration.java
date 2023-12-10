package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregistration;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_verify_account_registration extends BaseClass 
{

	@Test(priority=1, groups= {"regression","master"})
	public void verify_account_reg()
	{
		
		logger.info("******starting TC_001 Account regn test******");
		logger.debug("debug logs started...");
		try {
		Homepage hp= new Homepage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on Myaccount link");
		
		hp.clickregister();
		logger.info("Clicked on registration  link");
		
		logger.info("Entering customer");
		Accountregistration ar = new Accountregistration(driver);
		ar.setfirstname(randomstring().toUpperCase());
		ar.setlastname(randomstring().toUpperCase());
		ar.setemail(randomstring()+"@gmail.com");
		ar.settelephone(randomNumber());
		String pwd1= randomAlphanumeric();
		ar.setpassword(pwd1);
		ar.setconfirmpwd(pwd1);
		ar.clickpolicy();
		ar.clickcontinue();
		logger.info("Continue button has been clicked");
		
		logger.info("Validating assertion: ");
		String confirmmsg= ar.getConfirmmsg();
		
		if(confirmmsg .equals("Your  Account Has Been Created!"))
		{
			logger.info("Test is passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test is failed");
			logger.debug("debug logs");
		}
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		logger.info("******Ending of  TC_001 Account regn test******");
		//logger.info("Entering customer");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
	}
	
}
