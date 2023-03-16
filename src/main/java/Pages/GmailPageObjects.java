package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commons.BasePage;

public class GmailPageObjects extends BasePage {

	@FindBy(how = How.CSS, css = "#identifierId")
	WebElement emailField;

	@FindBy(how = How.CSS, css = "#password input")
	WebElement passwordField;

	@FindBy(how = How.CSS, css = "span[class='bog']")
	List<WebElement> emailThreads;

	@FindBy(how = How.CSS, css = "img[class='gb_va']")
	WebElement profileLogo;

	@FindBy(xpath = "//span[contains(text(),' Resolve Your Complaint Now')]")
	WebElement resolveYourComplaint;

	@FindBy(xpath = "//span[contains(text(),' Update Us About Your Complaint')]")
	WebElement updateYourComplaint;

	@FindBy(css = "[class='btn btn-pagenav submit-prev-address btn-block']")
	WebElement submitButton_address;

	@FindBy(css = "[class ='btn btn-pagenav btn-block organisation-button']")
	WebElement submitButton_organisation;

	public static String parent = null;

	private static final Logger lOGGER = LogManager.getLogger(GmailPageObjects.class.getName());

	public GmailPageObjects(WebDriver driver) {
		super(driver);
	}

	public void clickEmail(String emailSubject) {
		wait.forElementToBeVisible(profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email clicked");
				break;
			}
		}
	}

	public void clickOnResolveYourComplaint() {
		scrollToPixel(500);
		wait.forPage();
		wait.forElementToBeVisible(resolveYourComplaint);
		click(resolveYourComplaint);
		lOGGER.info("clicking on Resolve your Complaint");
		wait.forPage();
	}

	public void clickOnUpdateYourComplaint() {
		scrollToPixel(500);
		wait.forPage();
		wait.forElementToBeVisible(updateYourComplaint);
		click(updateYourComplaint);
		lOGGER.info("clicking on update your Complaint");
		wait.forPage();
	}

	public void switchingIntoTheComplaintFlow() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		parent = driver.getWindowHandle();
		System.out.println(handles);
		Iterator<String> I1 = handles.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}

	}

	public void completeTheProcess_SC04() {
		wait.forPage();
		doneChoosing();
		wait.forPage();
		doneChoosing();
		wait.forPage();
		doneChoosing();
		wait.forPage();
		doneChoosing();
		wait.forPage();
		click(submitButton_address);
		wait.forPage();
		click(submitButton_organisation);
		wait.forPage();

	}

	public void goBacktoGmailScreen() {
		driver.switchTo().window(parent);
		lOGGER.info("Switching to Parent window");
	}

	public void navigateToResolveComplaint(String url) {

		do {
			System.out.println(driver.getCurrentUrl());
			pause(10000);
			driver.get(url);

		} while (!driver.getCurrentUrl().contains("https://staging.twohootsapp.com"));
	}

}
