package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class AfterSignUpPage extends BasePage {

	@FindBy(css = "[class ='btn btn-primary btn-block new_complaint']")
	WebElement submitNewComplain;

	@FindBy(css = "[class='notifications alert alert-success alert-block']")
	WebElement accountcreated_alert;

	private static final Logger lOGGER = LogManager.getLogger(AfterSignUpPage.class.getName());

	public AfterSignUpPage(WebDriver driver) {
		super(driver);
	}

	public void submitNewComplain() {
		wait.forElementToBeVisible(submitNewComplain);
		click(submitNewComplain);
		lOGGER.info("Clicking on Submit new Complain Button");
	}

	public String getMessageInSubmitNewComplaintPage() {
		lOGGER.info("Validating the message 'Your account was successfully created'");
		return accountcreated_alert.getText();
	}

}
