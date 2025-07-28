package pageObjects;

//import java.time.Duration;

//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
	
public RegisterPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtconfirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement ckdpolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btncontinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstname(String fname)
{
	txtFirstname.sendKeys(fname);
}

public void setLastname(String lname)
{
	txtlastname.sendKeys(lname);
}

public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setTelephone(String tel)
{
	txttelephone.sendKeys(tel);
}
public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setConfirmPassword(String pwd)
{
	txtconfirmpassword.sendKeys(pwd);
}
public void clickPrivacypolicy()
{
	ckdpolicy.click();
}
public void clickContinue()
{
	//sol1
	btncontinue.click();
	
	//sol2
	//btncontinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btncontinue).click().perform();
	
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",btncontinue );
	
	//sol5
	//btncontinue.sendKeys(Keys.RETURN);
	
	//sol6
	//WebDrivewait mywait=new WebDrivewait(driver,Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
	
}
	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}


}
