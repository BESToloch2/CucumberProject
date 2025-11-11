package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.DbReader;
import utils.ExcelReader;
import utils.PageInitializer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    String expectedId;
    String expectedFN;
    String expectedMN;
    String expectedLN;
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(addEmployeePage.pimButton);
    }

    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        click(addEmployeePage.addEmpButton);
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        sendText("mark",addEmployeePage.firstNameTB);
        sendText("jacob",addEmployeePage.lastNameTB);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstname, String middlename, String lastname) {
        addEmployeePage.firstNameTB.sendKeys(firstname);
        addEmployeePage.middleNameTB.sendKeys(middlename);
        addEmployeePage.lastNameTB.sendKeys(lastname);
        expectedFN=firstname;
        expectedMN=middlename;
        expectedLN=lastname;
        expectedId= addEmployeePage.empId.getAttribute("value");

    }

    @When("user enters {string},{string},{string}")
    public void user_enters(String firstname, String middlename, String lastname) {
        addEmployeePage.firstNameTB.sendKeys(firstname);
        addEmployeePage.middleNameTB.sendKeys(middlename);
        addEmployeePage.lastNameTB.sendKeys(lastname);
    }

    @When("user adds multiple employees using data table and save them")
    public void user_adds_multiple_employees_using_data_table_and_save_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String >> employeesTable=dataTable.asMaps();

        for (Map<String ,String > employee:employeesTable){
            addEmployeePage.firstNameTB.sendKeys(employee.get("firstname"));
            addEmployeePage.middleNameTB.sendKeys(employee.get("middlename"));
            addEmployeePage.lastNameTB.sendKeys(employee.get("lastname"));

            click(addEmployeePage.addEmpButton);
        }
    }

    @When("user adds multiple employees using excel file")
    public void user_adds_multiple_employees_using_excel_file() throws IOException {
        List<Map<String, String>> employeesTable = ExcelReader.read();

        for (Map<String,String> employee:employeesTable){
            addEmployeePage.firstNameTB.sendKeys(employee.get("firstname"));
            addEmployeePage.middleNameTB.sendKeys(employee.get("middlename"));
            addEmployeePage.lastNameTB.sendKeys(employee.get("lastname"));

            click(addEmployeePage.addEmpButton);
        }

    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        sendText("mark",addEmployeePage.firstNameTB);
        sendText("jacob",addEmployeePage.middleNameTB);
        sendText("ms",addEmployeePage.lastNameTB);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        String query= "select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id="+expectedId;
        List<Map<String,String >> dataFromDB=DbReader.fetch(query);
        String actualFN=dataFromDB.get(0).get("emp_firstname");
        String actualMN=dataFromDB.get(0).get("emp_middle_name");
        String actualLN=dataFromDB.get(0).get("emp_lastname");
        Assert.assertEquals(expectedFN,actualFN);
        Assert.assertEquals(expectedMN,actualMN);
        Assert.assertEquals(expectedLN,actualLN);


    }
}
