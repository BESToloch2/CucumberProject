package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters valid user name and password")
    public void user_enters_valid_user_name_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.userNameTB);
        sendText(ConfigReader.read("password"),loginPage.passwordTB);
    }

    @When("user enters invalid user name and password")
    public void user_enters_invalid_user_name_and_password() {
        sendText(ConfigReader.read("invalidUserName"), loginPage.userNameTB);
        sendText(ConfigReader.read("invalidPassword"),loginPage.passwordTB);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {

        click(loginPage.loginButton);
    }

    @Then("use is able to see dashboard page")
    public void use_is_able_to_see_dashboard_page() {
        System.out.println("Test passed");
    }

    @Then("use can see error message")
    public void use_can_see_error_message() {
        System.out.println("Error message");
    }

}
