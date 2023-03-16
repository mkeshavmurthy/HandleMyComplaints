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
import Pages.LoginDetails;
import Pages.OptionalDetails;
import Pages.ProductPage;
import Pages.Response;
import Pages.SubmitNewComplaint;
import Pages.VehicleDetailsPage;
import commons.InitializePropertyFile;
import commons.MailHelper;
import commons.TestBase;

public class SC_08_VehicleComplaintLoggedIn extends TestBase {

	boolean flag;
	String mailContent;

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());
	}

	@Test(priority = 1)
	public void TC_VehivleComplaintNotResolved() throws Exception {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC08_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC08_password"));
		login.onClick();
		SubmitNewComplaint submitNewComplaint = new SubmitNewComplaint(driver);
		submitNewComplaint.submitComplaint();

		IndustryPage industry = new IndustryPage(driver);
		industry.clickOnAutomotiveLogoButton();
		ProductPage product = new ProductPage(driver);
		product.selectUsedVehicle();
		CustomerPage customer = new CustomerPage(driver);
		customer.selectDealership();

		IssuesPage issue = new IssuesPage(driver);
		issue.selectMechanicalParts();
		issue.doneChoosing();
		issue.selectUnsafeVehicle();
		issue.doneChoosing();

		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectingQuiteHappy();

		Location location = new Location(driver);
		location.inputDetailForAddress_SC08();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails("Value Cars");

		VehicleDetailsPage vehicle = new VehicleDetailsPage(driver);
		vehicle.inputVehileDetails_SC08();
		vehicle.inputVehileMenufactureDetails_SC08();
		vehicle.addRepairAttempts_SC08();
		vehicle.addVehicleCost_SC08();

		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC08();

		Response response = new Response(driver);
		response.title("Mr");
		response.doneChoosing();
		flag = true;
	}

	@Test(priority = 2)
	public void getEmail() throws Exception {

		MailHelper.deleteAllInboxMails(
				InitializePropertyFile.property.getProperty("TC08_username"),
				InitializePropertyFile.property.getProperty("TC08_mail"));
		
		if (flag == false) {
			throw new Exception("First step failed");
		}

		mailContent = MailHelper.MailFound(InitializePropertyFile.property.getProperty("TC08_Subject"),
				InitializePropertyFile.property.getProperty("TC08_username"),
				InitializePropertyFile.property.getProperty("TC08_mail"));

	}

	@Test(priority = 3)
	public void TC_02_VehicleComplaint() throws Exception {
		if (flag == false) {
			throw new Exception("First step failed");
		}

		GmailPageObjects gp = new GmailPageObjects(driver);
		if (mailContent != null) {

			gp.navigateToResolveComplaint(MailHelper.fetchUpdateComplaintURL(mailContent));

		}

		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC08_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC08_password"));
		login.onClick();
		gp.navigateToResolveComplaint(MailHelper.fetchUpdateComplaintURL(mailContent));
		String refNumber = MailHelper.getReferenceNumber();
		HandleMyComplaintPage complaint = new HandleMyComplaintPage(driver);
		complaint.ResolveComplaint(refNumber, "Not Resolved");
		Assert.assertEquals(complaint.getSuccessMessage(), "Your complaint has been successfully updated.");

	}
}
