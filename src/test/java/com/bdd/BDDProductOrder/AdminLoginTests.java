package com.bdd.BDDProductOrder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.adminarea.AdminDashboardPage;
import pages.adminarea.AdminLoginPage;

public class AdminLoginTests {


    @Given("The user is on login page")
    public void the_user_is_on_login_page() {
        AdminLoginPage.goToAdminLoginPage();
    }

    @When("Filling in the form with {string} username and {string} and submitting it")
    public void filling_in_the_form_with_username_and(String username, String password) {
        AdminLoginPage.login(username, password);
    }

    @Then("ensure the title of the page is {string}")
    public void ensure_the_title_of_the_page_is(String pageTitle) {
        AdminDashboardPage.verifyDashboardTitle(pageTitle);
    }

    @When("Filling in the form with {string} and {string} and submitting it")
    public void filling_in_the_form_with_and_and_submitting_it(String username, String password) {
        AdminLoginPage.login(username, password);
    }

    @Then("ensure the failure message on the page is {string}")
    public void ensure_the_failure_message_on_the_page_is(String failureMessage) {
        AdminLoginPage.verifyFailureMessage(failureMessage);
    }
}
