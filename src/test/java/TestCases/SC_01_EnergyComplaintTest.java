package TestCases;

import Pages.*;
import commons.InitializePropertyFile;
import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static commons.Configuration.url;

public class SC_01_EnergyComplaintTest extends TestBase {

	@BeforeMethod
	public void openPage() {
		driver.get(url.asString());
	}

	@Test(priority = 1)
	public void TC_01_EnergyComplaint() throws IOException, InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnGuestUserLogin();
		IndustryPage industry = new IndustryPage(driver);
		industry.clickOnEnergyLogoButton();
		IssuesPage issues = new IssuesPage(driver);
		issues.selectRelatedIssues();
		issues.selectIssuesExperienced();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectingVeryFrustratedEmoji();
		Location location = new Location(driver);
		location.inputDetailForAddress01();
		CompanyName companyName = new CompanyName(driver);
		companyName.enterCompanyDetails("Origin Energy");
		OptionalDetails optionalDetails = new OptionalDetails(driver);
		optionalDetails.enterOptionDetails();
		Response preferResponse = new Response(driver);
		preferResponse.inputResponse();
		HandleMyComplaintPage complaint = new HandleMyComplaintPage(driver);
		Assert.assertEquals(complaint.getMessageAfterSubmitComplaint(), "We've got your submission!",
				"Validating the Submission message");
		complaint.handleComplaintMethodToCreateAccount();

	}

	@Test(priority = 2)
	public void TC_02_EnergyComplaint() throws IOException, InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC01_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC01_password"));
		login.onClick();
		MyComplaint complaint = new MyComplaint(driver);
		complaint.submitMyComplaint();
		complaint.updateMyComplaint();
		Assert.assertEquals(complaint.getTextResolvedComplaint(), "Your complaint has been resolved!",
				"Validation the Resolved complaint message");
		complaint.ViewyourComplainClick();
	}

}
