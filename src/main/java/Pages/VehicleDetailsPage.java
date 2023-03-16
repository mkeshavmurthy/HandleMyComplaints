package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;

public class VehicleDetailsPage extends BasePage {

	public VehicleDetailsPage(WebDriver driver) {
		super(driver);
	}

	private static final Logger lOGGER = LogManager.getLogger(VehicleDetailsPage.class.getName());

	@FindBy(css = "select[class='form-control']")
	List<WebElement> vehicle_dropdown;

	@FindBy(css = "form[class='list-form'] select[class='form-control']")
	List<WebElement> vehiclecost;

	@FindBy(css = "input[class='form-control']")
	List<WebElement> vehicleManufactureDetails;

	@FindBy(id = "currently_owed")
	WebElement currentlyOwed;

	@FindBy(id = "finance_company")
	WebElement financeCompany;

	@FindBy(id = "prob")
	WebElement problem;

	@FindBy(css = "#manufacturer_handbook")
	WebElement handbook;

	@FindBy(css = "#ppsr_report")
	WebElement ppsr;

	@FindBy(css = "input[name='problems_date']")
	WebElement problemsDate;

	@FindBy(id = "faults")
	WebElement numberOfFaults;

	@FindBy(id = "repair")
	WebElement numberOfRepairAttempts;

	@FindBy(css = "span[class='select2-selection select2-selection--multiple']")
	WebElement specifyProblem;

	public void AddVehicleDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add("VIC");
		datalist.add("New (from Dealership)");
		datalist.add("2012");
		datalist.add("Automatic");
		datalist.add("Ford");
		datalist.add("Fiesta CL WT Auto");
		datalist.add("Yes");

