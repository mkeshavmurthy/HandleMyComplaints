package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;

public class SignUp extends BasePage {

	public SignUp(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='register-title']")
	WebElement title;

	@FindBy(xpath = "//input[@id='register-givenname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='register-familyname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='register-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='register-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='newcomplaintuser-password-confirm']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@id='newcomplaintuser-signup']")
	WebElement checkbox;

	@FindBy(css = "#LoginButton")
	WebElement SignUpButton;

	private static final Logger lOGGER = LogManager.getLogger(SignUp.class.getName());

	public void getTitle(String value) {
		wait.forElementToBeVisible(title);
		dropDownMethod(title, "VisibleText", value);
		lOGGER.info("Selecting values from title dropdown field");
	}

	public void firstName(String text) {
		wait.forElementToBeVisible(firstName);
		sendKeys(firstName, text);
		lOGGER.info("Entering input into the First Name input field");
	}

	public void lastName(String text) {
		wait.forElementToBeVisible(lastName);
		sendKeys(lastName, text);
		lOGGER.info("Entering input into the Last Name input field");
	}

	public void password(String pwd) {
		wait.forPage();
		wait.forElementToBeVisible(password);
		sendKeys(password, pwd);
		lOGGER.info("Entering input into the password input field");
	}

	public void newPassword(String newpwd) {
		wait.forElementToBeVisible(newPassword);
		sendKeys(newPassword, newpwd);
		lOGGER.info("Entering input into the new password input field");
	}

	public void checkbox() {
		wait.forElementToBeVisible(checkbox);
		click(checkbox);
		lOGGER.info("clicking on the checkbox");

	}

	public void SignUpButton() {
		wait.forElementToBeVisible(SignUpButton);
		click(SignUpButton);
		lOGGER.info("clicking on the sign up button");

	}
}
