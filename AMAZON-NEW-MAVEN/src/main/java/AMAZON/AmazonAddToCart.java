package AMAZON;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAddToCart {


	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBar ;

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement Search  ;
	
	@FindBy(xpath="(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")
	private WebElement mobileImage ;
	
	@FindBy(xpath="//input[@value='Add to Cart']")
	private WebElement addToCart ;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement addToCartSymbol ;
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement delete ;
	
//	@FindBy(xpath="//a[@id='a-autoid-4-announce']")
//	private WebElement signInYourAccount ;
	
	
	
	public AmazonAddToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearchBar()
	{
		searchBar.sendKeys("mobiles under 10000");
	}
	
	public void clickOnSearch ()
	{
		Search.click();
	}
	
	public void clickOnMobileImage()
	{
		mobileImage.click();
	}
	
	public void clickOnAddToCart()
	{
		
		addToCart.click();
	}
	
	public void clickOnAddToCartSymbol()
	{
		addToCartSymbol.click();
	}
	
	public void clickOnDelete()
	{
		delete.click();
	}
	
	

	
	
}
