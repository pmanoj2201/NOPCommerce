package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtloginEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtloginPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement btnLogin;
	
	
	
	public void setemail(String Email)
	{
		txtloginEmail.sendKeys(Email);
	}
	
	public void setpassword(String Password)
	{
		txtloginPassword.sendKeys(Password);
	}
	
	public void clickLoginButton()
	{
		btnLogin.click();
	}

}
