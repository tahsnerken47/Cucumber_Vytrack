package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//tr[4]/td[9]//a")
    //tbody/tr[4]/td[9]/div[1]/div[1]/a[1]
    private WebElement threeDots;

    @FindBy(xpath = "/html/body/ul/li/ul/li[3]/a/i")
    private WebElement trachBinIcon;

    @FindBy(xpath = "/html/body/ul/li/ul/li[2]/a/i")
    private WebElement editIcon;

    @FindBy(xpath = "/html/body/ul/li/ul/li[1]/a/i")
    private WebElement eyeIcon;

    @FindBy(xpath = "//a[@href='#'][@title='Grid Settings']")
    private WebElement gridOption;

    @FindBy(xpath = "//thead[@class='grid-header']/tr/th[2]/a/span")
    private WebElement titleColumn;

    @FindBy (xpath = "//input[contains(@id,'column-c')]")
    private List<WebElement> allCheckBoxes;

    @FindBy (id = "column-c1419")
    private WebElement invitationStatus;

    @FindBy (xpath = "(//a[@href='/calendar/event/create'])[3]")
    private WebElement createCalendarEventButton;

    @FindBy (xpath = "//a[@href='#'][@class='btn-success btn dropdown-toggle']")
    private WebElement saveAndCloseDropdown;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[1]")
    private WebElement saveAndCloseOption;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[2]")
    private WebElement saveAndNewOption;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[3]")
    private WebElement saveOption;

    @FindBy(xpath = "//a[@href='/calendar/event'][@data-action='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='btn-toolbar']/div/div/h1")
    private WebElement allCalendarEventsSubtitle;

    @FindBy(xpath = "//div[@class='control-group start control-group-datetime']/div/div/input[2]")
    private WebElement startTime;

    @FindBy(xpath = "//div[@class='control-group end control-group-datetime']/div[2]/div/input[2]")
    private WebElement endTime;

    @FindBy(xpath = "/html/body/div[7]/ul/li[43]")
    private WebElement ninePM;

    @FindBy(xpath = "//*[contains(@id,'oro_calendar_event_form_allDay')]")
    private WebElement allDayEventCheckbox;

    @FindBy(xpath = "//*[contains(@id,'time_selector_oro_calendar_event_form_start')]")
    private WebElement startTimeInputbox;

    @FindBy(xpath = "//*[contains(@id,'time_selector_oro_calendar_event_form_end-uid')]")
    private WebElement endTimeInputbox;

    @FindBy(xpath = "//*[contains(@id,'date_selector_oro_calendar_event_form_start')]")
    private WebElement startDateInputbox;

    @FindBy(xpath = "//*[contains(@id,'date_selector_oro_calendar_event_form_end-uid')]")
    private WebElement endDateInputbox;

    @FindBy(xpath = "//input[contains(@id,'recurrence-repeat-view')]")
    private WebElement repeatCheckbox;

    @FindBy(xpath = "(//*[contains(@id,'recurrence-repeats-view')])[2]")
    private WebElement repeatDropdown;

    @FindBy(xpath = "//input[@type='radio'][@checked='checked']")
    private WebElement repeatEveryCheckBox;

    @FindBy(xpath = "//div[@data-name='recurrence-ends']//div//div[2]//div//label/input")
    private WebElement neverCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    private WebElement summaryText;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items'][@data-name='control-sections']//div[2]//label//input")
    private WebElement afterRadioButton;

    @FindBy(xpath = "//div[@data-page-component-name='calendar-event-recurrence'][@data-bound-component='orocalendar/js/app/components/calendar-event-recurrence-component']/div[2]/div[6]/div/div[2]/div[2]/label/input[2]")
    private WebElement afterInputbox;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    private WebElement dailySummaryText;

    @FindBy(xpath = "//span[contains(text(),'end after 10 occurrences')]")
    private WebElement occurrencesSummaryText;

    String expectedSummary;
    String actualSummary;

    @FindBy(xpath = "//div[@class='recurrence-subview-control__item recurrence-subview-control__item-datetime']/label/input")
    private WebElement ByRadioButton;

    @FindBy(xpath = "//span[@class='recurrence-subview-control__datetime-wrapper']/div/input[2]")
    private WebElement chooseADateCalendarBox;

    @FindBy(xpath = "//select[ @class='ui-datepicker-month']")
    private WebElement pickAMonthBox;

    @FindBy(xpath = "//a[contains(text(),'18')]")
    private WebElement dayPicker;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']/select[2]")
    private WebElement yearPicker;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']/div[2]/div/span")
    private WebElement summaryText1;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']/div[2]/div/span[2]")
    private WebElement summaryText2;

    @FindBy(xpath = "//div[@data-name='recurrence-settings']/div/div[2]/div/select")
    private WebElement repeatsDropdown;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control']/div/div/label[2]/input")
    private WebElement mondayCheckbox;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control']/div/div/label[6]/input")
    private WebElement fridayCheckbox;

    public void hoverOnThreeDots() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(threeDots).perform();

        Assert.assertTrue("Trashbin icon verification failed", trachBinIcon.isDisplayed());
        Assert.assertTrue("Edit icon verification failed", editIcon.isDisplayed());
        Assert.assertTrue("Eye icon verification failed", eyeIcon.isDisplayed());
    }

    public void areViewEditAndDeleteOptionsDisplayedVerification() {
        Assert.assertTrue("Trashbin icon is NOT displayed!!", trachBinIcon.isDisplayed());
        Assert.assertTrue("Eye icon is NOT displayed!!", eyeIcon.isDisplayed());
        Assert.assertTrue("Edit icon is NOT displayed!!", editIcon.isDisplayed());
    }

    public void clickOnGridOption() {
        gridOption.click();
    }

    public void titleColumnAssertion() {
        Assert.assertTrue("Title column is NOT displayed!!", titleColumn.isDisplayed());
    }

    public void deselectAllGridCheckBoxList() {

        for (int i = 1; i < allCheckBoxes.size(); i++) {
            allCheckBoxes.get(i).click();
            Assert.assertFalse("The element is NOT deselected!!", allCheckBoxes.get(i).isSelected());
        }
    }

    public void clickOnCreateCalendarEventButton() {
        createCalendarEventButton.click();
    }

    public void clickOnSaveAndCloseDropdown(){
        saveAndCloseDropdown.click();
    }

    public void saveCloseNewOptionsAssertion() {
        Assert.assertTrue("\"Save and close option is NOT displayed!!\"", saveAndCloseOption.isDisplayed());
        Assert.assertTrue("\"Save and new option is NOT displayed!!\"", saveAndNewOption.isDisplayed());
        Assert.assertTrue("\"Save option is NOT displayed!!\"", saveOption.isDisplayed());
    }

    public void clickOnCancelButton() {
        BrowserUtils.clickOnElement(cancelButton);
    }

    public void allCalendarEventsSubtitleAssertion() {
        Assert.assertTrue("All Calendar Events pages subtitle is NOT displayed!!", allCalendarEventsSubtitle.isDisplayed());
    }

    public void differenceBetweenEndAndStartTime(int difference) {

        StringBuilder stringBuilderStartTime = new StringBuilder(startTime.getAttribute("value"));
//        System.out.println("stringBuilderStartTime = " + stringBuilderStartTime);
        stringBuilderStartTime.delete(stringBuilderStartTime.length() - 3, stringBuilderStartTime.length());
        int indexNo = stringBuilderStartTime.indexOf(":");
        stringBuilderStartTime.delete(indexNo, indexNo + 1);
        stringBuilderStartTime.insert( indexNo, '.');
        String stringStartTime = stringBuilderStartTime.toString();
//        System.out.println("stringStartTime = " + stringStartTime);
        double doubleStartTimeDigits = Double.valueOf(stringStartTime);

        StringBuilder stringBuilderEndTime = new StringBuilder(endTime.getAttribute("value"));
        stringBuilderEndTime.delete(stringBuilderEndTime.length() - 3, stringBuilderEndTime.length());
        indexNo = stringBuilderEndTime.indexOf(":");
        stringBuilderEndTime.delete(indexNo, indexNo + 1);

        stringBuilderEndTime.insert(indexNo, '.');
        String stringEndTime = stringBuilderEndTime.toString();
        System.out.println("stringBuilderEndTime = " + stringBuilderEndTime);
        double doubleEndTimeDigits = Double.valueOf(stringEndTime);

//        System.out.println("doubleStartTimeDigits = " + doubleStartTimeDigits);
//        System.out.println("doubleEndTimeDigits = " + doubleEndTimeDigits);

        String lastTwoCharactersOfStartTime = startTime.getAttribute("value").substring(startTime.getAttribute("value").length() - 2);
        String lastTwoCharactersOfEndTime = endTime.getAttribute("value").substring(endTime.getAttribute("value").length() - 2);

//        System.out.println("lastTwoCharactersOfStartTime = " + lastTwoCharactersOfStartTime);
//        System.out.println("lastTwoCharactersOfEndTime = " + lastTwoCharactersOfEndTime);

        Assert.assertTrue("The difference between start and end time is NOT 1 hour!!", doubleStartTimeDigits + difference == doubleEndTimeDigits);
        Assert.assertTrue("The difference between start and end time is NOT 1 hour!!", lastTwoCharactersOfStartTime .equals(lastTwoCharactersOfEndTime));
    }

    public void imsert9PM(String string) {

        BrowserUtils.wait(2);
        startTime.sendKeys("9:00 PM" + Keys.INSERT);
        BrowserUtils.wait(2);
        BrowserUtils.clickWithJS(ninePM);
//        ((JavascriptExecutor)Driver.getDriver()).executeScript("document.location.reload()");
    }

    public void endTime10PMVerification() {
        String expectedEndTime = "10:00 PM";
        String actualEndTime = endTime.getAttribute("value");

        System.out.println("actualEndTime = " + actualEndTime);
        System.out.println("expectedEndTime = " + expectedEndTime);

        Assert.assertTrue("End time is NOT equal to 10:00 PM!!", actualEndTime.equals(expectedEndTime));
    }


    public void clickAllDayEventCheckbox() {
        BrowserUtils.clickWithJS(allDayEventCheckbox);
        BrowserUtils.wait(2);
    }

    public void starEndTimeInputBoxesNotDisplayed() {
        Assert.assertFalse("Start time input box is NOT displayed!!", startTimeInputbox.isDisplayed());
        Assert.assertFalse("End time input box is NOT displayed!!", endTimeInputbox.isDisplayed());
    }

    public void starEndTimeDateBoxessDisplayed() {
        Assert.assertFalse("Start date input box is NOT displayed!!", startTimeInputbox.isDisplayed());
        Assert.assertFalse("End date input box is NOT displayed!!", endTimeInputbox.isDisplayed());
    }

    public void clickRepeatCheckbox() {
        BrowserUtils.clickWithJS(repeatCheckbox);
        BrowserUtils.wait(2);
    }

    public void repeatDropdownOptions() {
        Select select = new Select(repeatDropdown);
        List<WebElement> allOptions = new ArrayList<>(select.getOptions());

        List<String> allStringOptions = new ArrayList<>();
        allStringOptions.addAll(Arrays.asList("Daily", "Weekly", "Monthly", "Yearly"));

        for (int i = 0; i < allStringOptions.size(); i++) {
            Assert.assertTrue("Repeat dropdown options are NOT displayed!!", allOptions.get(i).getText().equals(allStringOptions.get(i)));
        }
    }

    public void repeatCheckboxSelected() {
        Assert.assertTrue("Repeat checkbox is NOT selected!!", repeatCheckbox.isSelected());
    }

    public void neverCheckboxSelected() {
        Assert.assertTrue("Never checkbox is NOT selected!!", neverCheckbox.isSelected());
    }

    public void summaryText(int number) {
        Assert.assertTrue("The summary of Daily every " + number + " day is NOT displayed!!", summaryText.isDisplayed());
    }

    public void occurrences(int number) {
        BrowserUtils.clickWithJS(afterRadioButton);
        BrowserUtils.enterText(afterInputbox, String.valueOf(number));
        BrowserUtils.clickOnElement(summaryText);

        expectedSummary = "Daily every 1 day, end after " + number + " occurrences";
        actualSummary = summaryText.getText() + occurrencesSummaryText.getText();
    }

    public void summary_daily_occurrences() {
        Assert.assertTrue("Daily every 1 day, end after 10 occurrences is NOT displayed!!", expectedSummary.equals(actualSummary));
    }

    public void pickFromChooseADateCalendarBox() {
        BrowserUtils.clickWithJS(ByRadioButton);
        BrowserUtils.clickWithJS(chooseADateCalendarBox);
        Select selectYear = new Select(yearPicker);
        selectYear.selectByVisibleText("2021");
        Select selectMonth = new Select(pickAMonthBox);
        selectMonth.selectByVisibleText("Nov");
        BrowserUtils.clickOnElement(dayPicker);
    }

    public void summaryVerification(int day, int year) {
        expectedSummary = "Daily every 1 day, end by Nov " + day + ", " + year;
        actualSummary = summaryText1.getText() + summaryText2.getText();

        Assert.assertTrue("\"Daily every 1 day, end by Nov 18, 2021\" was NOT displayed!!", expectedSummary.equals(actualSummary));
    }

    public void selectMondayAndFriday() {
        Select selectRepeats = new Select(repeatsDropdown);
        selectRepeats.selectByVisibleText("Weekly");

        BrowserUtils.clickWithJS(mondayCheckbox);
        BrowserUtils.clickWithJS(fridayCheckbox);
    }

    public void mondayAndFridayOptionsIsSelected() {
        Assert.assertTrue("Monday option is NOT selected!!", mondayCheckbox.isSelected());
        Assert.assertTrue("Friday option is NOT selected!!", fridayCheckbox.isSelected());
    }

    public void summaryVerification2() {
        expectedSummary = "Weekly every 1 week on Monday, Friday";
        actualSummary = summaryText1.getText();

        Assert.assertTrue("\"Weekly every 1 week on Monday\"" + " is NOT displayed!!", actualSummary.equals(expectedSummary));
    }
}
