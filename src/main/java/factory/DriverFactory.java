package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	/* we keep our WebDriver reference static to make it thread-safe. 
	 * But the problem occurs when we try to achieve parallel execution of our tests within the framework. 
	 * Every thread you create to parallelize your tests tries to overwrite the WebDriver reference since 
	 * there could be only one instance of static WebDriver reference.

	 * To overcome this problem, we can take help from the ThreadLocal class of Java. 
	 * Wondering what is ThreadLocal? Simply put, it enables you to create a generic/ThreadLocal type of 
	 * object which can only be read and written (via its get and set method) by the same thread, so if 
	 * two threads are trying to read and write a ThreadLocal object concurrently, 
	 * one thread would not see the modification of the ThreadLocal object done by the other thread, thus, 
	 * making the thread-local object thread-safe.

     * A typical thread-local object is made private static and its class provides initialValue, get, set, and remove methods. 
	
	*/
	
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
					
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please give the correct browser name");
		}
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
		
			
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();	
	}

}
