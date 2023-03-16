package TestCases;

import static commons.Configuration.url;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyName;
import Pages.EmotionPage;
import Pages.HandleMyComplaintPage;
import Pages.HomePage;
import Pages.IndustryPage;
import Pages.Location;
import Pages.LoginDetails;
import Pages.OptionalDetails;
import Pages.OtherComplaintPage;
import Pages.Response;
import Pages.SubmitNewComplaint;
import commons.InitializePropertyFile;
import commons.TestBase;

public class SC_07_OtherComplaintTest extends TestBase {

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());

	}

	@Test
	public void TC_01_OtherComplaint() throws InterruptedException, IOException, AWTException {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC07_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC07_password"));
		login.onClick();
		SubmitNewComplaint submitNewComplaint = new SubmitNewComplaint(driver);
		submitNewComplaint.submitComplaint();
		IndustryPage industryPage = new IndustryPage(driver);
		industryPage.clickOnOtherLogoButton();
		OtherComplaintPage complaint = new OtherComplaintPage(driver);
		complaint.enterDetailsOfComplaint();		
		if(!complaint.isRunningInsideDocker()){
			complaint.fileUpload(InitializePropertyFile.property.getProperty("TC07_file01"));
			complaint.fileUpload(InitializePropertyFile.property.getProperty("TC07_file02"));
		}
		complaint.enterComment();
		complaint.doneChoosing();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectingQuiteHappy();
		Location location = new Location(driver);
		location.inputDetailForAddress_SC07();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails_SC07();
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC07();
		Response response = new Response(driver);
		response.inputResponse_SC06();
		HandleMyComplaintPage handleMyComplaintPage = new HandleMyComplaintPage(driver);
		Assert.assertEquals(handleMyComplaintPage.getMessageAfterSubmitComplaint(), "We've got your submission!",
				"Validating the Submission message");

	}

}
