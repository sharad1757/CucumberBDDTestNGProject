package myHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class TestHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	
	@Before(order = 0)
	public void getProperty() {
		
		// we are using Configuration Reader to Read Project Configurations
		configreader = new ConfigReader();
		prop = configreader.init_prop();
				
		}
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browsername = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browsername);
		driver.get(prop.getProperty("URL"));
	}
		
	@After(order = 0)
	public void quitbrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario sc) {
		
		if(sc.isFailed()) {
			
			String  screenshotname = sc.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			sc.attach(sourcepath, "impage/png", screenshotname);

		}
		
	}
	
	
	
}


