package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement lnkLogOut;
	
	@FindBy(xpath="//input[@id='small-searchterms']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	public void clickMyAccountLink()
	{
		lnkMyAccount.click();
	}
	
	public boolean isMyAccountPageExists()
	{
		return lnkMyAccount.isDisplayed();
	}
	
	public void clickLogOutLink()
	{
		lnkLogOut.click();
	}
	
	public void inputSearch(String searchText)
	{
		txtSearch.sendKeys(searchText);
	}
	
	public void clickSearchButton()
	{
		btnSearch.click();
	}

}
