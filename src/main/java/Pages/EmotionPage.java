package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class EmotionPage extends BasePage {

	public EmotionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[for='Disappointed']")
	WebElement disappointed;

	@FindBy(css = "[for='Very frustrated']")
	WebElement veryFrusratedEmoji;

	@FindBy(css = "[for='I&rsquo;ve been better']")
	WebElement haveBeenBetter;

	@FindBy(css = "[for='I&rsquo;m hopping mad']")
	WebElement hoppingMind;

	@FindBy(css = "[for='Quite happy']")
	WebElement quiteHappy;

	private static final Logger lOGGER = LogManager.getLogger(EmotionPage.class.getName());

	public void selectDisappointed() {
		wait.forElementToBeVisible(disappointed);
		click(disappointed);
		lOGGER.info("Selecting emoji Very disappointed");
		doneChoosing();
	}

	public void selectingVeryFrustratedEmoji() {

		wait.forElementToBeVisible(veryFrusratedEmoji);
		click(veryFrusratedEmoji);
		lOGGER.info("Selecting emoji Very frustrated");
		doneChoosing();
	}

	public void beenBetter() {
		wait.forElementToBeVisible(haveBeenBetter);
		click(haveBeenBetter);
		doneChoosing();
	}

	public void selectingHopingMind() {
		wait.forElementToBeVisible(hoppingMind);
		click(hoppingMind);
		lOGGER.info("Selecting emoji hoppingMind");
		doneChoosing();

	}

	public void selectingQuiteHappy() {
		wait.forElementToBeVisible(quiteHappy);
		click(quiteHappy);
		lOGGER.info("Selecting emoji quite Happy");
		doneChoosing();

	}

}
