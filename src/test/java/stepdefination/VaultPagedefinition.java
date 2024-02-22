package stepdefination;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.VaultPage;

public class VaultPagedefinition {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private VaultPage vaultPage;
	private static String vaultPageTitle;
	
	
	@Given("login with valid credentials")
	public void login_with_valid_credentials(DataTable data) throws InterruptedException {
		List<Map<String, String>> credlist = data.asMaps();
		String UserName = credlist.get(0).get("username");
		String Password = credlist.get(0).get("password");
		
		vaultPage = loginpage.doLogin(UserName, Password);
		
	}
	
	
	
	@When("get the vault page title")
	public void get_the_vault_page_title() {
		
		vaultPageTitle = vaultPage.getVaultPagetitle();
			    
	}

	@Then("vault page title should be {string}")
	public void vault_page_title_should_be(String string) {
		
		Assert.assertTrue(vaultPageTitle.equals(string));
	    
	}
	
	@When("vaildate request doc button is displayed")
	public void vaildate_request_doc_button_is_displayed() {
		
		
		Assert.assertTrue(vaultPage.validateReqDocButton());
		
	}

	@Then("validate upload button is displayed")
	public void validate_upload_button_is_displayed() {
		
		Assert.assertTrue(vaultPage.validateUploadButton());
	    
	}


}
