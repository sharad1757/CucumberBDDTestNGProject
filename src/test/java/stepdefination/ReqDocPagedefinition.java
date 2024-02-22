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
import pages.RequestDoc;
import pages.VaultPage;

public class ReqDocPagedefinition {
	
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private VaultPage vaultpage;
	private RequestDoc reqdocpage;
	private static String reqdocpagetitle;
	
	
	
	@Given("login into application and navigate to requestdoc page")
	public void login_into_application_and_navigate_to_requestdoc_page(DataTable data) throws InterruptedException {
		List<Map<String, String>> credlist = data.asMaps();
		String UserName = credlist.get(0).get("username");
		String Password = credlist.get(0).get("password");
		vaultpage = loginpage.doLogin(UserName, Password);
		reqdocpage = vaultpage.clickLeftReqDocLink();
	
	}
	
	@When("get the req doc page title")
	public void get_the_req_doc_page_title(){
		
		reqdocpagetitle = reqdocpage.getReqDocPageTitle();
		
	}
	
	@Then("Request doc page title should be {string}")
	public void Request_doc_page_title_should_be(String str) {
		
		Assert.assertTrue(reqdocpagetitle.equals(str));
		
		
	}
	
	@Then("validate Employment and Income Request tile is present")
	public void validate_Employment_and_Income_Request_tile_is_present() {
		
		Assert.assertTrue(reqdocpage.validateEmpReqDocTile());
		
	}
	
	@Then("validate Education Docs Request tile is present")
	public void validate_Education_Docs_Request_tile_is_present() {
		
		Assert.assertTrue(reqdocpage.validateEduReqDocTile());
		
	}
	
	

}
