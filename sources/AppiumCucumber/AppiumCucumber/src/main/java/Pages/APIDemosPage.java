package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APIDemosPage extends BasePage {
    public APIDemosPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"API Demos\"]")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"App\"]")
    private AndroidElement menuApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Voice RecognitionA\"]")
    private AndroidElement voiceRecog;

    public Boolean titleIsDisplay() {

        waitForVisiable(title);

//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"API Demos\"]")));
        return title.isDisplayed();
    }

    public void gotoMenuApp() {
        waitAndClick(menuApp);
    }

    public void scrollToVoce() {
//        scrollByPercent(0.9,0.1);
//        waitAndClick(voiceRecog);

        if (scrollToTextView(voiceRecog, 20000))
            waitAndClick(voiceRecog);
        else
            System.out.println("element not visiable");
    }


}
