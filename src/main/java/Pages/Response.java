
package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;
import commons.InitializePropertyFile;

public class Response extends BasePage {

	public Response(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[@for='response-yes-for-another']")
	WebElement submitOnBehalf;
	
	@FindBy(css = "#contact-title")
	WebElement title;

	@FindBy(css = "#contact-firstname")
	WebElement firstName;

	@FindBy(css = "#contact-lastname")
	WebElement lastname;

	@FindBy(css = "#contact-email")
	WebElement email;

	@FindBy(css = "[for='response-post']")
	WebElement post;

	@FindBy(css = "[for ='contact-me']")
	WebElement ResponseCheckbox3;

	@FindBy(css = "[for ='allow_share']")
	WebElement ResponseCheckbox2;

	@FindBy(css = "[for='response-phone']")
	WebElement phone_radiobutton;

	@FindBy(css = "input#phone-number")
	WebElement phonenumber_inputfield;

	private static final Logger lOGGER = LogManager.getLogger(Response.class.getName());

	public void title(String value) {

		wait.forElementToBeVisible(title);
		dropDownMethod(title, "Value", value); // new method
		lOGGER.info("Selecting values from Title dropdown field");

	}

	public void firstName(String value) {
		wait.forElementToBeVisible(firstName);
		sendKeys(firstName, value);
		lOGGER.info("Entering input into the Prefer response First Name input field");
	}

	public void lastname(String value) {
		wait.forElementToBeVisible(lastname);
		sendKeys(lastname, value);
		lOGGER.info("Entering input into the Prefer response Last Name input field");

	}

	public void email(String value) {
		wait.forElementToBeVisible(email);
		sendKeys(email, value);
		lOGGER.info("Entering input into the Prefer response Email input field");
	}

	public void post() {
		wait.forElementToBeVisible(post);
		click(post);
	}

	public void yesForAnother() {
		wait.forElementToBeVisible(submitOnBehalf);
		click(submitOnBehalf);
	}
	
	public void clickOnPreferResponse_checkbox2() {

		wait.forElementToBeVisible(ResponseCheckbox2);
		click(ResponseCheckbox2);
		lOGGER.info("Clicking radio Button for Share Expericence");

	}

	public void clickOnPreferResponse_checkbox3() {

		wait.forElementToBeVisible(ResponseCheckbox3);
		click(ResponseCheckbox3);
		lOGGER.info("Clicking radio button for receiving news and offers");

	}

	public void inputResponse() {
		title("Mrs");
		firstName("Test");
		lastname("Auto");
		email(InitializePropertyFile.property.getProperty("TC01_username"));
		clickOnPreferResponse_checkbox2();
		clickOnPreferResponse_checkbox3();
		doneChoosing();

	}

	public void selectPhoneRadioButton() {
		wait.forElementToBeVisible(ResponseCheckbox3);
		click(phone_radiobutton);
		lOGGER.info("Selecting the phone radio button");
	}

	public void inputPhoneNumber(String number) {
		wait.forElementToBeVisible(phonenumber_inputfield);
		javaScriptSendValue(phonenumber_inputfield, number);
		lOGGER.info("Entering the value '0422222222' in phone number input field");
	}

	public void inputResponse_SC02() {
		scrollToElementView(lastname);
		lOGGER.info("Scrolling to the last name field");
		selectPhoneRadioButton();
		inputPhoneNumber("0422222222");
		scrollToBottom();
		clickOnPreferResponse_checkbox2();
		doneChoosing();

	}

	public void inputResponse_SC05() {
		title("Mr");
		scrollToBottom();
		clickOnPreferResponse_checkbox2();
		clickOnPreferResponse_checkbox3();
		doneChoosing();

	}
	
	public void inputResponse_SC08() {
		title("Mr");
		scrollToBottom();
		clickOnPreferResponse_checkbox2();
		clickOnPreferResponse_checkbox3();
		doneChoosing();

	}

	public void inputResponse_SC06() {
		title("Mr");
		doneChoosing();

	}

	public void inputResponse_SC04_part2() {
		title("Mr");
		scrollToBottom();

		doneChoosing();

	}
	
	public void inputResponse_SC03() {
		yesForAnother();
		title("Prof");
		firstName("mum");
		lastname("matters");
		email(InitializePropertyFile.property.getProperty("TC03_username"));
		post();
		clickOnPreferResponse_checkbox2();
		clickOnPreferResponse_checkbox3();
		doneChoosing();
	}
}
