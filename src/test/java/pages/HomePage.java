package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private WebDriver _driver;
	
	@FindBy(id="mainContent")
	private WebElement _mainContent;
	

	public HomePage(WebDriver driver){
		this._driver = driver;
	}
	
	public void goToCategory(String category){
		WebElement categoryLink = this._mainContent.findElement(By.xpath("//a[contains(text(), '"+ category +"' )]"));
		categoryLink.click();
	}
	
	
	
	
	
}
