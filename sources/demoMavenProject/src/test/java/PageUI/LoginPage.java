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

    @FindBy(id = "phone_prefix")
    private WebElement phonePrefix;

    @FindBy(id = "android:id/text1")
    private WebElement suggestPhoneNumber;

    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "continue_")
    private WebElement continueButton;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "android:id/button1")
    private WebElement button1;

    @FindBy(xpath = "//android.widget.Button[@text='ĐÓNG']")
    private WebElement OKButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Nguyen Thi Thuy, huybq, Mr Ngoc, rrddxx']")
    private WebElement conversationName;

    public BasePage login(String phonePrefixTxt, String phoneNumberTxt, String password){
        //waitForElementVisible(phonePrefix);
        //sendKeyToElement(phonePrefix, phonePrefixTxt);

        waitForElementVisible(suggestPhoneNumber);
        clickToElement(suggestPhoneNumber);

        //waitForElementVisible(phoneNumber);
        clearToElement(phoneNumber);
        sendKeyToElement(phoneNumber, phoneNumberTxt);

        waitForElementClickable(continueButton);
        clickToElement(continueButton);

        waitForElementVisible(passWord);
        sendKeyToElement(passWord, password);

        waitForElementClickable(loginButton);
        clickToElement(loginButton);

        waitForElementClickable(button1);
        clickToElement(button1);

        waitForElementClickable(OKButton);
        clickToElement(OKButton);

        return PageGeneratorManager.getBasePage();
    }


}
