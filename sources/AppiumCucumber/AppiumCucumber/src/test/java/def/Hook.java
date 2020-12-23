package def;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    @BeforeClass
    public static void initDriver() throws MalformedURLException {
        System.out.println(">> start appium server");

        startServer();
        System.out.println(" ->>>> init driver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("DeviceName", "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\hainv26\\Downloads\\API.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public static void closeDriver() {
        System.out.println(" ->>>> close driver");
        driver.quit();
        service.stop();
    }

    public static void startServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }
        else {
            System.out.println("#############  Appium server started #############");

    }
}}
