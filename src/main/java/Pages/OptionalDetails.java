
package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;
import commons.InitializePropertyFile;

public class OptionalDetails extends BasePage {

	@FindBy(css = "#outcome-field1")
	WebElement resolution;

	@FindBy(css = "#other-outcome1")
	WebElement outcome1;

	// Optional details
	@FindBy(css = "#impact-field")
	WebElement dropDown_EffectOfIssue;

	@FindBy(css = "#outcome-field1")
	WebElement dropDown_ResolutionIWant;

	@FindBy(css = "#outcome-field2")
	WebElement dropDown_2ndPriority;

	@FindBy(css = "#outcome-field3")
	WebElement dropDown_3rdPriority;

	@FindBy(css = "#contactattempts-field")
	WebElement dropDown_ContactAttempt;

	@FindBy(css = "select[id*='experience-field'][style*='block']")
	WebElement dropDown_YourExperience;

	@FindBy(css = "#referencenumber-field")
	WebElement Textbox_AddRefrence;

	@FindBy(css = "#accountnumber-field")
	WebElement Textbox_AccountNumber;

	@FindBy(css = "#comments-field")
	WebElement Textbox_DescriptionBox;

	@FindBy(css = "[name='other-impact']")
	WebElement pleasespecifyeffect_inputfield;

	@FindBy(xpath = "//div[contains(@id, 'outcome-field')]")
	static WebElement pleasespecifyresolution_inputfield;

	@FindBy(css = "[name='other-experience']")
	WebElement experienceData;

	@FindBy(css = "[class='btn btn-default btn-file']")
	WebElement chooseFile;

	private final Logger lOGGER = LogManager.getLogger(OptionalDetails.class.getName());

	public OptionalDetails(WebDriver driver) {
		super(driver);
	}

	public void resolution() {
		wait.forElementToBeVisible(resolution);
		Select ab = new Select(resolution);
		ab.selectByValue("10");

	}

	public void outcome1() {
		wait.forElementToBeVisible(outcome1);
		sendKeys(outcome1, "payment plan");
	}

	public void EffectofIssue(String value) {

		wait.forElementToBeVisible(dropDown_EffectOfIssue);
		dropDownMethod(dropDown_EffectOfIssue, "VisibleText", value);
		lOGGER.info("Selecting values from What's the Effect of Issue dropdown field");

	}

	public void ResolutionIWant(String value) {

		wait.forElementToBeVisible(dropDown_ResolutionIWant);
		dropDownMethod(dropDown_ResolutionIWant, "VisibleText", value);
		lOGGER.info("Selecting values from resoltion i most want  dropdown field\"");

	}

	public void SecondPriority(String value) {

		wait.forPage();
		scrollToElementView(dropDown_2ndPriority);
		wait.forElementToBeVisible(dropDown_2ndPriority);
		dropDownMethod(dropDown_2ndPriority, "VisibleText", value);
		lOGGER.info("Selecting values from Second Priority dropdown field");

	}

	public void ThirdPriority(String value) {

		wait.forPage();
		scrollToElementView(dropDown_3rdPriority);
		wait.forElementToBeVisible(dropDown_3rdPriority);
		dropDownMethod(dropDown_3rdPriority, "VisibleText", value);
		lOGGER.info("Selecting values from Third dropdown field");

	}

	public void NumberOfContactAtempts(String value) {

		wait.forPage();
		scrollToElementView(dropDown_ContactAttempt);
		wait.forElementToBeVisible(dropDown_ContactAttempt);
		dropDownMethod(dropDown_ContactAttempt, "VisibleText", value);
		lOGGER.info("Selecting values from Number of contacts attempt dropdown field");

	}

	public void YourExperience(String value) {

		wait.forElementToBeVisible(dropDown_YourExperience);
		dropDownMethod(dropDown_YourExperience, "VisibleText", value);
		lOGGER.info("Selecting values from your experience with staff dropdown field");

	}

	public void AddRefrenceNo(String text) {

		wait.forElementToBeVisible(Textbox_AddRefrence);
		sendKeys(Textbox_AddRefrence, text);
		lOGGER.info("Entering input into the Add refrence number input field");

	}

	public void AddAccountNo(String text) {

		wait.forElementToBeVisible(Textbox_AccountNumber);
		sendKeys(Textbox_AccountNumber, text);
		lOGGER.info("Entering input into the Add Account Number input field");

	}

	public void CommentSection(String text) {

		scrollToElementView(Textbox_DescriptionBox);
		wait.forElementToBeVisible(Textbox_DescriptionBox);
		sendKeys(Textbox_DescriptionBox, text);
		lOGGER.info("Entering input into the Add Account Number input field");

	}

	public void enterOptionDetails() {
		EffectofIssue("Caused stress / anxiety");
		ResolutionIWant("Amount owed reduced");
		SecondPriority("Manager involvement");
		ThirdPriority("Apology");
		NumberOfContactAtempts("Twice");
		YourExperience("Rude staff");
		AddRefrenceNo("X789");
		AddAccountNo("521678");
		CommentSection("One staff member, Ellie, was rude.");
		doneChoosing();

	}

