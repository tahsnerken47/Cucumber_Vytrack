@entire_feature
Feature: As a store manager, I need to make sure that -Calendar Events- module under -Activities- tab functions without any problem.

  @TC1_view_edit_delete_icons
  Scenario: Check "view", "edit" and "delete" options
    Given user is on the dashboard
    And user navigates to "Activities" and "Calendar Events"
    When user hovers on threeDots
    Then user should be able see view, edit and delete options

  @TC2_grid_options
  Scenario: Verify that "Title" column displayed after deselecting all the other options in "Grid Options"
    Given user is on the dashboard
    And user navigates to "Activities" and "Calendar Events"
    And user clicks on Grid Options button
    When the user deselect all the options except Title
    Then the user should be able to see the title column

  @TC3_save_and_new_options
  Scenario: Verify -Save And Close-, -Save And New- amd -Save- options are available under {Save And Close} dropdown
    Given user is on the dashboard
    And user navigates to "Activities" and "Calendar Events"
    When user clicks on Create Calendar Event button
    And user clicks on -Save and Close- dropdown
    Then user should be able see -Save And Close-, -Save And New- amd -Save- options

  @TC4_all_calendar_events_subtitle
  Scenario: Verify that -All Calendar Events- page subtitle is displayed after clicking on -Create Calendar Event- and -Cancel- buttons respectively.
    Given user is on the dashboard
    And user navigates to "Activities" and "Calendar Events"
    When user clicks on Create Calendar Event button
    And user clicks on -Cancel- button
    Then user should see that -All Calendar Events- page subtitle should be displayed
    
    @TC5_difference_between_end_and_start_time
    Scenario: Verify that difference between end and start time is excatly 1 hour
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      Then the difference between end and start time is exactly 1 hour

    @TC6_start_and_end_time_verification
    Scenario: Verify that end time is equal to -10:00 PM-after selecting the start time as "9:00 PM"
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects "9:00 PM" as a start time
      Then user should see that end time is equal to "10:00 PM"

    @TC7_start_and_end_time_inputbox
    Scenario: Verify that start and end time input boxes are-are not displayed after after selecting -All Day Event- checkbox
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects -All Day Event- checkbox
      Then user should not get start and end time input boxes
      Then user should not get start and end date input boxes

    @TC8_repeat
    Scenario: Verify that Daily, Weekly, Monthly and Yearly options are available and Weekly option is selected by default in
      repeat dropdown after clicking on repeat checkbox
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects Repeat checkbox
      Then user should get that Daily, Weekly, Monthly and Yearly options available and that Weekly option is selected by default

    @TC9_daily_every_1_day
    Scenario: cxcvxv
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects Repeat checkbox
      Then user should see that -Repeat Every- radio button is selected
      Then user should see that -Never- radio button is selected as an -Ends- option.
      Then user should see summary of -Summary: Daily every 1 day-

    @TC10_summary_daily_every_1_day_end_after_10_occurrences
    Scenario: Verify that the text of -Summary: Daily every 1 day- is displayed after selecting Repeat checkbox, -Repeat
    Every- radio button and -Never- radio button
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects Repeat checkbox
      And user selects -After 10 occurrences- as an -Ends- option
      Then user should see that -Summary: Daily every one day, end after ten occurrences-

    @TC11_summary_daily_every_1_day_end_by_Nov_18_2021
    Scenario: Verify that the text of -Summary: Daily every 1 day- is displayed after selecting Repeat checkbox, -Repeat Every-
    radio button and -Never- radio button
      Given user is on the dashboard
      And user navigates to "Activities" and "Calendar Events"
      When user clicks on Create Calendar Event button
      And user selects Repeat checkbox
      And user selects -By Nov 18, 2021- as an -Ends- option
      Then user should see that -Summary: Daily every 1 day, end by Nov 18, 2021-

     @TC12_summary_weekly_every_1_week_on_Monday_Friday
     Scenario: Verify that the text of -Summary: Weekly every 1 week on Monday, Friday- is displayed after selecting Repeat
     checkbox, -Repeat Every- radio button and -Never- radio button
       Given user is on the dashboard
       And user navigates to "Activities" and "Calendar Events"
       When user clicks on Create Calendar Event button
       And user selects Repeat checkbox
       And user selects -Monday and Friday- options as a -Repeat On- options
       Then user should see that -Monday and Friday- options are selected
       Then user should see that -Summary: Weekly every 1 week on Monday, Friday-











