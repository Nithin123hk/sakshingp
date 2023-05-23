package sakshingp.genericUtility;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.builder.api.PropertyComponentBuilder;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import sakshingp.pomRepository.sakshingpLoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public FileUtility fileutils=new FileUtility();
   public static Logger logger;
   
	@BeforeMethod
	 public void configBefore() throws IOException
     {
	       String browserName=fileutils.readCommonData("browser");
	       if(browserName.equals("chrome"))
	       {
		      driver=new ChromeDriver();
	       }
	       else if(browserName.equals("edge"))
	       {
	    	   driver=new EdgeDriver();
	       }
	       else if(browserName.equals("firefox"))
	       {
	    	   driver=new FirefoxDriver();
	       }
	       logger=(Logger) LogManager.getLogger(BaseClass.class);
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	       driver.get(fileutils.readCommonData("url"));
	       logger.info( "url is opened");
     }
	 
	@AfterMethod
	 public void configAfter()
	 {
		 driver.manage().window().minimize();
		 driver.quit();
	 }
	
	public void ScreenShot(WebDriver driver,String tname) throws IOException
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp= LocalDateTime.now().toString().replace(':', '-');
        File destFile=new File(System.getProperty("user.dir")+"/screenshots/"+timeStamp+".png" );
        FileUtils.copyFile(screenshotFile, destFile);
	}
	
}
