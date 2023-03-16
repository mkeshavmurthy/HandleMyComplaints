package Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;
import commons.InitializePropertyFile;

public class HandleMyComplaintPage extends BasePage {

//After submission of Complaint

	@FindBy(css = "div[class='col-md-12 text-center mar-top-10'] h1")
	static WebElement submitconfirmation_message;

	@FindBy(css = "[id=datepicker] button")
	static WebElement calenderIcon;

	@FindBy(css = "[id=datepicker] input")
	static WebElement calenderInputBox;

	@FindBy(css = "[class='fa fa-calendar']")
	static WebElement calender;

	@FindBy(css = "div[class='datepicker-days'] td[class='day']")
	static List<WebElement> pickupdate;

	@FindBy(css = "#change-date")
	static WebElement submitChangeOfDate;

	@FindBy(css = "[class='dropdown-toggle hamburger-icon']")
	static WebElement menu;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href='/complaints']")
	static WebElement mycomplaints;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href='/complaints/finalise']")
	static WebElement finalisecomplaints;

	// Tell us what we should do with your complaint now by updating the information
	// below

	@FindBy(css = "select[class='form-control']")
	List<WebElement> resolvedComplaint;

	@FindBy(css = "#submit-button")
	static WebElement submit_button;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href*='logout']")
	WebElement logout;

	@FindBy(css = "[class='alert text-center']")
	static WebElement nocomplaintmsg;

	@FindBy(css = "#register-password")
	static WebElement Textbox_HandleComplainPassword;

	@FindBy(css = "#LoginButton")
	static WebElement HandleComplaint_CreateAccount;

	@FindBy(css = "[class='alert alert-success']")

	WebElement successfulsubmission;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href*='new']")
	WebElement reportNewProblem;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href*='account']")
	WebElement myProfile;

	@FindBy(css = "[for='register-allowcontact']")
	WebElement checkbox1;

	@FindBy(css = "[for='allow_share']")
	WebElement checkbox2;

	@FindBy(css = "#title")
	WebElement title;

	private static final Logger lOGGER = LogManager.getLogger(HandleMyComplaintPage.class.getName());

	public HandleMyComplaintPage(WebDriver driver) {
		super(driver);
	}

	public String getMessageAfterSubmitComplaint() {
		lOGGER.info("Validating the message 'We've got your submission!'");
		wait.forElementToBeClickable(submitconfirmation_message);
		return submitconfirmation_message.getText();
	}

	public String getSuccessMessage() {

		lOGGER.info("Validating the message 'Your account was successfully created.'");
		return successfulsubmission.getText();
	}

	public String getValidateNoComplaintMsg() {
		lOGGER.info("Validating the message 'You don't have any open complaint.'");
		return nocomplaintmsg.getText();
	}

	public void changeOfDate() {

		wait.forElementToBeVisible(calenderIcon);
		calenderInputBox.clear();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		String tomorrowDate = formatter.format(tomorrow);
		calenderInputBox.sendKeys(tomorrowDate);
		
		
		actionsEnter();
		lOGGER.info("Clicking on calender");
	}

	public void clickOnMenu() {
		wait.forPage();
		wait.forElementToBeClickable(menu);
		click(menu);
		lOGGER.info("Clicking on the menu button");
	}

	public void clickOnMyComplaints() {
		wait.forElementToBeVisible(mycomplaints);
		click(mycomplaints);
		lOGGER.info("Clicking on the my complaints option");

	}

	public void clickOnFinaliseComplaints() {
		wait.forElementToBeVisible(finalisecomplaints);
		click(finalisecomplaints);
		lOGGER.info("Clicking on the finalise complaints option");
	}

	public void clickOnSubmitButton() {
		wait.forElementToBeVisible(submit_button);
		click(submit_button);
		lOGGER.info("Clicking on the submit button");
	}

	public void viewAndCloseComplaint() throws IOException {

		wait.forPage();
		clickOnMenu();
		wait.forPage();
		clickOnMyComplaints();
		clickOnMenu();
		wait.forPage();
		clickOnFinaliseComplaints();
		wait.forPage();
		resolveComplaintStatus();
		clickOnSubmitButton();
	}

	public void HandleComplaint_PasswordCreation(String value) {

		wait.forElementToBeVisible(Textbox_HandleComplainPassword);
		sendKeys(Textbox_HandleComplainPassword, value);
		lOGGER.info("Entering input into the Password input field");

	}

	public void HandleComplaint_createAccount() {

		wait.forElementToBeVisible(HandleComplaint_CreateAccount);
		click(HandleComplaint_CreateAccount);
		lOGGER.info("Clicking on create account Submit  button");

	}

	public void handleComplaintMethodToCreateAccount() {
		HandleComplaint_PasswordCreation(InitializePropertyFile.property.getProperty("TC01_password"));
		HandleComplaint_createAccount();
	}

	public void logout() {
		clickOnMenu();
		clickOnLogout();
	}

	public void clickOnLogout() {

		wait.forElementToBeVisible(logout);
		click(logout);
		lOGGER.info("logout");
	}

	public void clickOnReportProblem() {
		clickOnMenu();
		wait.forElementToBeVisible(reportNewProblem);
		click(reportNewProblem);

	}

	public void clickOnMyProfile() {
		wait.forPage();
		clickOnMenu();
		wait.forElementToBeVisible(myProfile);
		click(myProfile);
	}

	public boolean checkBoxsSelected() {
		wait.forPage();
		wait.forElementToBeVisible(checkbox1);
		wait.forElementToBeVisible(checkbox2);
		scrollToElementView(checkbox1);
		scrollToElementView(checkbox2);

		if (checkbox1.isSelected() && checkbox2.isSelected())
			return true;
		else
			return false;
	}

	public String validateTitleDropdown() {
		scrollToElementView(title);
		wait.forPage();
		Select titleDropdown = new Select(title);
		return titleDropdown.getFirstSelectedOption().getText();

	}

	public void resolveComplaintStatus() {
		wait.forPage();

		for (WebElement ele : resolvedComplaint) {
			scrollToElementView(ele);
			dropDownMethod(ele, "VisibleText", "Resolved");
		}

	}

	public void ResolveComplaint(String refNumber, String option) {
		wait.forPage();

		System.out.println("***********" + refNumber);
		WebElement ele = driver.findElement(
				By.xpath(String.format("//h2[contains(text(), '%s')]/following-sibling::div//select", refNumber)));
		scrollToElementView(ele);
		dropDownMethod(ele, "VisibleText", option);
		clickOnSubmitButton();
	}

	public void submitResolution() {

		wait.forElementToBeVisible(submitChangeOfDate);
		click(submitChangeOfDate);
		lOGGER.info("Clicking on Submit Resolution button");
	}

	public void calenderIconClick(String strDate) {

		wait.forElementToBeVisible(calenderIcon);
		calenderInputBox.clear();

		calenderInputBox.sendKeys(strDate);
		actionsEnter();
		lOGGER.info("Clicking on calaender");
	}

}
