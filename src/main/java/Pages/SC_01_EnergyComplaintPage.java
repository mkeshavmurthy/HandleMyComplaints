package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class SC_01_EnergyComplaintPage extends BasePage {

	// WebElements

	@FindBy(xpath = "//a[@class='btn btn-link guest-link']")
	static WebElement guestLogin;

	@FindBy(xpath = "//i[@class='fa fa-lightbulb-o']")
	static WebElement energyLogo;

	@FindBy(xpath = "//label[@for='Bill / Account']")
	static WebElement radio_bill_Account;

	@FindBy(xpath = "//label[@for='Paying a bill']")
	static WebElement radio_Paying_A_Bill;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-block']")
	static WebElement issuesRelated_SubmitButton;

	@FindBy(xpath = "//div/label[@for='Bill seems too high / incorrect']")
	static WebElement radio_bill_seems_too_high;

	@FindBy(xpath = "//div/label[@for='Customer service']")
	static WebElement radio_customerService;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-block']")
	static WebElement WhatAreTheIssues_SubmitButton;

	// how are you feeling
	@FindBy(xpath = "//label[@for='Very frustrated']")
	static WebElement VeryFrusratedEmoji;

	// where is this Happening

	@FindBy(xpath = "//input[@id='address1']")
	static WebElement AddressLine1;

	@FindBy(xpath = "//input[@id='address2']")
	static WebElement AddressLine2;

	@FindBy(xpath = "//input[@id='city']")
	static WebElement townOrCity;

	@FindBy(xpath = "//Select[@id='state']")
	static WebElement State;

	@FindBy(xpath = "//input[@id='postcode']")
	static WebElement postcode;

	@FindBy(xpath = "//*[@id='country']")
	static WebElement Country;

	@FindBy(xpath = "//div/button[@id='submit-btn']")
	static WebElement submitNext;

	// Which company
	@FindBy(xpath = "//input[@class='form-control select-org list autocomplete-0']")
	static WebElement Textbox_EnterOrganisation;

	@FindBy(xpath = "//a[starts-with(text(),'Origin Energy')]")
	static WebElement Origin_Energy;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-block organisation-button']")
	static WebElement whichCountry_SubmitButon;

	// Optional details
	@FindBy(xpath = "//select[@id='impact-field']")
	static WebElement dropDown_EffectOfIssue;

	@FindBy(xpath = "//select[@class='form-control' and @name='outcome1']")
	static WebElement dropDown_ResolutionIWant;

	@FindBy(xpath = "//select[@id='outcome-field2']")
	static WebElement dropDown_2ndPriority;

	@FindBy(xpath = "//select[@id='outcome-field3']")
	static WebElement dropDown_3rdPriority;

	@FindBy(xpath = "//select[@id='contactattempts-field']")
	static WebElement dropDown_ContactAttempt;

	@FindBy(xpath = "//select[@id='experience-field2']")
	static WebElement dropDown_YourExperience;

	@FindBy(xpath = "//input[@id='referencenumber-field']")
	static WebElement Textbox_AddRefrence;

	@FindBy(xpath = "//input[@id='accountnumber-field']")
	static WebElement Textbox_AccountNumber;

	@FindBy(xpath = "//textarea[@id='comments-field']")
	static WebElement Textbox_DescriptionBox;

	@FindBy(xpath = "//button[@id='btn-next']")
	static WebElement optionalDetails_SubmitButton;

	// Prefer a response

	@FindBy(xpath = "//select[@id='contact-title']")
	static WebElement user_Title;

	@FindBy(xpath = "//input[@id='contact-firstname']")
	static WebElement user_FirstName;

	@FindBy(xpath = "//input[@id='contact-lastname']")
	static WebElement user_LastName;

	@FindBy(xpath = "//input[@id='contact-email']")
	static WebElement user_Email;

	@FindBy(xpath = "//input[@id='allow_share']//parent::div")
	static WebElement ResponseCheckbox2;

	@FindBy(xpath = "//input[@id='contact-me']//parent::div")
	static WebElement ResponseCheckbox3;

	@FindBy(xpath = "//button[@id='submit-step']")
	static WebElement ResponseSubmit;

	// handle my complain password and account

	@FindBy(xpath = "//input[@id='register-password']")
	static WebElement Textbox_HandleComplainPassword;

	@FindBy(xpath = "//button[@id='LoginButton']")
	static WebElement HandleComplaint_CreateAccount;

	////////////////////////////////////// test2elements\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@FindBy(xpath = "//a[@class='btn btn-default btn-block']")
	static WebElement LoginButton;

	@FindBy(xpath = "//input[@id='register-email']")
	static WebElement enterEmail;

	@FindBy(xpath = "//input[@id='register-password']")
	static WebElement enterPassword;

	@FindBy(xpath = "//button[@id='LoginButton']")
	static WebElement LoginAgain;

	@FindBy(xpath = "//a[@class='btn btn-default btn-block']")
	static WebElement myComplain;

	@FindBy(xpath = "//span[@class='clearfix bluer-title']//parent::div")
	static WebElement SumittedComplaints;

	@FindBy(xpath = "//textarea[@id='comments-field']")
	static WebElement SumittedComplaint_Update;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	static WebElement addUpdate;

//	@FindBy(xpath = "//h4[text()='Complaint Updates']//following-sibling::div//span[@class=\"bluer\"]")
//	static WebElement ComplaintUpdateDescription;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-save btn-block btn-topspace btn-mark']")
	static WebElement markedResolved;

	@FindBy(xpath = "//i[@class='fa fa-calendar']//parent::button")
	static WebElement calenderIcon;

	@FindBy(xpath = "//td[@class='today day']")
	static WebElement todayDate;

	@FindBy(xpath = "//label[@for='rating-5']")
	static WebElement fiveStarRating;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-save btn-block btn-topspace']")
	static WebElement SubmitResolution;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-block']")
	static WebElement viewYourComplaints;

	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	// Class Constructor
	public SC_01_EnergyComplaintPage(WebDriver driver) {

		super(driver);

	}

	// Class Functions
	public static void clickOnGuestUserLogin() {
		wait.forElementToBeVisible(guestLogin);
		click(guestLogin);
		lOGGER.info("Clicking on use as our guest");
	}

	public static void clickOnEnergyLogoButton() {

		wait.forElementToBeVisible(energyLogo);
		click(energyLogo);
		lOGGER.info("Clicking on the energy icon");
	}

	public static void RadiobuttonCheck_BillAccount() {

		wait.forElementToBeVisible(radio_bill_Account);
		click(radio_bill_Account);
		lOGGER.info("checking radio button bill/account");
	}

	public static void RadiobuttonCheck_PayingABill() {

		wait.forElementToBeVisible(radio_Paying_A_Bill);
		click(radio_Paying_A_Bill);
		lOGGER.info("Checking radio button Paying a bill");
	}

	public static void clickingOnSubmitButton() {

		wait.forElementToBeVisible(issuesRelated_SubmitButton);
		click(issuesRelated_SubmitButton);
		lOGGER.info("Clicking on next i am done");

	}

	public static void RadiobuttonCheck_Bill_Seems_Too_High() {

		wait.forElementToBeVisible(radio_bill_seems_too_high);
		click(radio_bill_seems_too_high);
		lOGGER.info("checking  radio button bill seems to high");
	}

	public static void RadiobuttonCheck_CusomerService() {
		scrollToElementView(radio_customerService);
		wait.forElementToBeVisible(radio_customerService);
		click(radio_customerService);
		lOGGER.info("Checking radio button customer service");
	}

	public static void Selecting_VeryFrustratedEmoji() {

		wait.forElementToBeVisible(VeryFrusratedEmoji);
		click(VeryFrusratedEmoji);
		lOGGER.info("Selecting emoji Very frustrated");
	}

	public static WebElement inputAddrressLine1() {
		return AddressLine1;
	}

	public static WebElement inputAddrressLine2() {
		return AddressLine2;

	}

	public static WebElement inputTownOrCity() {
		return townOrCity;
	}

	public static WebElement SelectState() {
		return State;
	}

	public static WebElement inputPostCode() {
		return postcode;
	}

	public static WebElement inputCountry() {
		return Country;
	}

	public static WebElement Submit_NextButton() {
		return submitNext;
	}

	public static void EnterOrganisation(String text) {

		wait.forElementToBeVisible(Textbox_EnterOrganisation);
		sendKeys(Textbox_EnterOrganisation, text);
		lOGGER.info("Entering input into the enter Organisation input field");
	}

	public static void OrganisationName() {

		wait.forElementToBeVisible(Origin_Energy);
		click(Origin_Energy);
		lOGGER.info("Selecting Origin Energy from List");

	}

	public static WebElement whichCountry_i_am_done_choosing() {
		return whichCountry_SubmitButon;

	}

	public void EffectofIssue(String value) {

		wait.forElementToBeVisible(dropDown_EffectOfIssue);
		dropDownMethod(dropDown_EffectOfIssue, "VisibleText", value);
		;
		lOGGER.info("Selecting values from What's the Effect of Issue dropdown field");

	}

	public void ResolutionIWant(String value) {

		wait.forElementToBeVisible(dropDown_ResolutionIWant);
		dropDownMethod(dropDown_ResolutionIWant, "VisibleText", value);
		;
		lOGGER.info("Selecting values from resoltion i most want  dropdown field\"");

	}

	public void SecondPriority(String value) {

		wait.forElementToBeVisible(dropDown_2ndPriority);
		dropDownMethod(dropDown_2ndPriority, "VisibleText", value);
		;
		lOGGER.info("Selecting values from Second Priority dropdown field");

	}

	public void ThirdPriority(String value) {

		wait.forElementToBeVisible(dropDown_3rdPriority);
		dropDownMethod(dropDown_3rdPriority, "VisibleText", value);
		;
		lOGGER.info("Selecting values from Third dropdown field");

	}

	public void NumberOfContactAtempts(String value) {

		wait.forElementToBeVisible(dropDown_ContactAttempt);
		dropDownMethod(dropDown_ContactAttempt, "VisibleText", value);
		;
		lOGGER.info("Selecting values from Number of contacts attempt dropdown field");

	}

	public void YourExperience(String value) {

		wait.forElementToBeVisible(dropDown_YourExperience);
		dropDownMethod(dropDown_YourExperience, "VisibleText", value);
		;
		lOGGER.info("Selecting values from your experience with staff dropdown field");

	}

	public static void AddRefrenceNo(String text) {

		wait.forElementToBeVisible(Textbox_AddRefrence);
		sendKeys(Textbox_AddRefrence, text);
		lOGGER.info("Entering input into the Add refrence number input field");

	}

	public static void AddAccountNo(String text) {

		wait.forElementToBeVisible(Textbox_AccountNumber);
		sendKeys(Textbox_AccountNumber, text);
		lOGGER.info("Entering input into the Add Account Number input field");

	}

	public static void CommentSection(String text) {

		wait.forElementToBeVisible(Textbox_DescriptionBox);
		sendKeys(Textbox_DescriptionBox, text);
		lOGGER.info("Entering input into the Add Account Number input field");

	}

	public static WebElement OptionalDetails_i_am_done_choosing() {
		return optionalDetails_SubmitButton;

	}

	public static WebElement preferResponse_inputTitle() {
		return user_Title;

	}

	public static WebElement preferResponse_firstName() {
		return user_FirstName;

	}

	public static WebElement preferResponse_lastName() {
		return user_LastName;

	}

	public static void preferResponse_checkbox2() {

		wait.forElementToBeVisible(ResponseCheckbox2);
		click(ResponseCheckbox2);
		lOGGER.info("Clicking radio Button for Share Expericence");

	}

	public static WebElement preferResponse_Email() {
		return user_Email;

	}

	public static void preferResponse_checkbox3() {

		wait.forElementToBeVisible(ResponseCheckbox3);
		click(ResponseCheckbox3);
		lOGGER.info("Clicking radio button for receiving news and offers");

	}

	public static WebElement preferResponse_SubmitTheComplaint() {
		return ResponseSubmit;

	}

	public static void HandleComplaint_PasswordCreation() {

		wait.forElementToBeVisible(Textbox_HandleComplainPassword);
		click(Textbox_HandleComplainPassword);
		lOGGER.info("Entering input into the Password input field");

	}

	public static void HandleComplaint_createAccount() {

		wait.forElementToBeVisible(HandleComplaint_CreateAccount);
		click(HandleComplaint_CreateAccount);
		lOGGER.info("Clicking on create account Submit  button");

	}

	//////////////////////////////////////// Test2functions\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public static WebElement IndexpageLogin() {
		return LoginButton;

	}

	public static WebElement inputeEmailID() {
		return enterEmail;

	}

	public static WebElement inputPassword() {
		return enterPassword;

	}

	public static WebElement finalLogin() {
		return LoginAgain;

	}

	public static void myComplainClick() {

		wait.forElementToBeVisible(myComplain);
		click(myComplain);
		lOGGER.info("Clicking on My Complain button");

	}

	public static void submittedComplainsclick() {

		wait.forElementToBeVisible(SumittedComplaints);
		click(SumittedComplaints);
		lOGGER.info("Clicking on My subitted Complain description area");
	}

	public static void writeComplain_Update(String text) {

		wait.forElementToBeVisible(SumittedComplaint_Update);
		sendKeys(SumittedComplaint_Update, text);
		lOGGER.info("Entering input into the Write a complaint update input field");
	}

	public static void AddingfinalUpdate() {

		wait.forElementToBeVisible(addUpdate);
		click(addUpdate);
		lOGGER.info("Clicking on add update button");
	}

