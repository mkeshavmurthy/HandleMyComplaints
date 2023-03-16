
package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.BasePage;

public class Location extends BasePage {

	public Location(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#address1")
	WebElement address1;

	@FindBy(css = "#address2")
	WebElement address2;

	@FindBy(css = "#city")
	WebElement city;

	@FindBy(css = "#state")
	WebElement state;

	@FindBy(css = "#postcode")
	WebElement postcode;

	@FindBy(css = "#country")
	WebElement country;

	@FindBy(css = "#country>option")
	WebElement countryOption;

	@FindBy(css = "#submit-btn")
	WebElement submit;

	@FindBy(css = "#postcode")
	static WebElement postcode_inputfield;

	private static final Logger lOGGER = LogManager.getLogger(Location.class.getName());
	
	public void inputDetailForAddress01() {

		address1("67 View St");
		scrollToBottom();
		address2("Wollahra");
		city("Sydney");
		state("NSW");
		postcode("2025");
		country("1");
		submit();
	}

	public void inputDetailForAddress() {

		address1("24/23 Bow River Crescent");
		scrollToBottom();
		address2("");
		city("Burswood");
		state("WA");
		postcode("6100");
		country("1");
		submit();
	}

	public void address1(String value) {
		wait.forElementToBeVisible(address1);
		sendKeys(address1, value);
		lOGGER.info("Entering input into the Adress1 input field");
	}

	public void address2(String value) {
		wait.forElementToBeVisible(address2);
		sendKeys(address2, value);
		lOGGER.info("Entering input into the Adress2 input field");
	}

	public void city(String value) {
		wait.forElementToBeVisible(city);
		sendKeys(city, value);
		lOGGER.info("Entering input into the Town/City input field");
	}

	public void state(String value) {
		wait.forElementToBeVisible(state);
		click(state);
		dropDownMethod(state, "VisibleText", value);
		lOGGER.info("Selecting values from State dropdown field");

	}

	public void postcode(String value) {
		wait.forElementToBeVisible(postcode);
		sendKeys(postcode, value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lOGGER.info("Entering input into the Postcode input field");
	}

	public void country(String value) {

		wait.forElementToBeVisible(country);
		click(country);
		wait.forElementToBeVisible(countryOption);
		countryOption.click();
//        dropDownMethod(country, "Value", value);
		lOGGER.info("Selecting values from country dropdown field");

	}

	public void submit() {
		wait.forElementToBeClickable(submit);
		click(submit);
		lOGGER.info("clicking on the Submit button");
	}

	public void inputDetailForAddress_SC02() {

		address1("2/27 Kalemajere Drive");
		city("Suffolk Park");
		Assert.assertFalse(isElementPresence(submit));
		lOGGER.info("Validating that the Next button should be disabled");
		wait.forPage();
		scrollToBottom();
		state("NSW");
		postcode("2841");
		clearText(postcode_inputfield);
		lOGGER.info("Clearing the Post Code input field value");
		wait.forPage();
		postcode("2");
		Assert.assertFalse(isElementPresence(submit));
		lOGGER.info("Validating that the Next button should be disabled");
		wait.forPage();
		clearText(postcode_inputfield);
		lOGGER.info("Clearing the Post Code input field value");
		postcode("2481");
		wait.forPage();
		country("1");
		submit();
	}

	public void inputDetailForAddress_SC04() {

		address1("12 Mortimer st");
		scrollToBottom();
		address2("");
		city("Whyalla Sturt");
		state("SA");
		postcode("5608");
		country("1");
		submit();
	}

	public void inputDetailForAddress_SC05() {

		address1("5 Page St.");
		scrollToBottom();
		address2("");
		city("Albert Park");
		state("VIC");
		postcode("3206");
		country("1");
		submit();
	}

	public void inputDetailForAddress_SC06() {

		address1("16 Casmaria St.");
		scrollToBottom();
		address2("");
		city("Mansfield");
		state("QLD");
		postcode("4122");
		country("1");
		submit();
	}

	public void inputDetailForAddress_SC07() {

		address1("100 George St");
		scrollToBottom();
		address2("");
		city("Brisbane");
		state("QLD");
		postcode("4000");
		country("1");
		submit();
	}
	
	public void inputDetailForAddress_SC08() {

		address1("42 Roseleigh St");
		scrollToBottom();
		address2("");
		city("Kalinga");
		state("QLD");
		postcode("4030");
		country("1");
		submit();
	}

}
