package sakshingp.pomRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sakshingpHomePage {

     WebDriver driver;
	
	public sakshingpHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="amount")
	private WebElement amountHeader;

	public WebElement getAmountHeader() {
		return amountHeader;
	}
	
	@FindBy(xpath="//tbody/tr/td[@class='text-right bolder nowrap']")
	private List<WebElement> amountValues;

	public List<WebElement> getAmountValues() {
		return amountValues;
	}



}
