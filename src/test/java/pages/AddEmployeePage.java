package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstNameTB;
    @FindBy(id="middleName")
    public WebElement middleNameTB;
    @FindBy(id="lastName")
    public WebElement lastNameTB;
    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpButton;
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimButton;
    @FindBy(id="btnSave")
    public WebElement saveButton;
    @FindBy(id="employeeId")
    public  WebElement empId;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
