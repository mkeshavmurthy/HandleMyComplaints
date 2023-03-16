package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class LoginDetails extends BasePage {

	@FindBy(css = "#register-email")
	WebElement username;

	@FindBy(css = "#register-password")
	WebElement password;

	@FindBy(css = "#LoginButton")
	WebElement Click;

	private static final Logger lOGGER = LogManager.getLogger(LoginPage.class.getName());

	public LoginDetails(WebDriver driver) {
		super(driver);
	}

	public void getUsername(String username1) {
		wait.forElementToBeVisible(username);
		sendKeys(username, username1);
	}

	public void getPassword(String password1) {
		wait.forElementToBeVisible(password);
		sendKeys(password, password1);
	}

	public void onClick() {
		wait.forElementToBeVisible(Click);
		click(Click);

	}

}
