package commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

	@FindBy(css = "[class='btn btn-pagenav btn-block']")
	static WebElement doneChoosing;

	@FindBy(xpath = "//div[@id='organisationList']")
	WebElement selectCompany;

	@FindBy(css = "div[class='row complaint-header']")
	WebElement complaintHeader;

	protected WebDriver driver;

	protected static ExplicitWait wait;

	protected static JavaScriptHelper js;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new ExplicitWait(driver);
		js = new JavaScriptHelper(driver);
		PageFactory.initElements(driver, this);
	}

	public static void click(WebElement webElement) {
		click(webElement, Timeouts.EXPLICIT);
	}

	public static void click(WebElement webElement, int timeOutInSeconds) {
		wait.forElementToBeClickable(webElement, timeOutInSeconds, Timeouts.POLLING_INTERVAL);
		js.clickElement(webElement);
	}

	public static void sendKeys(WebElement webElement, String value, int timeOutInSeconds) {
		click(webElement, timeOutInSeconds);
		webElement.clear();
		webElement.sendKeys(value);
	}

	public static void sendKeys(WebElement webElement, String value) {
		sendKeys(webElement, value, Timeouts.EXPLICIT);
	}

	public void executeJavascript(String string) {
		js.executeScript(string);
	}

	public void executeJavascript(String string, WebElement element) {
		js.executeScript(string, element);
	}

	public void dropDownMethod(WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("Value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("Index")) {
			int i = Integer.parseInt(value);
			s.selectByIndex(i);
		}
	}

	/* This method will validate partial text */
	public static boolean getTextPartialValidate(WebElement element, String value) {
		boolean flag = false;
		System.out.println("Extracted text is:" + element.getText());
		if (element.getText().contains(value)) {
			System.out.println("Partial Text comparsion is successful");
			flag = true;
		} else {
			System.out.println("Partial Text comparsion is unsuccessful");
		}
		return flag;

	}

	/* This is wrapper method to check the web element is displayed on the page */
	public boolean isElementPresence(WebElement webElement) {
		return webElement.isEnabled();
	}

	/* This method will clear the Text */
	public void clearText(WebElement element) {
		element.clear();
	}

	/* This method will scroll the web page till bottom of the page */
	public static void scrollToBottom() {

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/* This method will scroll the web page till top of the web page */
	public static void scrollToTop() {

		js.executeScript("window.scrollTo(0,0)");

	}

	public static void scrollToPixel(int px) {
		js.executeScript("window.scrollTo(0," + px + ")");
	}

	/* This is wrapper method to check the web element is displayed on the page */
	public boolean isElementDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	/* This method will scroll the web page Vertically till the element is found */
	public static void scrollToElementView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	/* This method will enter value in the input textbox */
	public static void javaScriptSendValue(WebElement element, String val) {
		js.executeScript("arguments[0].value='" + val + "';", element);

	}

	/* This method will click on the web element using javascriptexecutor */
	public static void javaScriptClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);

	}

	public static void actionsEnter() {
		js.actionEnter();
	}

	public WebElement FindElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doneChoosing() {
		wait.forElementToBeVisible(doneChoosing);
		scrollToElementView(doneChoosing);
		click(doneChoosing);
	}

	public void selectCompany(String txt) {
		sleep(3000);
		click(selectCompany.findElement(By.xpath(String.format("ul//a[text()='%s']", txt))));
	}

	public void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Boolean isRunningInsideDocker() {
		try (Stream<String> stream = Files.lines(Paths.get("/proc/1/cgroup"))) {
			return stream.anyMatch(line -> line.contains("/docker"));
		} catch (IOException e) {
			return false;
		}
	}

	public void clickOnComplaintHeader() {
		Actions action = new Actions(driver);
		action.click(complaintHeader).perform();
	}

}
