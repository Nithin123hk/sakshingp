package sakshingp.testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import sakshingp.genericUtility.BaseClass;
import sakshingp.pomRepository.sakshingpLoginPage;

public class TC_LoginPage extends BaseClass{
	
	 
	 
    @Test(priority = 1)
	public void TC_LP_001() throws IOException
	{    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
		lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
		logger.info("Entered username");
		lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
		logger.info("Entered password");
		lp.getLoginButton().click();
		
		if(driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/home.html"))
				{
			       Assert.assertTrue(true);
			       logger.info("login test  passed");
				}
		else
		{   ScreenShot(driver, "TC_LP_001");
			Assert.assertTrue(false);
			logger.info("login test  failed");
			
		}
	    
	}
	
    @Test(priority = 2)
    public void TC_LP_002()
    {    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
    	logger.info("not entered anything on username and password textfields");
    	lp.getLoginButton().click();
    	if(driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/home.html"))
		{
	       Assert.assertTrue(false);
	       logger.info("login test  passed");
		}
        else
        {
	       Assert.assertTrue(true);
	       logger.info("login test  failed");
        }
    	
    }
    
    @Test(priority = 3)
    public void TC_LP_003() throws IOException 
	{    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
		lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
		logger.info("Entered username");
		lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
		logger.info("Entered password");
		lp.getLoginButton().sendKeys(Keys.ENTER);;
		
		if(driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/home.html"))
				{
			       Assert.assertTrue(true);
			       logger.info("login test  passed");
				}
		else
		{
			Assert.assertTrue(false);
			logger.info("login test  failed");
		}
	    
	}
    
    @Test(priority = 4)
    public void TC_LP_004() throws IOException 
	{    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
		String placeholderTextUN=lp.getUsernameTF().getAttribute("placeholder");
		if (placeholderTextUN.equals("Enter your username"))
		{
			 Assert.assertTrue(true);
			 logger.info("succefully verified that username text field in the loginpage have placeholder text");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("succefully verified that username text field in the loginpage don't have placeholder text");
		}
		 
	}
    
    @Test(priority = 5)
    public void TC_LP_005() throws IOException 
  	{    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
  		String placeholderTextPWD=lp.getPasswordTF().getAttribute("placeholder");
  		if (placeholderTextPWD.equals("Enter your password"))
  		{
  			 Assert.assertTrue(true);
  			 logger.info("succefully verified that password text field in the loginpage have placeholder text");
  		}
  		else
  		{
  			Assert.assertTrue(false);
  			logger.info("succefully verified that password text field in the loginpage don't have placeholder text");
  		}
  		 
  	}
    
    @Test (priority = 6)
    public void TC_LP_006() throws IOException
	{    sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
		lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
		logger.info("Entered username");
		lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
		logger.info("Entered password");
		lp.getLoginButton().click();
		driver.navigate().back();
		
		if(driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/login.html"))
				{
			       Assert.assertTrue(true);
			       logger.info("login test  passed");
				}
		else
		{
			Assert.assertTrue(false);
			logger.info("login test  failed");
		}
	    
	}
    
    @Test(priority = 7)
    public void TC_LP_007() throws IOException
	{   sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
		lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
		logger.info("Entered username");
		lp.getLoginButton().click();
		String tagText=lp.getAlertMessage().getText();
		if (tagText.equals("Password must be present"))
		{
			 Assert.assertTrue(true);
		       logger.info("alertMessage test  passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("alertMessage test  failed");

		}
	}	
	
    @Test (priority = 8)
    public void TC_LP_008() throws IOException
  	{   sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
  		lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
  		logger.info("Entered Password");
  		lp.getLoginButton().click();
  		String tagText=lp.getAlertMessage().getText();
  		if (tagText.equals("Username must be present"))
  		{
  			 Assert.assertTrue(true);
  		     logger.info("alertMessage test  passed");
  		}
  		else
  		{
  			Assert.assertTrue(false);
  			logger.info("alertMessage test  failed");

  		}
  	}
    
    @Test (priority = 9)
    public void TC_LP_009() throws IOException
  	{   sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
  	    lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
	    logger.info("Entered username");
  		lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
  		logger.info("Entered Password");
  		lp.getRememberMeCheckbox().click();
  		if(lp.getRememberMeCheckbox().isSelected())
  		{
  			Assert.assertTrue(true);
		    logger.info("RememberMeCheckbox test  passed");
  		}
  		else
  		{
  			Assert.assertTrue(false);
  			logger.info(" RememberMeCheckbox test  failed");
  		}
  	} 
    
	@Test	(priority = 10)
    public void TC_LP_010() throws IOException
  	{   sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
  	   String placeholderValue = lp.getUsernameTF().getAttribute("placeholder");
  	   lp.getUsernameTF().sendKeys("A");
  	   String usernameValue=lp.getUsernameTF().getAttribute("value");
       if(usernameValue.length()==1 && !usernameValue.equals(placeholderValue))
       {
    	   Assert.assertTrue(true);
		    logger.info("placeholder text is disaapeared &  test  passed");
       }
       else
       {
    	   Assert.assertTrue(false);
		    logger.info("placeholder text is  not disaapeared &  test failed");
       }
  	}
    
	@Test (priority = 11)
	 public void TC_LP_011() throws IOException
	  	{   sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
	  	   String placeholderValue = lp.getPasswordTF().getAttribute("placeholder");
	  	   lp.getPasswordTF().sendKeys("n");
	  	   String PasswordValue=lp.getPasswordTF().getAttribute("value");
	       if(PasswordValue.length()==1 && !PasswordValue.equals(placeholderValue))
	       {
	    	   Assert.assertTrue(true);
			    logger.info("placeholder text is disaapeared &  test  passed");
	       }
	       else
	       {
	    	   Assert.assertTrue(false);
			    logger.info("placeholder text is  not disaapeared &  test failed");
	       }
	  	}
}
