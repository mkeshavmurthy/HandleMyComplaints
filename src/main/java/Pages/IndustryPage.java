package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class IndustryPage extends BasePage {

	private static final Logger lOGGER = LogManager.getLogger(IndustryPage.class.getName());

	@FindBy(css = "i[class='fa fa-lightbulb-o']")
	WebElement energyLogo;

	@FindBy(css = "i[class='fa fa-phone']")
	WebElement telcoIcon;

	@FindBy(css = "i[class='fa fa-usd']")
	WebElement bankingIcon;

	@FindBy(css = "i[class='fa fa-car']")
	WebElement automotiveIcon;

	@FindBy(css = "[class='fa fa-question']")
	WebElement otherIcon;

	public IndustryPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnEnergyLogoButton() {

		wait.forElementToBeVisible(energyLogo);
		click(energyLogo);
		lOGGER.info("Clicking on the energy icon");
	}

	public void clickOnTelcoLogoButton() {
		wait.forElementToBeVisible(telcoIcon);
		click(telcoIcon);
		lOGGER.info("Clicking on Telco icon field");
	}

	public void clickOnBankingLogoButton() {
		wait.forElementToBeVisible(bankingIcon);
		click(bankingIcon);
		lOGGER.info("Clicking on banking icon field");
	}

	public void clickOnAutomotiveLogoButton() {
		wait.forElementToBeVisible(automotiveIcon);
		click(automotiveIcon);
		lOGGER.info("Clicking on automotive icon field");
	}

	public void clickOnOtherLogoButton() {
		wait.forElementToBeVisible(otherIcon);
		click(otherIcon);
		lOGGER.info("Clicking on other Icon field");
	}

}
