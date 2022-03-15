package AMAZON;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignOut {

	@FindBy(xpath="//a[@id='nav-link-accountList']")
	private WebElement accountsAndLIst;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	private Actions actions;
	
	
	public AmazonSignOut(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		actions = new Actions(driver);
	}
	
	public void moveOnAccountsAndList ()
	{
		actions.moveToElement(accountsAndLIst).perform();
	}
	
	public void clickOnSignOut ()
	{
		signOut.click();
	}
	
	
}
