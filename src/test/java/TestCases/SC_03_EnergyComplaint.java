package TestCases;

import Pages.*;
import commons.InitializePropertyFile;
import commons.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import static commons.Configuration.url;

public class SC_03_EnergyComplaint extends TestBase {

	@BeforeMethod
	public void openPage() throws IOException {
		driver.get(url.asString());
	}

	@Test
	public void testHomePage() throws InterruptedException, IOException, AWTException {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginButton();
		LoginDetails login = new LoginDetails(driver);
		login.getUsername(InitializePropertyFile.property.getProperty("TC03_username"));
		login.getPassword(InitializePropertyFile.property.getProperty("TC03_password"));
		login.onClick();

		SubmitNewComplaint submitNewComplaint = new SubmitNewComplaint(driver);
		submitNewComplaint.submitComplaint();

		IndustryPage industryPage = new IndustryPage(driver);
		industryPage.clickOnEnergyLogoButton();

		IssuesPage issuesPage = new IssuesPage(driver);
		issuesPage.selectRelatedIssues_SC03();
		issuesPage.selectIssuesExperienced_SC03();

		EmotionPage emotion = new EmotionPage(driver);
		emotion.beenBetter();

		Location location = new Location(driver);
		location.inputDetailForAddress();

		CompanyName companyName = new CompanyName(driver);
		companyName.enterCompanyDetails("Perth Energy");

		OptionalDetails optionalDetails = new OptionalDetails(driver);
		optionalDetails.enterOptionDetails_SC03();

		Response response = new Response(driver);
		response.inputResponse_SC03();
	}

}
