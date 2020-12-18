package setupBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SetupBase {
	public static Properties properties;

	public SetupBase() {
		try {
			properties = new Properties();
			String pathConfigure = Paths.get(".").normalize().toAbsolutePath().toString() + "src\\test\\java\\configure\\";
			Path propPath = Paths.get(pathConfigure, "configủe.properties");
			String propString = propPath.toAbsolutePath().toString();
			FileInputStream fis = new FileInputStream(propString);
			properties.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public AndroidDriver initialization(String port, String deviceNo) {
		try {
			String plateFormName = properties.getProperty("android.platform");
			String deviceName = properties.getProperty("android.device.name" + deviceNo);
			String appLocation = properties.getProperty("android.app.location");
			String packageName = properties.getProperty("android.app.packageName");
			String activity = properties.getProperty("android.app.activityName");
			String url = properties.getProperty("http://0.0.0.0:" + port + "/wd/hub");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", plateFormName);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("appPackage", packageName);
			cap.setCapability("appActivity", activity);

			AndroidDriver driver = new AndroidDriver(new URL(url), cap);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			return driver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
