package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class CustomerPage extends BasePage {

	@FindBy(css = "[for='Personal - Postpaid']")
	WebElement personalpostpaid_radiobutton;

	@FindBy(css = "label[for*='Manufacturer']")
	WebElement manufacturer;
	
	@FindBy(css = "label[for*='Dealership']")
	WebElement dealership;

	@FindBy(css = "[for ='NBN - Small Business']")
	WebElement NBN;

	private static final Logger lOGGER = LogManager.getLogger(CustomerPage.class.getName());

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	public void selectPostPaid() {
		wait.forElementToBeVisible(personalpostpaid_radiobutton);
		click(personalpostpaid_radiobutton);
		lOGGER.info("Clicking on Personal Postpaid radio button");

		doneChoosing();
	}

	public void selectManufacturer() {
		wait.forElementToBeVisible(manufacturer);
		click(manufacturer);
		lOGGER.info("Clicking on Manufacturer radio button");

		doneChoosing();
	}
	
	public void selectDealership() {
		wait.forElementToBeVisible(dealership);
		click(dealership);
		lOGGER.info("Clicking on Manufacturer radio button");
		doneChoosing();
	}

	public void selectNBNSmallBusiness() {
		wait.forElementToBeVisible(NBN);
		click(NBN);
		lOGGER.info("Clicking on NBN Small business  radio button");

		doneChoosing();
	}

}
