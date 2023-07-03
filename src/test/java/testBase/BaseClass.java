package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	
	@BeforeClass (groups= {"regression","sanity", "master"})
	@Parameters({"browser"})
	public void setup(String br)
	{
		// load config.properties file..
		rb= ResourceBundle.getBundle("config");
		
		// for logging
		logger= LogManager.getLogger(this.getClass());
		if (br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("chrome browser launched..");
		}
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("edge browser launched..");
		}
		if (br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("firefox browser launched..");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	public String randomestring()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public int randomeNumber()
	{
		String generatedstring2= RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedstring2));
	}
	
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"\\screenshots\\"+tname+".png");
		FileUtils.copyFile(source, target);
	}

}