		for (int i = 0; i < datalist.size(); i++) {
			scrollToElementView(vehicle_dropdown.get(i));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dropDownMethod(vehicle_dropdown.get(i), "VisibleText", datalist.get(i));

		}

	}

	public void addVehicleDetailsSC_08() {
		List<String> datalist = new ArrayList<String>();
		datalist.add("QLD");
		datalist.add("Used (from Dealership)");
		datalist.add("2008");
		datalist.add("Automatic");
		datalist.add("Audi");
		datalist.add("A4 Auto");
		datalist.add("Yes");

		for (int i = 0; i < datalist.size(); i++) {
			scrollToElementView(vehicle_dropdown.get(i));
			wait.forPage();
			dropDownMethod(vehicle_dropdown.get(i), "VisibleText", datalist.get(i));

		}
	}

	public void AddVehicleCostDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add(0, "");
		datalist.add(1, "2");
		datalist.add(2, "");
		datalist.add(3, "1");
		datalist.add(4, "2");
		datalist.add(5, "4");
		datalist.add(6, "Towing");
		datalist.add(7, "Hire-car");
		datalist.add(8, "Taxis");
		datalist.add(9, "Independent mechanical report");
		datalist.add(10, "");
		datalist.add(11, "Dealership");
		datalist.add(12, "ACCC");
		datalist.add(13, "Fair Trading / Consumer Affairs");
		datalist.add(14, "Media");

		System.out.println(datalist);
		for (String data : datalist) {
			System.out.println(data);
			if (!data.equals("")) {
				int index = datalist.indexOf(data);
				scrollToElementView(vehiclecost.get(index));
				wait.forPage();
				dropDownMethod(vehiclecost.get(index), "VisibleText", data);
			}

		}

	}

	public void AddVehicleManufactureDetails() {
		List<String> datalist = new ArrayList<String>();
		datalist.add("1EDGV");
		datalist.add("12345678901231111");
		datalist.add("26700");
		datalist.add("24000");
		datalist.add("13-09-2012");
		datalist.add("30-12-2011");
		datalist.add("1/9/2012");
		datalist.add("14-09-2012");

		for (int i = 0; i < datalist.size(); i++) {
			scrollToElementView(vehicleManufactureDetails.get(i));
			wait.forPage();
			sendKeys(vehicleManufactureDetails.get(i), datalist.get(i));

		}

	}

	public void inputFinanceAmount(String amt) {
		wait.forElementToBeVisible(currentlyOwed);
		scrollToElementView(currentlyOwed);

		sendKeys(currentlyOwed, amt);
		lOGGER.info("Entering the finance / loan amount");

	}

	public void inputCompany(String txt) {
		wait.forElementToBeVisible(financeCompany);
		scrollToElementView(financeCompany);
		sendKeys(financeCompany, txt);
		lOGGER.info("Entering the finance Company");
		selectCompany(txt);
	}

	public void selectManufactureHandbook(String value) {
		wait.forElementToBeVisible(handbook);
		scrollToElementView(handbook);
		dropDownMethod(handbook, "VisibleText", value);
	}

	public void selectPPSRReport(String value) {
		wait.forElementToBeVisible(ppsr);
		scrollToElementView(ppsr);
		dropDownMethod(ppsr, "VisibleText", value);
	}

	public void selectNumberOfFaults(String value) {
		wait.forElementToBeVisible(numberOfFaults);
		scrollToElementView(numberOfFaults);
		dropDownMethod(numberOfFaults, "VisibleText", value);
	}

	public void selectNumberOfRepairAttempts(String value) {
		wait.forElementToBeVisible(numberOfRepairAttempts);
		scrollToElementView(numberOfRepairAttempts);
		dropDownMethod(numberOfRepairAttempts, "VisibleText", value);
	}

	public void inputVehileDetails_SC05() {
		AddVehicleDetails();
		wait.forPage();
		inputFinanceAmount("7000");
		sleep(6000);
		inputCompany("Commonwealth Bank of Australia");
		selectManufactureHandbook("Yes");
		doneChoosing();
	}

	public void inputVehileDetails_SC08() {
		addVehicleDetailsSC_08();
		wait.forPage();
		inputFinanceAmount("10000");
		inputCompany("CBA");
		selectManufactureHandbook("Yes");
		selectPPSRReport("Unsure");
		doneChoosing();

	}

	public void inputVehileMenufactureDetails_SC05() {
		AddVehicleManufactureDetails();
		wait.forPage();
		doneChoosing();

	}

	public void inputVehileMenufactureDetails_SC08() {
		List<String> datalist = new ArrayList<String>(8);
		datalist.add(0, "REX99E");
		datalist.add(1, "");
		datalist.add(2, "200000");
		datalist.add(3, "20000");
		datalist.add(4, "20-09-2020");
		datalist.add(5, "20-09-2020");
		datalist.add(6, "20-09-2020");
		datalist.add(7, "20-09-2020");

		for (int i = 0; i < datalist.size(); i++) {
			scrollToElementView(vehicleManufactureDetails.get(i));
			sendKeys(vehicleManufactureDetails.get(i), datalist.get(i));

		}
		wait.forPage();
		doneChoosing();

	}

	public void enterProblemDates(String date) {

		wait.forElementToBeVisible(problemsDate);
		scrollToElementView(problemsDate);
		sendKeys(problemsDate, date);
		clickOnComplaintHeader();
		lOGGER.info("Entering the Problems Date");

	}

	public void specifyProblem(String text) {
		wait.forElementToBeVisible(specifyProblem);
		scrollToElementView(specifyProblem);
		specifyProblem.sendKeys(text);
		specifyProblem.sendKeys(Keys.ENTER);
		lOGGER.info("Entering the Problem Facing");
	}

	public void addRepairAttempts_SC05() {
		enterProblemDates("14-09-2012");
		wait.forPage();
		selectNumberOfFaults("1");
		wait.forPage();
		selectNumberOfRepairAttempts("3");
		wait.forPage();
		specifyProblem("Engine");
		doneChoosing();

	}

	public void addRepairAttempts_SC08() {
		enterProblemDates("30-09-2020");
		wait.forPage();
		selectNumberOfFaults("3");
		wait.forPage();
		selectNumberOfRepairAttempts("2");
		wait.forPage();
		Select prob = new Select(problem);
		prob.selectByIndex(1);
		prob.selectByIndex(2);
		prob.selectByIndex(3);
		doneChoosing();

	}

	public void addVehicleCost_SC05() {
		AddVehicleCostDetails();
		doneChoosing();
	}

	public void addVehicleCost_SC08() {
		List<String> datalist = new ArrayList<String>();
		datalist.add("1");
		datalist.add("1");
		datalist.add("1");
		datalist.add("2");
		datalist.add("2");
		datalist.add("2");

		System.out.println(datalist);
		for (int i = 0; i < 6; i++) {
			dropDownMethod(vehiclecost.get(i), "VisibleText", datalist.get(i));
		}
		doneChoosing();
	}

}
