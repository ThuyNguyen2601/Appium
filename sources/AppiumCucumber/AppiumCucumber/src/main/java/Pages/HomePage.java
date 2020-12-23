package Pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/buttonDefaultPositive")
    private MobileElement btnOK;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"API Demos\"]")
    private MobileElement txtAPIDemos;


    public void closePopup() {
        if (elemenetDisplay(btnOK))
            waitAndClick(btnOK);
    }

    public void gotoMenuAPIDemo() {
        waitAndClick(txtAPIDemos);

    }

    public void gotoMeneAPIDemos2() {
        clickToTextView("API Demos");

    }

}
