package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	
	
	@Test (groups= {"regression", "master"})
	public void test_AccountRegistration()
	{
		try
		{
			logger.info("started TC_001_AccountRegistration..");
			
			//driver.get("https://demo.opencart.com/");
			
			driver.get(rb.getString("appURL")); // this will get the URL from properties file dynamically
			logger.info("homePage displayed..");
			
			driver.manage().window().maximize();
			
			HomePage hp= new HomePage(driver);
						
			hp.clickRegister();
			logger.info("Register Clicked..");
			
			RegisterAccountPage regpage= new RegisterAccountPage(driver);
			
			regpage.setFirstName("John");
			logger.info("provided first name..");
			
			regpage.setLastName("Wick");
			logger.info("provided last name..");
			
			regpage.setEMail(randomestring()+"@gmail.com");
			logger.info("provided email..");
			
			regpage.setPassword("John#123");
			logger.info("provided password..");
			
			regpage.setConfirmPassword("John#123");
			logger.info("provided confirm password..");
						
						
			regpage.clickRegisterButton();
			logger.info("clicked Register Button..");
			
			String confmsg= regpage.registerSucessMsg();
			if(confmsg.equals("Your registration completed"))
			{
				logger.info("Account Registration success..");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Account Registration Failed..");
				captureScreenShot(driver,"test_AccountRegistration");
				Assert.assertTrue(false);
			}
			
			
		}		
		catch(Exception e)
		{
			logger.info("test failed..");
			Assert.fail();
		}
		
		logger.info("TC_001_AccountRegistration finished..");
	}
	
	

}
