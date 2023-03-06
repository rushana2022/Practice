package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage_RB;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US6_Login_StepDefs_RB {

    LoginPage_RB loginPage_rb = new LoginPage_RB();
    // why do we create it here
    // in order to be able to use locators?

    @Given("librarian is on the login page of the library application")
    public void librarian_is_on_the_login_page_of_the_library_application() {
        Driver.getDriver().get((ConfigurationReader.getProperty("libraryUrl")));
    }

    @When("librarian enters valid email address {string} and password {string}")
    public void librarian_enters_valid_email_address_and_password(String emailAddress, String password) {
        loginPage_rb.emailInput.sendKeys(emailAddress);
        loginPage_rb.passwordInput.sendKeys(password);
    }

    @Then("librarian clicks to Sign in button")
    public void librarian_clicks_to_sign_in_button() {
        loginPage_rb.signInBtn.click();
    }

   /* @Then("account holder name should be name {string}")
    public void account_holder_name_should_be_name(String name) {


    }

    */


}