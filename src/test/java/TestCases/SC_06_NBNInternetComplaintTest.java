package TestCases;

import static commons.Configuration.url;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyName;
import Pages.ConnectionPage;
import Pages.CustomerPage;
import Pages.EmotionPage;
import Pages.HandleMyComplaintPage;
import Pages.HomePage;
import Pages.IndustryPage;
import Pages.IssuesPage;
import Pages.Location;
import Pages.LoginDetails;
import Pages.OptionalDetails;
import Pages.ProductPage;
import Pages.Response;
import Pages.SubmitNewComplaint;
import commons.InitializePropertyFile;
import commons.TestBase;

public class SC_06_NBNInternetComplaintTest extends TestBase {

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());

	}

	@Test
	public void TC_01_NBNInternetComplaint() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC06_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC06_password"));
		login.onClick();
		SubmitNewComplaint submitNewComplaint = new SubmitNewComplaint(driver);
		submitNewComplaint.submitComplaint();
		IndustryPage industryPage = new IndustryPage(driver);
		industryPage.clickOnTelcoLogoButton();
		ProductPage product = new ProductPage(driver);
		product.selectInternet();
		CustomerPage customer = new CustomerPage(driver);
		customer.selectNBNSmallBusiness();
		IssuesPage issue = new IssuesPage(driver);
		issue.selectRelatedIssues_SC06();
		issue.selectIssuesExperienced_SC06();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.beenBetter();
		Location location = new Location(driver);
		location.inputDetailForAddress_SC06();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails("Aussie Broadband");
		ConnectionPage connection = new ConnectionPage(driver);
		connection.inputConnectionWithoutDetails();
		connection.inputPromiseDetails();
		connection.inputNBNSetupDetails();
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC06();
		Response response = new Response(driver);
		response.inputResponse_SC06();
		HandleMyComplaintPage handleMyComplaintPage = new HandleMyComplaintPage(driver);
		handleMyComplaintPage.changeOfDate();
		Assert.assertEquals(handleMyComplaintPage.getMessageAfterSubmitComplaint(), "We've got your submission!",
				"Validating the Submission message");

	}

}
