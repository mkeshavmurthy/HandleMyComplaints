package Pages;

import commons.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {

	@FindBy(css = "#register-title")
	static WebElement user_Title;

	@FindBy(css = "#register-givenname")
	static WebElement user_FirstName;

	@FindBy(css = "#register-familyname")
	static WebElement user_LastName;

	@FindBy(css = "#register-email")
	static WebElement user_Email;

	@FindBy(css = "#register-password")
	static WebElement user_Password;

	@FindBy(css = "#newcomplaintuser-password-confirm")
	static WebElement user_VerifyPassword;

	@FindBy(css = "[for='register-allowcontact']")
	static WebElement radio_ReceiveNews_Checkbox;

	@FindBy(id = "LoginButton")
	static WebElement signUpButton;

	@FindBy(css = "[class='notifications alert alert-danger alert-block']")
	static WebElement passwordmismatch_alert;

	private static final Logger lOGGER = LogManager.getLogger(SignUpPage.class.getName());

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public void selectTitle(String value) {
		wait.forElementToBeVisible(user_Title);
		dropDownMethod(user_Title, "VisibleText", value);
		lOGGER.info("clicked on Sign up button");

	}

	public void enterFirstName(String text) {
		wait.forElementToBeVisible(user_FirstName);
		sendKeys(user_FirstName, text);
		lOGGER.info("Entering input into the First Name input field");
	}

	public void enterLastName(String text) {
		wait.forElementToBeVisible(user_LastName);
		sendKeys(user_LastName, text);
		lOGGER.info("Entering input into the Last Name input field");
	}

	public void enterUserEmail(String text) {
		wait.forElementToBeVisible(user_Email);
		sendKeys(user_Email, text);
		lOGGER.info("Entering input into the Emailid input field");
	}

	public void enterPassword(String pwd) {
		wait.forElementToBeVisible(user_Password);
		sendKeys(user_Password, pwd);
		lOGGER.info("Entering input into the Password input field");

	}

	public void reenterPassword(String pwd) {
		wait.forElementToBeVisible(user_Password);
		sendKeys(user_VerifyPassword, pwd);
		lOGGER.info("Entering input into the Verify Password input field");

	}

	public void clickOnRadioReceiveNewsCheckbox() {
		wait.forElementToBeVisible(radio_ReceiveNews_Checkbox);
		click(radio_ReceiveNews_Checkbox);
		lOGGER.info(
				"Clicking on 'I would like to receive news and offers from Handle My Complaint' radio button in homepage");

	}

	public void clickOnSignUpButton() {
		wait.forElementToBeVisible(signUpButton);
		click(signUpButton);
		lOGGER.info("Clicking on SignUp Button in homepage");
	}

	public void SignUp(String userEmail) {
		wait.forPage();
		selectTitle("Mrs");
		enterFirstName("test");
		enterLastName("automation");
		enterUserEmail(userEmail);
		enterPassword("marymacdonald");
		reenterPassword("marymacdon");
		clickOnRadioReceiveNewsCheckbox();
		clickOnSignUpButton();
		Assert.assertTrue(getTextPartialValidate(passwordmismatch_alert, "Passwords you've provided do not match"));
		lOGGER.info("Validating the error message in homepage for Password mismatch");
		enterPassword("Testing@123");
		reenterPassword("Testing@123");
		clickOnSignUpButton();

	}

}
