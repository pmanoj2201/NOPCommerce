package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//h2[normalize-space()='Welcome to our store']")
	WebElement welcomeMsg;
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public String welcomeMessage()
	{
		try
		{
			return welcomeMsg.getText();
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}

}
