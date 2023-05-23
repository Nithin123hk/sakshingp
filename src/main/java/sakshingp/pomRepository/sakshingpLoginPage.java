package sakshingp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sakshingpLoginPage {

	WebDriver driver;
	
	public sakshingpLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(id="username")
	private WebElement usernameTF;
	
	@FindBy(id="password")
	private WebElement passwordTF;
	
	@FindBy(id="log-in")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberMeCheckbox;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement alertMessage;

	public WebElement getAlertMessage() {
		return alertMessage;
	}


	
}
