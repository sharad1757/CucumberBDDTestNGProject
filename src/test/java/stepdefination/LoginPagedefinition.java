package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPagedefinition {
	
	
	private WebDriver driver;
	private LoginPage loginpage;
	private static String pagetitle;
	
	@Before
	public void setup()
	{
		driver = new FirefoxDriver();
	}
	
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
		
	@Given("User on login page")
	public void user_on_login_page() {
		
		driver.get("https://crt-emp-blr-wu-ctre-web01.azurewebsites.net/");
		loginpage = new LoginPage(driver);
	    
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    
		pagetitle = loginpage.getLoginPageTitle();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String str) {
		
		Assert.assertTrue(pagetitle.contains(str));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("user enters email as {string}")
	public void user_enters_email_as(String str1) {
		
		loginpage.enterEmail(str1);	
	   
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String pwd1) {
	  
		loginpage.enterPassword(pwd1);
	}

	@When("user clicks on Sign in button")
	public void user_clicks_on_sign_in_button() {
		
		loginpage.clickSignInBtn();
	    
	}

}
