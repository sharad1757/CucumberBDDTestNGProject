package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/test/resources/appFeature"},
		glue = {"stepdefination"},
		plugin = {"pretty", "html:target/cucmnber-reports", "json:target/cucumber.json"},
		monochrome = true	
		
		)

// to run testcases in parallel mode we need to extend inbuild class called AbstractTestNGCucumberTests from TestNG

public class MyTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
	
	

}
