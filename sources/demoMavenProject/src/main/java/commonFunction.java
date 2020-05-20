import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class commonFunction {
    AndroidDriver driver;

    public WebElement scrollToElementVertical(String textElement){
        WebElement element;
        String uiSelector = "new UiSelector().textMatches(\"" + textElement
                + "\")";

        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

        element = driver.findElementByAndroidUIAutomator(command);
        return  element;
    }

    public WebElement scrollToElementHorizontal(String textElement){
        WebElement element;
        element = driver.findElementByAndroidUIAutomator(new StringBuilder().append("new UiScrollable(new UiSelector().scrollable(true).").append("resourceId(\"<id of scrollable control>\"))").append(".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"").append(textElement).append("\"))").toString());
        return element;
    }
}
