package cucumber.steps;

import basetest.Log;
import PageUI.LoginPage;
import basetest.BasePage;
import basetest.PageGeneratorManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import sun.security.util.PendingException;

import java.sql.SQLOutput;

public class LoginSteps {

    LoginPage loginPage;
    BasePage basePage;

    String userNameTxt = "941912591";
    String passwordTxt = "Thuynt!123";

    @Then("^user logins to app with correct account$")
    public void user_logins_to_app_with_correct_account(){
        loginPage = PageGeneratorManager.getLoginPage();
        basePage = loginPage.login(userNameTxt, passwordTxt);
        Log.info("1. Login with correct account");
    }

//    @Then("^validate the page title$")
//    public void validate_the_page_title(){
//        System.out.println("2. Check page title");
//        String pageTitle = basePage.getPageTitle();
//        Assert.assertEquals(pageTitle, "LỊCH SỬ");
//        Log.info("2. Check the title of page");
//    }
//
//    @And("^validate the name of logined$")
//    public void validate_the_name_of_logined() {
//        System.out.println("3. check account name");
//        String accountNameTxt = basePage.getAccountName();
//        Assert.assertEquals(accountNameTxt, "Thủy Nguyễn Thị");
//        Log.info("3. Check the username");
//    }
}
