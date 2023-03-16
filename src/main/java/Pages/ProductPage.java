package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class ProductPage extends BasePage {

	@FindBy(css = "[for='Mobile Phone']")
	WebElement mobilephone_radiobutton;

	@FindBy(css = "[for='Credit Card']")
	WebElement creditCardRadioButton;

	@FindBy(css = "[for ='New Vehicle']")
	WebElement newVehicle;
	
	@FindBy(css = "[for ='Used Vehicle']")
	WebElement usedVehicle;

	@FindBy(css = "[for ='Internet']")
	WebElement internet;

	private static final Logger lOGGER = LogManager.getLogger(ProductPage.class.getName());

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnMobilePhone() {
		wait.forElementToBeVisible(mobilephone_radiobutton);
		click(mobilephone_radiobutton);
		lOGGER.info("Clicking on Mobile Phone radio button");
		doneChoosing();
	}

	public void selectCreditCard() {
		wait.forElementToBeVisible(creditCardRadioButton);
		click(creditCardRadioButton);
		lOGGER.info("Clicking on Credit Card radio button");
		doneChoosing();
	}

	public void selectnewVehicle() {
		wait.forElementToBeVisible(newVehicle);
		click(newVehicle);
		lOGGER.info("Clicking on new Vehicle radio button");
		doneChoosing();
	}
	
	public void selectUsedVehicle() {
		wait.forElementToBeVisible(usedVehicle);
		click(usedVehicle);
		lOGGER.info("Clicking on new Vehicle radio button");
		doneChoosing();
	}

	public void selectInternet() {
		wait.forElementToBeVisible(internet);
		click(internet);
		lOGGER.info("Clicking on internet radio button");
		doneChoosing();
	}

}
