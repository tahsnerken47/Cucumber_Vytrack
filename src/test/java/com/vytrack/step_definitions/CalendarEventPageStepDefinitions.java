package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarEventPageStepDefinitions {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Given("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login();
    }

    @When("user hovers on threeDots")
    public void user_hovers_on_three_dots() {
        calendarEventsPage.hoverOnThreeDots();
    }

    @Then("user should be able see view, edit and delete options")
    public void user_should_be_able_see_view_edit_and_delete_options(){
        calendarEventsPage.areViewEditAndDeleteOptionsDisplayedVerification();
    }

    @Given("user clicks on Grid Options button")
    public void user_clicks_on_grid_options_button() {
        calendarEventsPage.clickOnGridOption();
//        calendarEventsPage.deselectAllGridCheckBoxList();
    }

    @When("the user deselect all the options except Title")
    public void the_user_deselect_all_the_options_except_title(){
        calendarEventsPage.deselectAllGridCheckBoxList();
    }

    @Then("the user should be able to see the title column")
    public void the_user_should_be_able_to_see_the_title_column() {
        calendarEventsPage.titleColumnAssertion();
    }

    @When("user clicks on Create Calendar Event button")
    public void user_clicks_on_create_calendar_event_button() {
        calendarEventsPage.clickOnCreateCalendarEventButton();
    }

    @When("user clicks on -Save and Close- dropdown")
    public void user_clicks_on_save_and_close_dropdown(){
        calendarEventsPage.clickOnSaveAndCloseDropdown();
    }
    @Then("user should be able see -Save And Close-, -Save And New- amd -Save- options")
    public void user_should_be_able_see_save_and_close_save_and_new_amd_save_options() {
        calendarEventsPage.saveCloseNewOptionsAssertion();
    }

    @When("user clicks on -Cancel- button")
    public void user_clicks_on_cancel_button() {
        calendarEventsPage.clickOnCancelButton();
    }

    @Then("user should see that -All Calendar Events- page subtitle should be displayed")
    public void userShouldSeeThatAllCalendarEventsPageSubtitleShouldBeDisplayed() {
        calendarEventsPage.allCalendarEventsSubtitleAssertion();
    }

    @Then("the difference between end and start time is exactly {int} hour")
    public void the_difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
        calendarEventsPage.differenceBetweenEndAndStartTime(int1);
    }

    @When("user selects {string} as a start time")
    public void user_selects_as_a_start_time(String string) {
        calendarEventsPage.imsert9PM("9:00 PM");
    }

    @Then("user should see that end time is equal to {string}")
    public void user_should_see_that_end_time_is_equal_to(String string) {
        calendarEventsPage.endTime10PMVerification();
    }

    @When("user selects -All Day Event- checkbox")
    public void user_selects_all_day_event_checkbox() {
        calendarEventsPage.clickAllDayEventCheckbox();
    }

    @Then("user should not get start and end time input boxes")
    public void user_should_not_get_start_and_end_time_input_boxes() {
        calendarEventsPage.starEndTimeInputBoxesNotDisplayed();
    }
    @Then("user should not get start and end date input boxes")
    public void user_should_not_get_start_and_end_date_input_boxes() {
        calendarEventsPage.starEndTimeDateBoxessDisplayed();
    }

    @When("user selects Repeat checkbox")
    public void user_selects_repeat_checkbox() {
        calendarEventsPage.clickRepeatCheckbox();
    }

    @Then("user should get that Daily, Weekly, Monthly and Yearly options available and that Weekly option is selected by default")
    public void user_should_get_that_daily_weekly_monthly_and_yearly_options_available_and_that_weekly_option_is_selected_by_default() {
        calendarEventsPage.repeatDropdownOptions();
    }

    @Then("user should see that -Repeat Every- radio button is selected")
    public void user_should_see_that_repeat_every_radio_button_is_selected() {
        calendarEventsPage.repeatCheckboxSelected();
    }

    @Then("user should see that -Never- radio button is selected as an -Ends- option.")
    public void user_should_see_that_never_radio_button_is_selected_as_an_ends_option() {
        calendarEventsPage.neverCheckboxSelected();
    }
    @Then("user should see summary of -Summary: Daily every {int} day-")
    public void user_should_see_summary_of_summary_daily_every_day(Integer int1) {
        calendarEventsPage.summaryText(int1);
    }

    @When("user selects -After {int} occurrences- as an -Ends- option")
    public void user_selects_after_occurrences_as_an_ends_option(Integer int1) {
        calendarEventsPage.occurrences(int1);
    }

    @Then("user should see that -Summary: Daily every one day, end after ten occurrences-")
    public void user_should_see_that_summary_daily_every_one_day_end_after_ten_occurrences() {
        calendarEventsPage.summary_daily_occurrences();
    }

    @When("user selects -By Nov {int}, {int}- as an -Ends- option")
    public void user_selects_by_nov_as_an_ends_option(Integer int1, Integer int2) {
        calendarEventsPage.pickFromChooseADateCalendarBox();
    }

    @Then("user should see that -Summary: Daily every {int} day, end by Nov {int}, {int}-")
    public void user_should_see_that_summary_daily_every_day_end_by_nov(Integer int1, Integer int2, Integer int3) {
        calendarEventsPage.summaryVerification(18, 2021);
    }

    @When("user selects -Monday and Friday- options as a -Repeat On- options")
    public void user_selects_monday_and_friday_options_as_a_repeat_on_options() {
        calendarEventsPage.selectMondayAndFriday();
    }

    @Then("user should see that -Monday and Friday- options are selected")
    public void user_should_see_that_monday_and_friday_options_are_selected() {
        calendarEventsPage.mondayAndFridayOptionsIsSelected();
    }
    @Then("user should see that -Summary: Weekly every {int} week on Monday, Friday-")
    public void user_should_see_that_summary_weekly_every_week_on_monday_friday(Integer int1) {
        calendarEventsPage.summaryVerification2();
    }

}
