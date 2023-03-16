package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyComplaint extends BasePage {

	@FindBy(css = "[class='btn btn-default btn-block']")
	WebElement myComplain;

	@FindBy(css = "[class='fa fa-chevron-right pull-right next-page']")
	WebElement SumittedComplaints;

	@FindBy(css = "#comments-field")
	WebElement SumittedComplaint_Update;

	@FindBy(css = "[class='btn btn-primary']")
	WebElement addUpdate;

	@FindBy(css = "[class='btn btn-pagenav btn-save btn-block btn-topspace btn-mark']")
	WebElement markedResolved;

	@FindBy(css = "[id=datepicker] button")
	WebElement calenderIcon;

	@FindBy(css = "[id=datepicker] input")
	WebElement calenderInputBox;

	@FindBy(css = "[for='rating-5']")
	WebElement fiveStarRating;

	@FindBy(css = "[class='btn btn-pagenav btn-save btn-block btn-topspace']")
	WebElement SubmitResolution;

	@FindBy(css = "[class='btn btn-primary btn-block']")
	WebElement viewYourComplaints;

	@FindBy(css = "div[class='col-md-12 text-center mar-top-10'] h1")
	WebElement textResolvedComplaint;

	private static final Logger lOGGER = LogManager.getLogger(MyComplaint.class.getName());

	public MyComplaint(WebDriver driver) {
		super(driver);
	}

	public void myComplainClick() {

		wait.forElementToBeVisible(myComplain);
		click(myComplain);
		lOGGER.info("Clicking on My Complain button");

	}

	public void submittedComplainsclick() {

		wait.forElementToBeVisible(SumittedComplaints);
		click(SumittedComplaints);
		lOGGER.info("Clicking on My subitted Complain description area");
	}

	public void writeComplain_Update(String text) {

		wait.forElementToBeVisible(SumittedComplaint_Update);
		sendKeys(SumittedComplaint_Update, text);
		lOGGER.info("Entering input into the Write a complaint update input field");
	}

	public void AddingfinalUpdate() {

		wait.forElementToBeVisible(addUpdate);
		click(addUpdate);
		lOGGER.info("Clicking on add update button");
	}

	public void markedAsResolvedClick() {

		wait.forElementToBeVisible(markedResolved);
		click(markedResolved);
		lOGGER.info("Clicking on marked as resolved button");
	}

	public void calenderIconClick() {

		wait.forElementToBeVisible(calenderIcon);
		calenderInputBox.clear();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		calenderInputBox.sendKeys(strDate);
		actionsEnter();
		lOGGER.info("Clicking on calaender");
	}

	public void rateFiveStar() {

		wait.forElementToBeVisible(fiveStarRating);
		click(fiveStarRating);
		lOGGER.info("Checking on five star Rating\"");
	}

	public void submitResolution() {

		wait.forElementToBeVisible(SubmitResolution);
		click(SubmitResolution);
		lOGGER.info("Clicking on Submit Resolution button");
	}

	public void ViewyourComplainClick() {

		wait.forElementToBeVisible(viewYourComplaints);
		click(viewYourComplaints);
		lOGGER.info("Clicking on view your complaints button");
	}

	public String getTextResolvedComplaint() {
		wait.forElementToBeVisible(textResolvedComplaint);
		lOGGER.info("Validating the resolved complaint message");
		return textResolvedComplaint.getText();
	}

	public void submitMyComplaint() {
		myComplainClick();
		submittedComplainsclick();
		writeComplain_Update("Everything has been resolved. Thanks for your help.");
		AddingfinalUpdate();

	}

	public void updateMyComplaint() {
		markedAsResolvedClick();
		calenderIconClick();
		rateFiveStar();
		submitResolution();

	}

}