	public void enterTheSpecifiedEffect(String text) {
		wait.forElementToBeVisible(pleasespecifyeffect_inputfield);
		sendKeys(pleasespecifyeffect_inputfield, text);
		lOGGER.info("Entering the value  in please specify the effect input field");
	}

	public void enterTheSpecifiedResolution(String priority, String text) {
		wait.forElementToBeVisible(pleasespecifyresolution_inputfield
				.findElement(By.xpath(String.format("//input[@id='other-outcome%s']", priority))));
		sendKeys(pleasespecifyresolution_inputfield
				.findElement(By.xpath(String.format("//input[@id='other-outcome%s']", priority))), text);
		lOGGER.info("Entering the value  in please specify the resolution input field");
	}

	public void enterOptionDetails_SC02() throws IOException, AWTException, InterruptedException {
		EffectofIssue("Other");
		enterTheSpecifiedEffect("Losing my phone number");

		ResolutionIWant("Other");
		selectOtherResolutionPriority("1", "Account transfer reversed");
//		enterTheSpecifiedResolution("Account transfer reversed");
		scrollToPixel(50);
		SecondPriority("Issue fixed");
		ThirdPriority("Apology");
		NumberOfContactAtempts("This is the first complaint");
		wait.forPage();
		YourExperience("Problem is urgent");
		if(!isRunningInsideDocker()) 
			fileUpload(InitializePropertyFile.property.getProperty("TC02_file"));
		CommentSection("Please save my mobile phone number from being lost");
		doneChoosing();

	}

	public void enterOptionDetails_SC07() {
		EffectofIssue("Inconvenience");
		ResolutionIWant("Other");
		selectOtherResolutionPriority("1", "Replacement Item");
//		enterTheSpecifiedResolution("Replacement Item");
		scrollToPixel(50);
		SecondPriority("Explanation");
		NumberOfContactAtempts("Once");
		wait.forPage();
		YourExperience("Staff couldn't resolve due to policy");
		doneChoosing();

	}

	public void inputExperienceData(String text) {
		wait.forElementToBeVisible(experienceData);
		sendKeys(experienceData, text);
		lOGGER.info("Entering the value  in  experience input field");
	}

	public void enterOptionDetails_SC04() {
		EffectofIssue("Other");
		enterTheSpecifiedEffect("Credit Score");
		ResolutionIWant("Issue fixed");
		scrollToPixel(50);
		NumberOfContactAtempts("Twice");
		scrollToPixel(500);
		YourExperience("Other");
		inputExperienceData("Bank declined the dispute twice");

	}

	public void enterOptionDetails_SC05() {
		EffectofIssue("Cost money");
		ResolutionIWant("Issue fixed");
		SecondPriority("Manager involvement");
		NumberOfContactAtempts("Twice");
		YourExperience("Staff couldn't resolve due to policy");
		CommentSection(
				"Fords has said they will not pay for the engine to be fixed. I have documents to show how many time has been repaired previously.");
		doneChoosing();
	}

	public void enterOptionDetails_SC08() {
		EffectofIssue("Other");
		enterTheSpecifiedEffect("Dangerous car");
		ResolutionIWant("Policy change");
		SecondPriority("Apology");
		ThirdPriority("Other");
		selectOtherResolutionPriority("3", "car off road");
		NumberOfContactAtempts("This is the first complaint");
		YourExperience("They have gone out of business");
		AddRefrenceNo("121212");
		AddAccountNo("343434");
		CommentSection("Please help");
		doneChoosing();
	}

	private void selectOtherResolutionPriority(String priorityNumber, String text) {
		enterTheSpecifiedResolution(priorityNumber, text);
	}

	public void enterOptionDetails_SC06() {
		EffectofIssue("Lost business");
		ResolutionIWant("Issue fixed");
		doneChoosing();
	}

	public void enterOptionDetails_SC04_Part2() {
		EffectofIssue("Other");
		enterTheSpecifiedEffect("Credit Score");
		ResolutionIWant("Issue fixed");
		scrollToPixel(50);
		NumberOfContactAtempts("Twice");
		scrollToPixel(500);
		YourExperience("Other");
		inputExperienceData("Bank declined the dispute twice");
		AddRefrenceNo("12345");
		AddAccountNo("45678");
		CommentSection("Very important to resolve the unauthorised transaction, as my credit score will be impacted.");
		doneChoosing();
	}

	public void enterOptionDetails_SC03() throws InterruptedException, IOException, AWTException {
		ResolutionIWant("Other");
		selectOtherResolutionPriority("1", "Payment plan");
		if(!isRunningInsideDocker()) 
			fileUpload(InitializePropertyFile.property.getProperty("TC03_file"));
		CommentSection("My mum needs to go on a payment plan");
		doneChoosing();
	}

	public void fileUpload(String fileName) throws InterruptedException, IOException, AWTException {
		
		
		wait.forElementToBeVisible(chooseFile);
		click(chooseFile);
		Thread.sleep(5000);
		setClipboardData(fileName);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}

	public static void setClipboardData(String fileName) {
		String filePath = System.getProperty("user.dir") + File.separator + "files" + File.separator + fileName;
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}

}
