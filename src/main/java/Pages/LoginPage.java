package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;
import commons.InitializePropertyFile;

public class LoginPage extends BasePage {

	@FindBy(css = "div.col-md-12 h1")
	public WebElement loginPageFormTitle;

	@FindBy(css = "[class='btn btn-social btn-google-plus']")
	WebElement googlePlusSignIn;

	@FindBy(css = "[class='btn btn-social btn-facebook']")
	WebElement facebookSignIn;

	@FindBy(css = "#identifierId")
	WebElement enterUserName;

	@FindBy(css = "[name='email']")
	WebElement enterFBUserName;

	@FindBy(css = "[name='password']")
	WebElement enterPassword;

	@FindBy(css = "[name='pass']")
	WebElement enterFBPassword;

	@FindBy(id = "identifierNext")
	WebElement nextUserName;

	@FindBy(id = "passwordNext")
	WebElement nextPassword;

	@FindBy(css = "[name='login']")
	WebElement login;

	@FindBy(css = "input[type='email']")
	WebElement usernameInput;

	@FindBy(css = "input[type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;

	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public String getLoginFormTitle() {
		lOGGER.info("fetching login form title");
		return loginPageFormTitle.getText();
	}

	public void clickOnGooglePlusLogin() {
		wait.forElementToBeVisible(googlePlusSignIn);
		click(googlePlusSignIn);
		lOGGER.info("Clicking on google Plus Sign In Button");
	}

	public void clickOnFacebookLogin() {
		wait.forElementToBeVisible(facebookSignIn);
		click(facebookSignIn);
		lOGGER.info("Clicking on Facebook Sign In Button");
	}

	public void gmailSignInFlowMethod(String username, String Password) {

		wait.forElementToBeVisible(usernameInput);
		lOGGER.info("Enter the gmail username");
		sendKeys(usernameInput, username);
		wait.forElementToBeVisible(nextButton);
		click(nextButton);
		wait.forElementToBeVisible(passwordInput);
		lOGGER.info("Enter the gmail account's password");
		sendKeys(passwordInput, Password + Keys.ENTER);
		wait.forElementToBeVisible(nextButton);
		click(nextButton);
		wait.forPage();
		lOGGER.info("Page Tile " + driver.getTitle());

	}

	public void facebookFlowMethod() {
		wait.forElementToBeVisible(enterFBUserName);
		lOGGER.info("Enter the FB username");
		sendKeys(enterFBUserName, InitializePropertyFile.property.getProperty("TC05_username"));

		wait.forElementToBeVisible(enterFBPassword);
		lOGGER.info("Enter the FB account's password");
		sendKeys(enterFBPassword, InitializePropertyFile.property.getProperty("TC05_password"));
		wait.forElementToBeVisible(login);
		click(login);
		lOGGER.info("Page Tile " + driver.getTitle());

	}
	public void facebookFlowMethod_04() {
		wait.forElementToBeVisible(enterFBUserName);
		lOGGER.info("Enter the FB username");
		sendKeys(enterFBUserName, InitializePropertyFile.property.getProperty("TC04_username"));
		wait.forElementToBeVisible(enterFBPassword);
		lOGGER.info("Enter the FB account's password");
		sendKeys(enterFBPassword, InitializePropertyFile.property.getProperty("TC04_fbPassword"));
		wait.forElementToBeVisible(login);
		click(login);
		lOGGER.info("Page Tile " + driver.getTitle());
	}

}
