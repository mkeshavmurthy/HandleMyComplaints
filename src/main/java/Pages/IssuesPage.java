
package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class IssuesPage extends BasePage {

	public IssuesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[for='Need more time to pay']")
	WebElement needMoreTime;
	
	@FindBy(css = "[for='Bill / Account']")
	WebElement billAccount;

	@FindBy(css = "[for='Paying a bill']")
	WebElement payingABill;

	@FindBy(css = "[for='Bill seems too high / incorrect']")
	WebElement billSeemsTooHigh;

	@FindBy(css = "[for='Customer service']")
	WebElement customerService;

	@FindBy(css = "[for ='Engine issue']")
	WebElement engineIssue;
	
	@FindBy(css = "[for ='Unsafe vehicle']")
	WebElement unsafeVehicle;

	@FindBy(css = "for=['Bill / Account']")
	WebElement billaccount_radiobutton;

	@FindBy(css = "[for='Account transferred incorrectly']")
	WebElement accounttransferredincorrectly_radiobutton;

	@FindBy(css = "[for='My instructions not followed']")
	WebElement myinstructionsnotfollowed_radiobutton;

	@FindBy(css = "[for='TextToReplace']")
	WebElement relevantIssue;

	@FindBy(css = "[for='Payments']")
	WebElement payments;

	@FindBy(css = "[for='Unauthorised transaction']")
	WebElement transaction;

	@FindBy(css = "[for = 'Mechanical / Parts']")
	WebElement mechanicalParts;

	@FindBy(css = "[for ='Connection / Disconnection']")
	WebElement connection;

	@FindBy(css = "label[for*='Promised connection']")
	WebElement promisedConnection;

	private static final Logger lOGGER = LogManager.getLogger(IssuesPage.class.getName());

	public void needMoreTime() {
		wait.forElementToBeVisible(needMoreTime);
		click(needMoreTime);
	}

	public void selectUnAuthorizedTransantion() {
		wait.forElementToBeVisible(transaction);
		click(transaction);
		lOGGER.info("Checking radio button unAuthorized Transaction");

	}

	public void selectBillAccount() {

		wait.forElementToBeVisible(billAccount);
		click(billAccount);
		lOGGER.info("checking radio button bill/account");
	}

	public void selectPayingABill() {

		wait.forElementToBeVisible(payingABill);
		click(payingABill);
		lOGGER.info("Checking radio button Paying a bill");
	}

	public void selectPayments() {

		wait.forElementToBeVisible(payments);
		click(payments);
		lOGGER.info("Checking radio button payments");
	}

	public void selectRelevantIssue(String textInXpath) {
		String updatedXpath = relevantIssue.toString().replace("TextToReplace", textInXpath);
		String str = updatedXpath.substring(updatedXpath.lastIndexOf("//"));
		String str2 = str.substring(0, str.length() - 1);
		WebElement element = FindElement(str2);
		wait.forElementToBeVisible(element);
		click(element);
		lOGGER.info("Checking radio button " + textInXpath);
	}

	public void selectBillSeemsTooHigh() {

		wait.forElementToBeVisible(billSeemsTooHigh);
		click(billSeemsTooHigh);
		lOGGER.info("checking  radio button bill seems to high");
	}

	public void selectMechanicalParts() {

		wait.forElementToBeVisible(mechanicalParts);
		click(mechanicalParts);
		lOGGER.info("checking  radio button Mechanical  Parts");
	}

	public void selectCusomerService() {
		scrollToElementView(customerService);
		wait.forElementToBeVisible(customerService);
		click(customerService);
		lOGGER.info("Checking radio button customer service");
	}

	public void selectEngineIssue() {
		scrollToElementView(engineIssue);
		wait.forElementToBeVisible(engineIssue);
		click(engineIssue);
		lOGGER.info("Checking radio button engine Issue");
	}
	
	public void selectUnsafeVehicle() {
		wait.forElementToBeVisible(unsafeVehicle);
		click(unsafeVehicle);
		lOGGER.info("Checking radio button engine Issue");
	}

	public void selectAccountTransferredIncorrectly() {
		wait.forElementToBeVisible(accounttransferredincorrectly_radiobutton);
		click(accounttransferredincorrectly_radiobutton);
		lOGGER.info("Clicking on Account Transferred Incorrectly radio button");
	}

	public void selectMyInstructionsNotFollowed() {
		wait.forElementToBeVisible(myinstructionsnotfollowed_radiobutton);
		click(myinstructionsnotfollowed_radiobutton);
		lOGGER.info("Clicking on My instructions not followed radio button");
	}

	public void selectConnectionDisconnection() {

		wait.forElementToBeVisible(connection);
		click(connection);
		lOGGER.info("Checking radio button connection/Disconnection");
	}

	public void selectPromisedConnection() {

		wait.forElementToBeVisible(promisedConnection);
		click(promisedConnection);
		lOGGER.info("Checking radio button Promised connection didn't happen");
	}

	public void selectRelatedIssues() {
		selectBillAccount();
		selectPayingABill();
		doneChoosing();
	}

	public void selectIssuesExperienced() {
		selectBillSeemsTooHigh();
		selectCusomerService();
		doneChoosing();
	}

	public void selectRelatedIssues_SC02() {
		selectBillAccount();
		doneChoosing();
	}

	public void selectIssuesExperienced_SC02() {
		selectAccountTransferredIncorrectly();
		selectMyInstructionsNotFollowed();
		doneChoosing();
	}

	public void selectRelatedIssues_SC03() {
		selectPayingABill();
		doneChoosing();
	}

	public void selectIssuesExperienced_SC03() {
		needMoreTime();
		doneChoosing();
	}

	public void selectRelatedIssues_SC04() {
		selectPayments();
		doneChoosing();
	}

	public void selectIssuesExperienced_SC04() {
		selectUnAuthorizedTransantion();
		doneChoosing();
	}

	public void selectRelatedIssues_SC05() {
		selectMechanicalParts();
		doneChoosing();
	}

	public void selectIssuesExperienced_SC05() {
		selectEngineIssue();
		doneChoosing();
	}

	public void selectRelatedIssues_SC06() {
		selectConnectionDisconnection();
		doneChoosing();
	}

	public void selectIssuesExperienced_SC06() {
		selectMyInstructionsNotFollowed();
		selectPromisedConnection();
		doneChoosing();
	}

}
