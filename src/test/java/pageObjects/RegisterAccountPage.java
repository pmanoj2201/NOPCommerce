package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage 
{
	WebDriver driver;
	public RegisterAccountPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement btnMale;
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement btnFemale;
	
	@FindBy(name="FirstName")
	WebElement FirstName;
	
	@FindBy(name="LastName")
	WebElement LastName;
	
	@FindBy(name="Email")
	WebElement EMail;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement CompanyName;
	
	@FindBy(id="Newsletter")
	WebElement btnNewsLetterYes;
	
	@FindBy(name="Password")
	WebElement Password;
	

	@FindBy(name="ConfirmPassword")
	WebElement ConfirmPassword;
			
	@FindBy(xpath="//button[@id='register-button']")
	WebElement btnRegister;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement RegisterSucessMsg;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnContinue;
		
	public void setFirstName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		LastName.sendKeys(lname);
	}
	
	public void setEMail(String email)
	{
		EMail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmpassword)
	{
		ConfirmPassword.sendKeys(confirmpassword);
	}
	
	public void clickRegisterButton()
	{
		btnRegister.click();
	}
	
	public String registerSucessMsg()
	{
		try
		{
			return RegisterSucessMsg.getText();
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
		
	

}
