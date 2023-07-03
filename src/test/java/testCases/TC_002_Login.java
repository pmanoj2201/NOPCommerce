package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test (groups= {"sanity", "master"})
	public void test_Login() throws IOException
	{
		logger.info("started TC_002_Login..");
		driver.get(rb.getString("appURL"));
		
		HomePage hp= new HomePage(driver);
		hp.clickLogin();
		logger.info("login clicked..");
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(rb.getString("email"));
		logger.info("provided email");
		
		lp.setpassword(rb.getString("password"));
		logger.info("provided password");
		
		lp.clickLoginButton();
		logger.info("login clicked");
		
		MyAccountPage mp= new MyAccountPage(driver);
		
		boolean status= mp.isMyAccountPageExists();
		
		try
		{
			
			if(status)
			{
				logger.info("Login test passed..");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login test failed..");
				captureScreenShot(driver,"test_Login");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.info("test failed");
			Assert.fail();
		}
		
		logger.info("TC_002_Login finished..");
		
		
	}

}
