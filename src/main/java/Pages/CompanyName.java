package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

import java.util.List;
import java.util.Random;

public class CompanyName extends BasePage {

	public CompanyName(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[name='single_organisation']")
	WebElement company;

	@FindBy(css = "[name='organisation_name']")
	WebElement organisationName;

	@FindBy(css = "[name='organisation_email']")
	WebElement organisationEmail;

	@FindBy(css = "[class='ui-all']")
	List<WebElement> companyNameSelect;

	@FindBy(css = "[class='btn btn-pagenav btn-block organisation-button']")
	WebElement submitButton;

	@FindBy(css = "[for='multiple-orgs']")
	WebElement myissuesrelatetomultiplecompanies_radiobutton;

	@FindBy(css = "[class='form-control select-multiple-org list autocomplete-1']")
	WebElement accounttransferredincorrectly_inputfield;

	@FindBy(css = "[class='form-control select-multiple-org list autocomplete-2']")
	WebElement myinstructionsnotfollowed_inputfield;

	private static final Logger lOGGER = LogManager.getLogger(CompanyName.class.getName());

	public void enterCompanyDetails(String company) {
		company(company);
		wait.forPage();
		selectCompany(company);
		clickOnSubmitButton();
	}

	public void enterCompanyDetails_SC02() {
		clickOnMultipleCompanies();
		wait.forPage();
		InputCompanyName1("Telstra");
		sleep(3000);
		click(driver.findElement(By.xpath("//ul//a[text()='Telstra']")));
		wait.forPage();
		InputCompanyName2("Optus Mobile");
		sleep(3000);
		click(driver.findElement(By.xpath("//ul//a[text()='Optus Mobile']")));
		wait.forPage();
		clickOnSubmitButton();

	}

	public void InputCompanyName1(String text) {
		wait.forElementToBeVisible(accounttransferredincorrectly_inputfield);
		char []a = text.toCharArray();
		for(int i=0; i<a.length; i++) {
			sleep(2000);
			accounttransferredincorrectly_inputfield.sendKeys(String.valueOf(a[i]));
		}
	}

	public void InputCompanyName2(String text) {
		wait.forElementToBeVisible(myinstructionsnotfollowed_inputfield);
		char []a = text.toCharArray();
		for(int i=0; i<a.length; i++) {
			sleep(2000);
			myinstructionsnotfollowed_inputfield.sendKeys(String.valueOf(a[i]));
		}
	}

	public void company(String text) {
		wait.forElementToBeVisible(company);
		char []a = text.toCharArray();
		for(int i=0; i<a.length; i++) {
			sleep(3000);
			company.sendKeys(String.valueOf(a[i]));
		}
		
	}

	public void selectCompanyName() {
		wait.forPage();
		Random rand = new Random();
		int index = rand.nextInt(companyNameSelect.size());
		wait.forElementToBeVisible(companyNameSelect.get(index));
		click(companyNameSelect.get(index));
		wait.forPage();
		lOGGER.info("Selecting " + companyNameSelect.get(index).getText());
	}

	public void clickOnMultipleCompanies() {
		wait.forElementToBeVisible(myissuesrelatetomultiplecompanies_radiobutton);
		click(myissuesrelatetomultiplecompanies_radiobutton);
		lOGGER.info("Clicking on 'My issues relate to multiple companies' radio button");
	}

	public void enterCompanyDetails_SC07() {
		scrollToElementView(organisationName);
		organisationName.sendKeys("Bestbuy");
		scrollToElementView(organisationEmail);
		organisationEmail.sendKeys("complaints@bestbuy.com");
		clickOnSubmitButton();
	}
	
	public void clickOnSubmitButton() {
		wait.forElementToBeVisible(submitButton);
		scrollToElementView(submitButton);
		click(submitButton);
	}
}
