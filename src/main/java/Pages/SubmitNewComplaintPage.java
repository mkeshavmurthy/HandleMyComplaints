package Pages;

import commons.BasePage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SubmitNewComplaintPage extends BasePage {

	// What would you like to do today?

	@FindBy(xpath = "((//*[@class='container'])[2]//following::div[1])[1]")
	static WebElement accountcreated_alert;

	@FindBy(xpath = "//a[@class ='btn btn-primary btn-block new_complaint']")
	static WebElement submitNewComplain;

	// Select the industry your complaint relates to.

	@FindBy(xpath = "//a[@id='new_telco']//child::i")
	static WebElement telcoIcon;

	// Select the product your complaint relates to.

	@FindBy(xpath = "//*[text()='Mobile Phone']")
	static WebElement mobilephone_radiobutton;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-block']")
	static WebElement nextiamdonechoosing_SubmitButtonNew;

	@FindBy(xpath = "//button[@class='btn btn-pagenav btn-block organisation-button']")
	static WebElement nextiamdonechoosing_SubmitButton;

	// Select which type of customer you are.

	@FindBy(xpath = "//*[text()='Personal - Postpaid']")
	static WebElement personalpostpaid_radiobutton;

	// Select all that are relevant - this helps us give you a better outcome,
	// faster.

	@FindBy(xpath = "//*[text()='Bill / Account']")
	static WebElement billaccount_radiobutton;

	// Select all the issues that apply to your experience.

	@FindBy(xpath = "//*[text()='Account transferred incorrectly']")
	static WebElement accounttransferredincorrectly_radiobutton;

	@FindBy(xpath = "//*[text()='My instructions not followed']")
	static WebElement myinstructionsnotfollowed_radiobutton;

	// Select the emotion that best conveys how you're feeling.

	@FindBy(xpath = "//*[text()='Disappointed']")
	static WebElement disappointedsmileyclick;

	// What is the location of where this issue is happening

	@FindBy(xpath = "//*[text()='ADDRESS LINE 1 *']//following::input[1]")
	static WebElement addressline1_inputfield;

	@FindBy(xpath = "//*[text()='ADDRESS LINE 2']//following::input[1]")
	static WebElement addressline2_inputfield;

	@FindBy(xpath = "//*[text()='TOWN / CITY *']//following::input[1]")
	static WebElement towncity_inputfield;

	@FindBy(xpath = "//*[@id='submit-btn']")
	static WebElement next_button;

	@FindBy(xpath = "//select[@id='state']")
	static WebElement state_dropdown;

	@FindBy(xpath = "//*[text()='POSTCODE *']//following::input[1]")
	static WebElement postcode_inputfield;

	@FindBy(xpath = "//*[@class='alert alert-danger msg']")
	static WebElement incorrectaddress_alert;

	// Select the company responsible for the issue you are experiencing.

	@FindBy(xpath = "//*[text()='My issues relate to multiple companies']")
	static WebElement myissuesrelatetomultiplecompanies_radiobutton;

	@FindBy(xpath = "//*[text()='Account transferred incorrectly']//following::input[1]")
	static WebElement accounttransferredincorrectly_inputfield;

	@FindBy(xpath = "//*[text()='Telstra']")
	static WebElement select_Telstra;

	@FindBy(xpath = "//*[text()='My instructions not followed']//following::input[1]")
	static WebElement myinstructionsnotfollowed_inputfield;

	@FindBy(xpath = "//*[text()='Optus Mobile']")
	static WebElement select_OptusMobile;

	// Add more details to help us resolve your problem faster. It’s optional.

	@FindBy(xpath = "//*[@id='impact-field']")
	static WebElement effectoftheissue_dropdown;

	@FindBy(xpath = "//input[@name='other-impact']")
	static WebElement pleasespecifyeffect_inputfield;

	@FindBy(xpath = "//*[@id='outcome-field1']")
	static WebElement resolution_dropdown;

	@FindBy(xpath = "//*[@id='other-outcome1']")
	static WebElement pleasespecifyresolution_inputfield;

	@FindBy(xpath = "//*[@id='outcome-field2']")
	static WebElement secondpriority_dropdown;

	@FindBy(xpath = "//*[@id='outcome-field3']")
	static WebElement thirdpriority_dropdown;

	@FindBy(xpath = "//*[@id='contactattempts-field']")
	static WebElement contact_dropdown;

	@FindBy(xpath = "//*[@id='experience-field']")
	static WebElement experience_dropdown;

	@FindBy(xpath = "//*[@class='btn btn-default btn-file']")
	static WebElement choosefile;

	@FindBy(xpath = "//*[@id='comments-field']")
	static WebElement comments_section;

	// Let us know if you require a response from the company

	@FindBy(xpath = "//*[text()='LAST NAME *']")
	static WebElement lastname_field;

	@FindBy(xpath = "//*[text()='Phone']")
	static WebElement phone_radiobutton;

	@FindBy(xpath = "//input[@id='phone-number']")
	static WebElement phonenumber_inputfield;

	@FindBy(xpath = "(//*[@class='pad-left-45 sml-font'])[2]")
	static WebElement share_experience;

	@FindBy(xpath = "(//button[@id='submit-step'])[1]")
	static WebElement submitComplaint;

	private static final Logger lOGGER = LogManager.getLogger(SubmitNewComplaintPage.class.getName());

	public SubmitNewComplaintPage(WebDriver driver) {
		super(driver);
	}

	public String getMessageInSubmitNewComplaintPage() {
		lOGGER.info("Validating the message 'Your accout was successfully created'");
		return accountcreated_alert.getText();
	}

	public void submitNewComplaint() throws IOException {

		wait.forPage();

		click(submitNewComplain);
		lOGGER.info("Clicking on Submit new Complain Button");

		click(telcoIcon);
		lOGGER.info("Clicking on Telco icon field");

		click(mobilephone_radiobutton);
		lOGGER.info("Clicking on Mobile Phone radio button");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		click(personalpostpaid_radiobutton);
		lOGGER.info("Clicking on Personal Postpaid radio button");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		click(billaccount_radiobutton);
		lOGGER.info("Clicking on Bill Account radio button");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		click(accounttransferredincorrectly_radiobutton);
		lOGGER.info("Clicking on Account Transferred Incorrectly radio button");

		click(myinstructionsnotfollowed_radiobutton);
		lOGGER.info("Clicking on My Instructions Not Followed radio button");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		click(disappointedsmileyclick);
		lOGGER.info("Clicking on Disappointed Smiley");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		sendKeys(addressline1_inputfield, "2/27 Kalemajere Drive");
		lOGGER.info("Entering the value '2/27 Kalemajere Drive' in Address Line 1 input field");

		sendKeys(towncity_inputfield, "Suffolk Park");
		lOGGER.info("Entering the value 'Suffolk Park' in Town City input field");

		Assert.assertFalse(isElementPresence(next_button));
		lOGGER.info("Validating that the Next button should be disabled");

		dropDownMethod(state_dropdown, "VisibleText", "NSW");
		lOGGER.info("Selecting the state 'NSW' from dropdown ");

		sendKeys(postcode_inputfield, "2841");
		lOGGER.info("Entering the wrong value '2841' in Post Code input field");

		Assert.assertTrue(getTextPartialValidate(incorrectaddress_alert,
				"The address you've provided isn't correct. Please try again"));
		lOGGER.info(
				"Validating the error message 'The address you've provided isn't correct. Please try again' is displayed");

		clearText(postcode_inputfield);
		lOGGER.info("Clearing the Post Code input field value");

		sendKeys(postcode_inputfield, "2");
		lOGGER.info("Entering the value '2' in Post Code input field");

		Assert.assertFalse(isElementPresence(next_button));
		lOGGER.info("Validating that the Next button should be disabled");

		clearText(postcode_inputfield);
		lOGGER.info("Clearing the Post Code input field value");

		sendKeys(postcode_inputfield, "2481");
		lOGGER.info("Entering the correct value '2481' in Post Code input field");

		scrollToTop();
		lOGGER.info("Scrolling to the top");

		sendKeys(addressline2_inputfield, "");
		lOGGER.info("Entering null value to address line 2");

		scrollToBottom();
		lOGGER.info("Scrolling to the bottom");

		// wait(15);
		Assert.assertTrue(isElementPresence(next_button));
		lOGGER.info("Validating that the Next button should be enabled");

		click(next_button);
		lOGGER.info("Clicking on Next button");

		click(myissuesrelatetomultiplecompanies_radiobutton);
		lOGGER.info("Clicking on 'My issues relate to multiple companies' radio button");

		sendKeys(accounttransferredincorrectly_inputfield, "Telstra");
		lOGGER.info("Entering the value 'Telstra' in account transferred incorrectly input field");

		// wait(8);
		click(select_Telstra);
		lOGGER.info("selecting the 'Telstra' option");

		sendKeys(myinstructionsnotfollowed_inputfield, "Optus Mobil");
		lOGGER.info("Entering the value 'Optus Mobile' in my instructions not followed input field");

		// waitFor(5);
		click(select_OptusMobile);
		lOGGER.info("selecting the 'Optus Mobile' option");

		click(nextiamdonechoosing_SubmitButton);
		lOGGER.info("Clicking on next i am done choosing");

		dropDownMethod(effectoftheissue_dropdown, "VisibleText", "Other");
		lOGGER.info("Selecting the effect of the issue as 'Other' from dropdown ");

		sendKeys(pleasespecifyeffect_inputfield, "Losing my phone number");
		lOGGER.info("Entering the value 'Losing my phone number' in please specify the effect input field");

		dropDownMethod(resolution_dropdown, "VisibleText", "Other");
		lOGGER.info("Selecting the resolution as 'Other' from dropdown ");

		sendKeys(pleasespecifyresolution_inputfield, "Account transfer reversed");
		lOGGER.info("Entering the value 'Account transfer reversed' in pleasespecifyresolution input field");

		scrollToElementView(secondpriority_dropdown);
		lOGGER.info("Scrolling to the second priority dropdown field");

		dropDownMethod(secondpriority_dropdown, "VisibleText", "Issue fixed");
		lOGGER.info("Selecting the second priority as 'Issue fixed' from dropdown ");

		dropDownMethod(thirdpriority_dropdown, "VisibleText", "Apology");
		lOGGER.info("Selecting the third priority as 'Apology' from dropdown ");

		dropDownMethod(contact_dropdown, "VisibleText", "This is the first complaint");
		lOGGER.info("Selecting the contact as 'This is the first complaint' from dropdown ");

		dropDownMethod(experience_dropdown, "VisibleText", "Problem is urgent");
		lOGGER.info("Selecting the experience as 'Problem is urgent' from dropdown ");

		scrollToBottom();
		lOGGER.info("Scrolling to the bottom");

		isElementDisplayed(choosefile);
		lOGGER.info("Chekcing visibility of choosefile button");

		click(choosefile);
		lOGGER.info("Clicking on the choosefile button");
		// waitFor(10);

		Runtime.getRuntime().exec("C:\\Users\\malli\\Desktop\\FileUpload.exe");
		lOGGER.info("Entering the path of the file to be uploaded");
		// waitFor(15);

		sendKeys(comments_section, "Please save my mobile phone number from being lost");
		lOGGER.info(
				"Entering the value 'Please save my mobile phone number from being lost' in comments Section input field");

		click(nextiamdonechoosing_SubmitButtonNew);
		lOGGER.info("Clicking on next i am done choosing");

		scrollToElementView(lastname_field);
		lOGGER.info("Scrolling to the last name field");

		click(phone_radiobutton);
		lOGGER.info("Selecting the phone radio button");

		javaScriptSendValue(phonenumber_inputfield, "0422222222");
		lOGGER.info("Entering the value '0422222222' in phone number input field");

		scrollToBottom();
		lOGGER.info("Scrolling to the bottom");

		click(share_experience);
		lOGGER.info("Clicking on share experience radio button");

		click(submitComplaint);
		lOGGER.info("Clicking on Submit the Complaint button");
	}

}
