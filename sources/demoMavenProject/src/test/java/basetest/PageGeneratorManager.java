package basetest;

import PageUI.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class PageGeneratorManager extends BaseSetup{
    public static BasePage getBasePage(){
        return new BasePage(driver);
    }

    public static LoginPage getLoginPage(){
        return new LoginPage(driver);
    }
}
