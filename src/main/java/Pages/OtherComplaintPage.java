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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class OtherComplaintPage extends BasePage {

	public OtherComplaintPage(WebDriver driver) {
		super(driver);
	}

	private static final Logger lOGGER = LogManager.getLogger(OtherComplaintPage.class.getName());

	@FindBy(css = "input#item_name")
	WebElement serviceIssue;

	@FindBy(css = "input#issue_description")
	WebElement describeIssue;

	@FindBy(css = "textarea#more-details-field")
	WebElement commentSection;

	@FindBy(css = "[class='btn btn-default btn-file']")
	WebElement chooseFile;

	public void enterServiceIssue(String text) {

		wait.forElementToBeVisible(serviceIssue);
		sendKeys(serviceIssue, text);
		lOGGER.info("Entering text into the Service Issue box");
	}

	public void enterDescriptionOfIssue(String text) {
		wait.forElementToBeVisible(describeIssue);
		sendKeys(describeIssue, text);
		lOGGER.info("Entering text into the Describe Issue box");
	}

	public void enterComment() {
		wait.forElementToBeVisible(commentSection);
		sendKeys(commentSection,
				"I made an online purchase through Amazon from seller, Bestbuy. I receive a defect Tshirt. I've called to obtain a replacement but the seller has refused saying I need to contact the courier company that delivered the item. The courier company is called Austrans Logistics. ");
		lOGGER.info("Entering text into the comment box");
	}

	public void enterDetailsOfComplaint() throws InterruptedException, IOException, AWTException {
		enterServiceIssue("I puchase a tshirt from Bestbuy on Amazon");
		enterDescriptionOfIssue("Defective Item, need refund");
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
