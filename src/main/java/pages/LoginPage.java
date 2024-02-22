package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	public WebDriver driver;

	//1. By Locators 

	private By emailId = By.id("signInEmailId"); // signInEmailId
	private By password = By.id("signInPassword");
	private By signInbtn = By.id("btnSignIn");
	private By forgotpwdlink = By.linkText("Forgot Password?");

	//2. Constructor 

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	//3. Page Actions/methods

	public String getLoginPageTitle()
	{
		return driver.getTitle();

	}

	public boolean isForgotPwdLinkExist() {

		return driver.findElement(forgotpwdlink).isDisplayed();
	}

	public void enterEmail(String email) {

		driver.findElement(emailId).sendKeys(email);

	}
	public void enterPassword(String pwd) {

		driver.findElement(password).sendKeys(pwd);

	}
	public void clickSignInBtn() {

		driver.findElement(signInbtn).click();

	}
	
	public VaultPage doLogin(String uname, String pass) throws InterruptedException {
		
		driver.findElement(emailId).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signInbtn).click();
		Thread.sleep(10000);
		
		return new VaultPage(driver);
		
		
	}
	

}
