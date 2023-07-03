package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_Logout extends BaseClass
{
	@Test (groups= {"regression", "master"})
	public void test_Logout() throws IOException
	{
		try
		{
			logger.info("started TC_003_Logout..");
			driver.get(rb.getString("appURL"));
			
			HomePage hp= new HomePage(driver);
			hp.clickLogin();
			logger.info("login link clicked..");
			
			
			
			LoginPage lp=new LoginPage(driver);
			lp.setemail(rb.getString("email"));
			logger.info("provided email");
			
			lp.setpassword(rb.getString("password"));
			logger.info("provided password");
			
			lp.clickLoginButton();
			logger.info("login button clicked..");
			
			MyAccountPage mp= new MyAccountPage(driver);			
			mp.inputSearch("Books");			
			mp.clickSearchButton();
			logger.info("search button clicked..");
			mp.clickLogOutLink();
			logger.info("logout link clicked..");
			
			
			String welmsg= hp.welcomeMessage();
			if(welmsg.equals("Welcome to our store"))
			{
				logger.info("Logout after login success..");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("logout Failed..");
				captureScreenShot(driver,"test_Logout");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.info("test failed..");
			Assert.fail();
		}
		
		logger.info("TC_003_Logout finished..");
	}

}
