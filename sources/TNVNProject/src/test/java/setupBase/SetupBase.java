package setupBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

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
			String appLocation = properties.getProperty("android.app.location");
			String packageName = properties.getProperty("android.app.packageName");
			String activity = properties.getProperty("android.app.activityName");
			//String url = properties.getProperty("http://0.0.0.0:" + port + "/wd/hub");
			String url = "http://0.0.0.0:" + port + "/wd/hub";
			System.out.println(url);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", plateFormName);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("appPackage", packageName);
			cap.setCapability("appActivity", activity);

			AndroidDriver driver = new AndroidDriver(new URL(url), cap);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			return driver;
		} catch (Exception e) {
			System.out.println("AndroidDriver initialization error : " + e.getMessage());
			throw e;
		}
	}
}
