package TestCases;

import Pages.*;
import commons.InitializePropertyFile;
import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import static commons.Configuration.url;

public class SC_02_MobilePhoneComplaintTest extends TestBase {

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());

	}

	@Test
	public void submitNewComplaintAfterSignUp() throws IOException, AWTException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.clickOnSignUPButton();
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.SignUp(InitializePropertyFile.property.getProperty("TC02_username"));
		AfterSignUpPage aftersignup = new AfterSignUpPage(driver);
		Assert.assertEquals(aftersignup.getMessageInSubmitNewComplaintPage(), "Your accout was successfully created.");
		aftersignup.submitNewComplain();
		IndustryPage industry = new IndustryPage(driver);
		industry.clickOnTelcoLogoButton();
		ProductPage product = new ProductPage(driver);
		product.clickOnMobilePhone();
		CustomerPage customer = new CustomerPage(driver);
		customer.selectPostPaid();
		IssuesPage issues = new IssuesPage(driver);
		issues.selectRelatedIssues_SC02();
		issues.selectIssuesExperienced_SC02();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectDisappointed();
		Location location = new Location(driver);
		location.inputDetailForAddress_SC02();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails_SC02();
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC02();
		Response response = new Response(driver);
		response.inputResponse_SC02();
		HandleMyComplaintPage handleMyComplaintPage = new HandleMyComplaintPage(driver);
		Assert.assertEquals(handleMyComplaintPage.getMessageAfterSubmitComplaint(), "We've got your submission!");
		handleMyComplaintPage.changeOfDate();
		handleMyComplaintPage.viewAndCloseComplaint();
		Assert.assertEquals(handleMyComplaintPage.getValidateNoComplaintMsg(), "You don't have any open complaint.");
	}

}
