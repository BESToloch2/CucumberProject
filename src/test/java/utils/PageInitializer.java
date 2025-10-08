package utils;

import org.openqa.selenium.support.PageFactory;
import pages.AddEmployeePage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects(){
        loginPage=new LoginPage();
        addEmployeePage=new AddEmployeePage();

    }
}