//	public static String complaintUpdateDescriptionBox(String text) {
//
//		wait.forElementToBeVisible(ComplaintUpdateDescription);
//		lOGGER.info("Validating the message Everything has been resolved. Thanks for your help.");
//		return ComplaintUpdateDescription.getText();
//
//	}

	public static void markedAsResolvedClick() {

		wait.forElementToBeVisible(markedResolved);
		click(markedResolved);
		lOGGER.info("Clicking on marked as resolved button");
	}

	public void calenderIconClick() {

		wait.forElementToBeVisible(calenderIcon);
		click(calenderIcon);
		lOGGER.info("Clicking on calaender");
	}

	public static void selectTodayDateClick() {

		wait.forElementToBeVisible(todayDate);
		click(todayDate);
		lOGGER.info("Clicking and selecting today's date");
	}

	public static void rateFiveStar() {

		wait.forElementToBeVisible(fiveStarRating);
		click(fiveStarRating);
		lOGGER.info("Checking on five star Rating\"");
	}

	public static void submitResolution() {

		wait.forElementToBeVisible(SubmitResolution);
		click(SubmitResolution);
		lOGGER.info("Clicking on Submit Resolution button");
	}

	public static void ViewyourComplainClick() {

		wait.forElementToBeVisible(viewYourComplaints);
		click(viewYourComplaints);
		lOGGER.info("Clicking on view your complaints button");
	}

	public void scenarioOneSteps() {

		clickOnGuestUserLogin();
		clickOnEnergyLogoButton();
		RadiobuttonCheck_BillAccount();
		RadiobuttonCheck_PayingABill();
		clickingOnSubmitButton();
		RadiobuttonCheck_Bill_Seems_Too_High();
		RadiobuttonCheck_CusomerService();
		clickingOnSubmitButton();
		Selecting_VeryFrustratedEmoji();
		clickingOnSubmitButton();
	}

}
