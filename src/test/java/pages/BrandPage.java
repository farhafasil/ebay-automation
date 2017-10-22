package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPage {
	private WebDriver _driver;
	
	@FindBy(css="section.b-listing")
	private WebElement _productListSection;
	
	public BrandPage(WebDriver driver){
		this._driver = driver;
	}
	
	public void gotoProductByName(String name){
		_getProductByName(name).click();
	}
	
	
	private WebElement _getProductByName(String name){
		List<WebElement> products =   this._productListSection.findElements(By.cssSelector("div.s-item__info > a.s-item__link"));
		
		for(int i=0; i<products.size(); i++){
			if(products.get(i).getText().toLowerCase().contains(name.toLowerCase())){
				return products.get(i);
			}
		}
		return null;
	}
	
}
