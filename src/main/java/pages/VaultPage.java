package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VaultPage {
	
	private WebDriver driver;
	
	//1. Locators 
	
	//private By requestDocBtn = By.id("btnRequestNewDocument");
	private By uploadfileBtn = By.id("btnUploadFiles");
	private By reqdoclink = By.id("btnRequestNewDocument");
	
	
	
	//2. Constructor 
	
	public VaultPage(WebDriver driver) {
		this.driver = driver;
		
	}

	//3. Methods 
	
	public String getVaultPagetitle(){
		
		return driver.getTitle();
	}
	
	public Boolean validateReqDocButton() {
		
		return driver.findElement(reqdoclink).isDisplayed();
	}
	
	public Boolean validateUploadButton() {
		
		return driver.findElement(uploadfileBtn).isDisplayed();
	}
	
	public RequestDoc clickLeftReqDocLink() throws InterruptedException {
		
		driver.findElement(reqdoclink).click();
		Thread.sleep(10000);
		return new RequestDoc(driver);
		
	}
	
	
}
