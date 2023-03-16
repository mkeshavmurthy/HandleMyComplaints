package TestCases;

import static commons.Configuration.url;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyName;
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
import Pages.SubmitNewComplaint;
import commons.InitializePropertyFile;
import commons.MailHelper;
import commons.TestBase;

public class SC_04_CreditCardComplaintTest extends TestBase {
	
	boolean flag;
	String mailContent;

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());
	}

	@Test(priority = 1)

	public void TC_01_CreditCardComplaint() {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLoginButton();
		LoginPage login = new LoginPage(driver);
		login.clickOnFacebookLogin();
		login.facebookFlowMethod_04();
		
		SubmitNewComplaint complaint = new SubmitNewComplaint(driver);
		complaint.submitComplaint();
		IndustryPage industry = new IndustryPage(driver);
		industry.clickOnBankingLogoButton();
		ProductPage product = new ProductPage(driver);
		product.selectCreditCard();
		IssuesPage issue = new IssuesPage(driver);
		issue.selectRelatedIssues_SC04();
		issue.selectIssuesExperienced_SC04();
		EmotionPage emotion = new EmotionPage(driver);
		emotion.selectingHopingMind();
		Location location = new Location(driver);
		location.inputDetailForAddress_SC04();
		CompanyName company = new CompanyName(driver);
		company.enterCompanyDetails("ANZ");
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC04();
		HandleMyComplaintPage complaintPage = new HandleMyComplaintPage(driver);
		complaintPage.logout();
		flag = true;
		
	}
	
	@Test(priority = 2)
	public void getEmail() throws Exception {

		MailHelper.deleteAllInboxMails(
				InitializePropertyFile.property.getProperty("TC04_username"),
				InitializePropertyFile.property.getProperty("TC04_password"));
		
		if (flag == false) {
			throw new Exception("First step failed");
		}

		mailContent = MailHelper.MailFound(InitializePropertyFile.property.getProperty("TC04_Subject"),
				InitializePropertyFile.property.getProperty("TC04_username"),
				InitializePropertyFile.property.getProperty("TC04_password"));

	}

	@Test(priority = 3)
	public void TC_02_CreditCardComplaint() throws Exception {

		GmailPageObjects gp = new GmailPageObjects(driver);
		LoginPage login = new LoginPage(driver);
		
		System.out.println("++++++++" + MailHelper.fetchResolveComplaintURL(mailContent));
		if (mailContent != null) {

			gp.navigateToResolveComplaint(MailHelper.fetchResolveComplaintURL(mailContent));

		}
		
		login.clickOnFacebookLogin();
		login.facebookFlowMethod_04();
		
		gp.navigateToResolveComplaint(MailHelper.fetchResolveComplaintURL(mailContent));
		gp.completeTheProcess_SC04();
		OptionalDetails options = new OptionalDetails(driver);
		options.enterOptionDetails_SC04_Part2();
		Response response = new Response(driver); 
		response.inputResponse_SC04_part2();
		HandleMyComplaintPage handleMyComplaintPage = new HandleMyComplaintPage(driver);
		Assert.assertEquals(handleMyComplaintPage.getMessageAfterSubmitComplaint(), "We've got your submission!");
		handleMyComplaintPage.clickOnMyProfile(); //
		Assert.assertEquals(handleMyComplaintPage.validateTitleDropdown(), "Ms", "Validating title is same");
	}
}