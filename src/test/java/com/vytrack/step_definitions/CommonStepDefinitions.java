package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefinitions {

    BasePage basePage = new LoginPage();

//    @Given("user navigates to -string- and -string-")
//    public void user_navigates_to_and(String string, String string2) {
//        basePage.navigateTo(string, string2);
//    }

    @And("user navigates to {string} and {string}")
    public void userNavigatesToAnd(String arg0, String arg1) {
        basePage.navigateTo(arg0, arg1);
    }
}
