package stepdefination;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPagedefinition{
	
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String pagetitle;
	
	
	/*
	 * @Given("User on login page") public void user_on_login_page() {
	 * 
	 * // DriverFactory.getDriver().get(
	 * "https://crt-emp-blr-wu-ctre-web01.azurewebsites.net/");
	 * System.out.println("User on Login Page");
	 * 
	 * }
	 */

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
	public void user_clicks_on_sign_in_button() throws InterruptedException {
		loginpage.clickSignInBtn();
		Thread.sleep(5000);
	    
	}
	
	
	

}
