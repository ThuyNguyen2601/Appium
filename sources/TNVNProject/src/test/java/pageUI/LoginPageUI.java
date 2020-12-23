package pageUI;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static String usernameElement = "username";
	public By passwordElement = By.id("com.vnpt.media:id/password");
	public By btnLoginElement = By.id("com.vnpt.media:id/btnLoginUsername");
	
	public By otpLoginButton = By.xpath("//android.view.View[@resource-id = 'btnOTP']");
	public By phoneNumberText = By.xpath("//android.widget.EditText[@resource-id = 'mobile-number']");
	public By confirmBtn = By.xpath("//android.widget.Button[@resource-id = 'btn-phone-otp']");
	public By optInput = By.xpath("//android.view.View[@resource-id = 'otp-input-group']");
	public By confirmOTPBtn = By.xpath("//android.widget.Button[@resource-id = 'send-otp']");

}
