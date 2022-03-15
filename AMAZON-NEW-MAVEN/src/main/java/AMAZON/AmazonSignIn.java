package AMAZON;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignIn {

	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	private WebElement all ;
	
	@FindBy(xpath="//a[text()='Sign In']")
	private WebElement signIn ;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement emailId ;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton ;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password ;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkBox ;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signInSubmit ;
	
	public AmazonSignIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAll()
	{
		all.click();
	}
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public void sendDataOnEmailid(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void sendDataOnPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnCheckBox()
	{
		checkBox.click();
	}
	
	public void clickOnSignInSubmit()
	{
		signInSubmit.click();
	}
	
	
	
}
