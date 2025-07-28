package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login") //Login link added in step5
	WebElement lnkLogin;
	
	public  void clickMyAccount()
	{
		lnkAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
		}

}
