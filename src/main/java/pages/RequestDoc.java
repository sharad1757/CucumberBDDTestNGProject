package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestDoc {
	
	public WebDriver driver;
	
	private By empReqDocTile = By.xpath("//div[@class='req-type-title' and contains(text(),'Employment & Income Documents')]");
	private By eduReqDocTile = By.xpath("//div[@class='req-type-title' and contains(text(),'Education Documents')]");
	
	
	public RequestDoc(WebDriver driver)
	{
		this.driver = driver;
				
	}
	
	public String getReqDocPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public Boolean validateEmpReqDocTile() {
		
		return driver.findElement(empReqDocTile).isDisplayed();
		
	}
	
	public Boolean validateEduReqDocTile() {
		
		return driver.findElement(eduReqDocTile).isDisplayed();
	}
	

}
