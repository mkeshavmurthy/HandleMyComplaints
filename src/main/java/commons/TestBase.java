package commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import listener.ListenerTest;

@Listeners(ListenerTest.class)
public class TestBase {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		this.driver = createDriver();
		setUpWebDriver(driver);
		InitializePropertyFile.loadPropertyFile();
	}

	@AfterMethod
	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@BeforeSuite
	public void deleteUsers() throws Exception {
		setUp();
		driver.get(InitializePropertyFile.property.getProperty("DeleteUsersURL"));
		driver.quit();
	}

	private WebDriver createDriver() {
		String hubUrl = System.getProperty("hubUrl");

		// If the hubUrl is specified use the remote driver, else try to use the local
		// chrome driver.
		if (hubUrl != null) {
			String browserName = System.getProperty("browserName");
			if (browserName == null) {
				throw new RuntimeException("You must specify a browserName");
			}
			try {
				return new RemoteWebDriver(new URL(hubUrl), getOptions(browserName));
			} catch (MalformedURLException e) {
				throw new RuntimeException("The supplied hubUrl: " + hubUrl + " is not a valid url.");
			}
		} else {

			// If we're not using a hub, then attempt to instantiate a local chrome driver.
			String driverPath = System.getProperty("webdriver.chrome.driver");
			if (driverPath == null) {
				throw new RuntimeException("You must specify either a hubUrl or a webdriver.chrome.driver path.");
			}
			return new ChromeDriver((ChromeOptions) getOptions("chrome"));
		}
	}

	private MutableCapabilities getOptions(String browserName) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browserName);

		if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			return options.merge(cap);
		}

		if (browserName.equals("internetExplorer")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			return options.merge(cap);
		}

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-gpu");
			options.addArguments("--disable-print-preview");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("-incognito");
			return options.merge(cap);
		}

		throw new RuntimeException(browserName + " is an invalid browserName.");
	}

	private static void setUpWebDriver(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGE, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Timeouts.PAGE, TimeUnit.SECONDS);
	}

	public void maintainSameSession() {
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

}