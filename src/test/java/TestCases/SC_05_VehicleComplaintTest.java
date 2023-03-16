package TestCases;

import static commons.Configuration.url;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyName;
import Pages.CustomerPage;
import Pages.EmotionPage;
import Pages.GmailPageObjects;
import Pages.HandleMyComplaintPage;
import Pages.HomePage;
import Pages.IndustryPage;
import Pages.IssuesPage;
import Pages.Location;
import Pages.LoginPage;
import Pages.OptionalDetails;
import Pages.ProductPage;
import Pages.Response;
import Pages.VehicleDetailsPage;
import commons.InitializePropertyFile;
import commons.MailHelper;
import commons.TestBase;

public class SC_05_VehicleComplaintTest extends TestBase {

	boolean flag;
	String mailContent;

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());

	}

	@Test(priority = 1)
	public void TC_01_VehicleComplaint() {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginPage login = new LoginPage(driver);
		login.clickOnFacebookLogin();
		login.facebookFlowMethod();
		HandleMyComplaintPage complaint = new HandleMyComplaintPage(driver);
		complaint.clickOnReportProblem();
		IndustryPage industry = new IndustryPage(driver);
		industry.clickOnAutomotiveLogoButton();
		ProductPage product = new ProductPage(driver);
		product.selectnewVehicle();
		CustomerPage customer = new CustomerPage(driver);
		customer.selectManufacturer();
		IssuesPage issue = new IssuesPage(driver);
		issue.selectRelatedIssues_SC05();
		issue.selectIssuesExperienced_SC05();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectingVeryFrustratedEmoji();
		Location location = new Location(driver);
		location.inputDetailForAddress_SC05();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails("Ford");
		VehicleDetailsPage vehicle = new VehicleDetailsPage(driver);
		vehicle.inputVehileDetails_SC05();
		vehicle.inputVehileMenufactureDetails_SC05();
		vehicle.addRepairAttempts_SC05();
		vehicle.addVehicleCost_SC05();
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC05();
		Response response = new Response(driver);
		response.inputResponse_SC05();
		HandleMyComplaintPage handleMyComplaintPage = new HandleMyComplaintPage(driver);
		Assert.assertEquals(handleMyComplaintPage.getMessageAfterSubmitComplaint(), "We've got your submission!");
		handleMyComplaintPage.clickOnMyProfile();
		flag = true;

		/*
		 * Assert.assertEquals(handleMyComplaintPage.validateTitleDropdown(), "Mr" ,
		 * "Validating title is same");
		 * Assert.assertEquals(handleMyComplaintPage.checkBoxsSelected(), true ,
		 * "Validating checkbox are selected");
		 */

	}

	@Test(priority = 2)
	public void getEmail() throws Exception {

		MailHelper.deleteAllInboxMails(InitializePropertyFile.property.getProperty("TC05_username"),
				InitializePropertyFile.property.getProperty("TC05_password"));

		if (flag == false) {
			throw new Exception("First step failed");
		}

		mailContent = MailHelper.MailFound(InitializePropertyFile.property.getProperty("TC05_Subject"),
				InitializePropertyFile.property.getProperty("TC05_gmailUsername"),
				InitializePropertyFile.property.getProperty("TC05_gmailPassword"));

	}

	@Test(priority = 3)
	public void TC_02_VehicleComplaint() throws Exception {

		if (flag == false) {
			throw new Exception("First step failed");
		}

		GmailPageObjects gp = new GmailPageObjects(driver);
		LoginPage lp = new LoginPage(driver);

		if (mailContent != null) {

			gp.navigateToResolveComplaint(MailHelper.fetchUpdateComplaintURL(mailContent));

		}

		lp.clickOnFacebookLogin();
		lp.facebookFlowMethod();
		gp.navigateToResolveComplaint(MailHelper.fetchUpdateComplaintURL(mailContent));
		String refNumber = MailHelper.getReferenceNumber();
		HandleMyComplaintPage complaint = new HandleMyComplaintPage(driver);
		complaint.ResolveComplaint(refNumber, "Escalate");
		Assert.assertEquals(complaint.getSuccessMessage(), "Your complaint has been successfully updated.");

	}
}
