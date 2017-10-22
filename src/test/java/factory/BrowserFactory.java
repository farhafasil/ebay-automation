package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static final String FIREFOX = "Firefox";
	public static final String INTERNET_EXPLORER = "IE";
	public static final String CHROME = "Chrome";
			
	
	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
		
	/*
	 * Factory method for getting web driver instance
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		if(browserName == FIREFOX){
			driver = drivers.get(FIREFOX);
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver", 
						"./src/test/java/drivers/geckodriver.exe");
				
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				drivers.put(FIREFOX, driver);
			}
		} else if(browserName == INTERNET_EXPLORER){
			driver = drivers.get(INTERNET_EXPLORER);
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",
						"./src/test/java/drivers/MicrosoftWebDriver.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				drivers.put(INTERNET_EXPLORER, driver);
			}
		}else if(browserName == CHROME){
			driver = drivers.get(CHROME);
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver",
						"./src/test/java/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				drivers.put(CHROME, driver);
			}
		}else{
			System.out.println(browserName + " not supported!!!");
		}

		
		return driver;
	}
	
}