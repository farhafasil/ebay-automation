package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import model.UserLoginModel;

public class LoginPage {
	
	
	
	private WebDriver _driver;
	
	@FindBy(id="userid")
	private WebElement _signInEmail;
	@FindBy(id="pass")
	private WebElement _signInPassword;
	@FindBy(id="sgnBt")
	private WebElement _loginButton;
	
	
	
	public LoginPage(WebDriver driver){
		this._driver = driver;
	}
	
	
	public LoginPage open(){
		this._driver.get("https://signin.ebay.com.au/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com.au%2F");
		return this;
	}
	
	/**
	 * @param userCredentials
	 * @return LoginPage
	 */
	public LoginPage login(UserLoginModel userCredentials){
		this._signInEmail.sendKeys(userCredentials.getEmail());
		this._signInPassword.sendKeys(userCredentials.getPassword());
		this._loginButton.click();
		return this;
	}
	
	
}
