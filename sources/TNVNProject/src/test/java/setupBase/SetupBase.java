package setupBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.*;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SetupBase {
	private Properties properties;

	public SetupBase() {
		try {
			String pathConfigure = Paths.get(".").normalize().toAbsolutePath().toString() + "\\src\\test\\java\\configure";
			Path propPath = Paths.get(pathConfigure, "configure.properties");
			String propString = propPath.toAbsolutePath().toString();
			FileInputStream fis = new FileInputStream(propString);
			
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			System.out.println("SetupBase contructor error : " + e.getMessage());
		}
	}

	public AndroidDriver initialization(String port, String deviceNo) throws Exception {
		try {
			String plateFormName = properties.getProperty("android.platform");
			String deviceName = properties.getProperty("android.device.name" + deviceNo);
			String packageName = properties.getProperty("android.app.packageName");
			String activity = properties.getProperty("android.app.activityName");
		
			String url = "http://localhost:" + port + "/wd/hub";
			System.out.println(url);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", plateFormName);
			cap.setCapability("automationName", "UiAutomator2");
			cap.setCapability("deviceName", deviceName);
			//cap.setCapability(MobileCapabilityType.APP, "D:\\ThuyNT\\Sources\\github.com\\Appium\\sources\\TNVNProject\\src\\test\\java\\resources\\Digilife-Staging-14122020-1.1.11.apk");
			
			cap.setCapability("appWaitPackage", packageName);
			//System.out.println(packageName);
			cap.setCapability("appWaitActivity", activity);
			//System.out.println(activity);
			cap.setCapability("noReset", "false");
			cap.setCapability("autoGrantPermissions", true);
			cap.setCapability("autoAcceptAlerts", true);

			AndroidDriver driver = new AndroidDriver(new URL(url), cap);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
		} catch (Exception e) {
			System.out.println("AndroidDriver initialization error : " + e.getMessage());
			throw e;
		}
	}
}
