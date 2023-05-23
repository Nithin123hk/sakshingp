package sakshingp.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sakshingp.genericUtility.BaseClass;
import sakshingp.pomRepository.sakshingpHomePage;
import sakshingp.pomRepository.sakshingpLoginPage;

public class TC_HomePage extends BaseClass {
	
	@Test
	public void TC_HP_001() throws IOException
	{  
		sakshingpLoginPage  lp=new sakshingpLoginPage(driver);
	    lp.getUsernameTF().sendKeys(fileutils.readCommonData("username"));
	    logger.info("Entered username");
	    lp.getPasswordTF().sendKeys(fileutils.readCommonData("password"));
	    logger.info("Entered password");
	    lp.getLoginButton().click();
	    logger.info("login to homepage");
	    
		sakshingpHomePage hp=new sakshingpHomePage(driver);
		List<WebElement> allAmountValuesBeforeClick=hp.getAmountValues();
		System.out.println("amount values before clicking amountHeader");
		String avBefore = null;
		for(WebElement amountValuesBeforeClick : allAmountValuesBeforeClick)
		{
		   avBefore= amountValuesBeforeClick.getText();	
		   System.out.println(avBefore);
		}
		
		hp.getAmountHeader().click();
		
		List<WebElement> allAmountValuesAfterClick=hp.getAmountValues();
		System.out.println("amount values after clicking amountHeader");
		String avAfter = null;
		for(WebElement amountValuesAfterClick :allAmountValuesAfterClick)
		{
		   avAfter =amountValuesAfterClick.getText();
			System.out.println(avAfter);
		}
		
		
		if(avBefore.equals(avAfter))
		{
			Assert.assertTrue(false);
		       logger.info("HomePage test  passed");
		}
		else
		{
			Assert.assertTrue(true);
		       logger.info("HomePage test  failed");
			
		}
		
		
	}

}
