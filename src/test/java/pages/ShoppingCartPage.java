package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {
	private WebDriver _driver;
	
	@FindBy(id="ptcBtnRight")
	private WebElement _proceedToPaymentBtn;
	
	public ShoppingCartPage(WebDriver driver){
		this._driver = driver;
	}
	
	public void assertProductAdded(String name){
		//TODO
		//Checks if the product got added 
	}
	
	public ShoppingCartPage open(){
		//TODO
		//Take the user to shopping cart page
		return this;
	}
	
	
	public void gotoPayment(){
		this._proceedToPaymentBtn.click();	
	}
	
	public void clearShoppingCart(){
		//TODO
		//Remove all shopping cart items for the logged in users account
	}
	
	
}
