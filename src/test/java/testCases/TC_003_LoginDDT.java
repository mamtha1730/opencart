package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass
{

@Test(dataProvider="Logindata",dataProviderClass=DataProviders.class ,groups= {"functional"})
public void verify_loginDDT(String email1,String pwd1,String exp)
{
	logger.info("******Starting TC_003 ******");
	try
	{
		//Homepage
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.setusername(email1);
		lp.setpwd(pwd1);
		lp.clicklogin();
		
		Myaccount my=new Myaccount(driver);
	    boolean bool = my.isMyAccountPageExists();
	  
	  if(exp.equalsIgnoreCase ("valid"))
	  {
		  if(bool == true)
		  {
			  my.clicklogout();
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  Assert.assertTrue(false);
		  }
	  }
	  if(exp .equalsIgnoreCase("invalid"))
		  if(bool == true)
		  {
			  my.clicklogout();
			  Assert.assertTrue(false);
		  }
		  else
		  {
			  Assert.assertTrue(true);
		  }
	}catch(Exception e)
	{
		Assert.fail("An exeption  occured" + e.getMessage());
	}
	logger.info("******Finished TC_003******");
   }		
}

