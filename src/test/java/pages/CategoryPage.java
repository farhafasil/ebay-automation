package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage {
	private WebDriver _driver;
	
	@FindBy(id="mainContent")
	private WebElement _mainContent;
	
	
	
	public CategoryPage(WebDriver driver){
		this._driver = driver;
	}
	
	public void goToCategory(String category){
		WebElement categoryLink = this._mainContent.findElement(By.cssSelector("img[alt='"+category+"']"));
		categoryLink.click();
	}
	
	public List<WebElement> getBrands(){
		return this._mainContent.findElements(By.cssSelector("#w5-xCarousel-x-carousel-items li a"));
	}
	
	public void gotoBrand(WebElement brand){
		brand.click();
	}
	
	
	
}
