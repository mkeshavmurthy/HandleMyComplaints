package Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class ConnectionPage extends BasePage {

	public ConnectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "select.form-control")
	List<WebElement> timeDetails;

	@FindBy(css = "[class='btn btn-pagenav btn-block connection-class']")
	WebElement submitButtonConnection;

	@FindBy(id = "modem_supply")
	WebElement modem;

	@FindBy(id = "soldSignup-zero")
	WebElement soldSignUp;

	@FindBy(id = "soldSignup-two")
	WebElement soldSignUpTwo;

	@FindBy(id = "soldSignup-one")
	WebElement soldSignUpOne;

	@FindBy(id = "soldSignup-other-one")
	WebElement soldSignUpOtherInput;

	@FindBy(id = "promises-zero")
	WebElement PromisesZeroDropdown;

	@FindBy(id = "promises-one")
	WebElement PromisesDropdown2;

	@FindBy(id = "services-zero")
	WebElement servicesDropdown;

	@FindBy(css = "select.form-control")
	List<WebElement> nbnDetails;

	@FindBy(css = "input.form-control")
	List<WebElement> nbnInputDateDetails;

	@FindBy(xpath = "//*[text()='When did you sign up to NBN?']")
	WebElement label;

	private static final Logger lOGGER = LogManager.getLogger(ConnectionPage.class.getName());

	public void AddTimeWithoutDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add(0, "4");
		datalist.add(1, "6");
		datalist.add(2, "");
		datalist.add(3, "2");
		datalist.add(4, "5");
		datalist.add(5, "");

		for (String data : datalist) {
			System.out.println(data);
			if (!data.equals("")) {
				int index = datalist.indexOf(data);
				scrollToElementView(timeDetails.get(index));
				wait.forPage();
				dropDownMethod(timeDetails.get(index), "VisibleText", data);
			}

		}

	}

	public void nBNSetupDropdownDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add(0, "100/40");
		datalist.add(1, "I don't know");
		datalist.add(2, "7");
		datalist.add(3, "");
		datalist.add(4, "");
		datalist.add(5, "Extra data");

		for (String data : datalist) {
			System.out.println(data);
			if (!data.equals("")) {
				int index = datalist.indexOf(data);
				scrollToElementView(nbnDetails.get(index));
				wait.forPage();
				dropDownMethod(nbnDetails.get(index), "VisibleText", data);
			}

		}
	}

	public void nBNSetupInputDateDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add(0, "");
		datalist.add(1, "1/9/2020");
		datalist.add(2, "2/9/2020");
		datalist.add(3, "2/9/2020");

		for (int i = 1; i <= 3; i++) {
			scrollToElementView(nbnDetails.get(i));
			wait.forPage();
			sendKeys(nbnInputDateDetails.get(i), datalist.get(i));
			Actions action = new Actions(driver);
			action.click(label).perform();
		}
	}

	public void inputConnectionWithoutDetails() {
		AddTimeWithoutDetails();
		wait.forPage();
		click(submitButtonConnection);

	}

	public void IsModemSupplied(String value) {
		wait.forPage();
		scrollToElementView(modem);
		dropDownMethod(modem, "VisibleText", value);
	}

	public void soldSignUp(String value) {
		wait.forElementToBeVisible(soldSignUp);
		scrollToElementView(soldSignUp);
		dropDownMethod(soldSignUp, "VisibleText", value);
		lOGGER.info("selecting " + value + " from sold sign up Dropdown");
	}

	public void soldSignUpTwo(String value) {
		wait.forElementToBeVisible(soldSignUpTwo);
		scrollToElementView(soldSignUpTwo);
		dropDownMethod(soldSignUpTwo, "VisibleText", value);
		lOGGER.info("selecting " + value + " from sold sign up two Dropdown");
	}

	public void soldSignUpOne(String value) {
		wait.forElementToBeVisible(soldSignUpOne);
		scrollToElementView(soldSignUpOne);
		dropDownMethod(soldSignUpOne, "VisibleText", value);
		lOGGER.info("selecting " + value + " from sold sign up first Dropdown");
	}

	public void soldSignUpOtherText(String value) {
		wait.forElementToBeVisible(soldSignUpOtherInput);
		scrollToElementView(soldSignUpOtherInput);
		soldSignUpOtherInput.sendKeys(value);
		lOGGER.info("entering " + value + " in Sign other Input Text box");
	}

	public void selectPromisesMade(String value) {
		wait.forPage();
		scrollToElementView(PromisesZeroDropdown);
		dropDownMethod(PromisesZeroDropdown, "VisibleText", value);
		lOGGER.info("selecting " + value + " from Promises Made Dropdown");
	}

	public void selectPromisesMadeSecondDropdown(String value) {
		wait.forPage();
		scrollToElementView(PromisesDropdown2);
		dropDownMethod(PromisesDropdown2, "VisibleText", value);
		lOGGER.info("selecting " + value + " from Promises Made Dropdown 2");
	}

	public void selectSpecialServices(String value) {
		wait.forPage();
		scrollToElementView(servicesDropdown);
		dropDownMethod(servicesDropdown, "VisibleText", value);
		lOGGER.info("selecting " + value + " from services Dropdown");
	}

	public void inputPromiseDetails() {
		IsModemSupplied("Unsure");
		soldSignUp("Someone would contact me");
		soldSignUpOne("Other");
		soldSignUpOtherText("Quick Connection");
		selectPromisesMade("Investigation");
		selectPromisesMadeSecondDropdown("Technician appointment time");
		selectSpecialServices("Elevator telephone");
		doneChoosing();

	}

	public void inputNBNSetupDetails() {
		nBNSetupDropdownDetails();
		nBNSetupInputDateDetails();
		doneChoosing();
	}

}
