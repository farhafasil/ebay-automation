package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	private WebDriver _driver;
	
	@FindBy(id="isCartBtn_btn")
	private WebElement _addToCartButton;
	
	public ProductPage(WebDriver driver){
		this._driver = driver;
	}
	
	public void addToCart(){
		this._addToCartButton.click();
	}
	
}
