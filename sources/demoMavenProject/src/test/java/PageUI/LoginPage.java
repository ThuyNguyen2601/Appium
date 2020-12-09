package PageUI;

import basetest.Log;

import basetest.AbstractTest;
import basetest.BasePage;
import basetest.PageGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractTest {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "com.vnpt.tnvn:id/imgAvartar")
    private WebElement avatar;
    
    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;


    @FindBy(id = "btnLoginUsername")
    private WebElement loginButton;


    public BasePage login(String userNameTxt, String passwordTxt){
    	waitForElementClickable(avatar);
        clickToElement(avatar);

        waitForElementClickable(userName);
        sendKeyToElement(userName, userNameTxt);

        waitForElementVisible(password);
        sendKeyToElement(password, passwordTxt);

        waitForElementClickable(loginButton);
        clickToElement(loginButton);


        return PageGeneratorManager.getBasePage();
    }


}
