package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class SubmitNewComplaint extends BasePage {

	public SubmitNewComplaint(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class='btn btn-primary btn-block new_complaint']")
	WebElement submitComplaint;

	@FindBy(css = "[class='fa fa-lightbulb-o']")
	WebElement energyComplaint;

	@FindBy(css = "[for='Paying a bill']")
	WebElement payingBill;

	@FindBy(css = "[class='dropdown-toggle hamburger-icon']")
	WebElement menu;

	@FindBy(css = "ul[class='dropdown-menu hamburger-dropdown'] li a[href='/']")
	WebElement home;

	private static final Logger lOGGER = LogManager.getLogger(SubmitNewComplaint.class.getName());

	public void submitComplaint() {
		wait.forElementToBeClickable(submitComplaint);
		click(submitComplaint);
		lOGGER.info("clicking on Submit complaint");
	}

	public void energyComplaint() {
		wait.forElementToBeVisible(energyComplaint);
		click(energyComplaint);
	}

	public void payingBill() {
		wait.forElementToBeVisible(payingBill);
		click(payingBill);
	}

	public void clickOnMenu() {
		wait.forPage();
		wait.forElementToBeClickable(menu);
		click(menu);
		lOGGER.info("Clicking on the menu button");
	}

	public void clickOnHome() {
		wait.forPage();
		wait.forElementToBeClickable(home);
		click(home);
		lOGGER.info("Clicking on the home button");
	}

	public void navigateToHomePage() {
		clickOnMenu();
		clickOnHome();
	}

}
