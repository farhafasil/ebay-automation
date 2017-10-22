package test;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import mock.SequenceManagerMock;
import mock.UserManagerMock;
import pages.BrandPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class EbayTopFiveBrandsTest {
	private static WebDriver _driver;
	private static LoginPage _loginPage;
	private static HomePage _homePage;
	private static CategoryPage _categoryPage;
	private static BrandPage _brandPage;
	private static ProductPage _productPage;
	private static ShoppingCartPage _cartPage;
	
	
	@BeforeClass
	public static void setup(){
		
		//TODO
		//Get the base url as parameter using System properties
		//Get the browser as parameter using System properties
		//System.getProperty("Browser");
		
		_driver = BrowserFactory.getBrowser(BrowserFactory.CHROME);
		_loginPage = PageFactory.initElements(_driver, LoginPage.class);
		_homePage = PageFactory.initElements(_driver, HomePage.class);
		_categoryPage = PageFactory.initElements(_driver, CategoryPage.class);
		_brandPage = PageFactory.initElements(_driver, BrandPage.class);
		_productPage = PageFactory.initElements(_driver, ProductPage.class);
		_cartPage = PageFactory.initElements(_driver, ShoppingCartPage.class);
	}
	
	@AfterClass
	public static void exit(){
		//_driver.quit();
	}
	
	@Test
	public void loginTopFiveBrandsToCartTest() throws Exception{
		
		UserManagerMock userManager = new UserManagerMock();
		SequenceManagerMock sequenceManager = new SequenceManagerMock();
		JSONObject sequenceFlow = sequenceManager.getSequence("sequence_top_5_brands_in_any_category");
		JSONArray navigation = sequenceFlow.getJSONArray("navigation");
		JSONArray brandsData = sequenceFlow.getJSONArray("brands");
		
		
		_loginPage.open()
			.login(userManager.getValidUser());
		
		//Clear the shopping cart for the logged in user
		_cartPage.open().clearShoppingCart();
		
		_homePage.goToCategory(navigation.getString(0));
		_categoryPage.goToCategory(navigation.getString(1));
		_categoryPage.goToCategory(navigation.getString(2));
		
		
		String currentUrl = _driver.getCurrentUrl();
		
		//loop through the brands
		for(int i =0; i < brandsData.length(); i++){
			if(i > 0){
				_driver.navigate().to(currentUrl);
			}
			List<WebElement> brandViewList = _categoryPage.getBrands();
			JSONObject brandItemModel = brandsData.getJSONObject(i);
			//loop through the brands displayed in the page
			for(int j = 0; j<brandViewList.size(); j++){
				WebElement brandViewItem = brandViewList.get(j);
				if(brandViewItem.getText().equalsIgnoreCase(brandItemModel.getString("name"))){
					_categoryPage.gotoBrand(brandViewItem);
					_brandPage.gotoProductByName(brandItemModel.getString("product"));
					_productPage.addToCart();
					_cartPage.assertProductAdded(brandItemModel.getString("product"));
					break;
				}
			}
		}
		_cartPage.gotoPayment();
		
		
	}
	
	
}
