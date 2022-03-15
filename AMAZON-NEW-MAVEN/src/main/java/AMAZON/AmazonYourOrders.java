package AMAZON;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonYourOrders {

	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountsAndList;
	
	  @FindBy(xpath="//span[text()='Your Orders']")
   	private WebElement yourOrders ;
	  
	  @FindBy(xpath="//span[@class='item']")
		private WebElement orders  ;
	  
	  
	  @FindBy(xpath="(//a[@class='a-link-normal item'])[1]")
		private WebElement buyAgain ;

	  @FindBy(xpath="(//input[@name='submit.addToCart'])[1]")
		private WebElement addToCart;
	  
	  @FindBy(xpath="//a[text()='Not Yet Shipped']")
		private WebElement notYetShipped ;
	  
	  @FindBy(xpath="(//span[@class='a-list-item'])[5]")
		private WebElement cancelOrders ;
	  
//	  @FindBy(xpath="")
//		private WebElement  ;
//	  
//	  @FindBy(xpath="")
//		private WebElement  ;
//	  
//	  @FindBy(xpath="")
//		private WebElement ;
	  
	  private WebDriver driver;
	  private Actions actions;
	  
	  
	  public AmazonYourOrders(WebDriver driver)                    ///----------------------------------
	  {
		  PageFactory.initElements(driver, this);
		  this.driver=driver;
		  actions = new Actions(driver);
	  }
	  
	  public void moveOnAccountAndList  ()
	  {
		  actions.moveToElement(accountsAndList).perform();
	  }
	  
	  public void  clickOnYourOrders ()
	  {
		  yourOrders.click();
	  }
	  
	  public void clickOnOrders  ()
	  {
		  orders.click();
	  }
	 
	  public void  clickOnBuyAgain ()
	  {
		  buyAgain.click();
	  }
	  
	  public void clickOnAddToCart ()
	  {
	    addToCart.click();
	  }
	  
	  public void clickOnNotYetShipped ()
	  {
		  notYetShipped.click();
	  }
	  
	  public void  clickOnCancelOrders ()
	  {
		  cancelOrders.click();
	  }
	  
//	  public void   ()
//	  {
//		  
//	  }
//	  
	  
	
}
