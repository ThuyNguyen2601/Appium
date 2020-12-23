package Steps;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Then;
import pageObject.HomePageObj;
import pageObject.LoginPageObj;

public class LoginSteps {
	private HomePageObj _homePageObj;
	private LoginPageObj _loginPageObj;
	private String phoneNumber = "0941912591";
	
	public LoginSteps() throws Exception {
		_homePageObj = PageGeneratorManager.getHomePageObj();
		_loginPageObj = PageGeneratorManager.getLoginPageObj();
	}

	//2 user login on 2 devices
	@Then("^user A login with valid username and password$")
	public void user_A_login_with_valid_username_and_password() throws Throwable {
		System.out.println("user A login with valid username and password");
		_homePageObj = _loginPageObj.login("0941912591", "Thuynt@123");
	}

	@Then("^user B login with valid username and password$")
	public void user_B_login_with_valid_username_and_password() throws Throwable {
	    
	}

	@Then("^success message is displayed with user A$")
	public void success_message_is_displayed_with_user_A() throws Throwable {
	    
	}

	@Then("^success message is displayed with user B$")
	public void success_message_is_displayed_with_user_B() throws Throwable {
	    
	}
	
	//login by OTP
	@Then("^user A click to OTP button$")
	public void user_A_click_to_OTP_button() throws Throwable {
		System.out.println("user A click to OTP button");
		_loginPageObj.loginByOTP(phoneNumber);
	}

	@Then("^user A enter phone number and click to confirm button$")
	public void user_A_enter_phone_number_and_click_to_confirm_button() throws Throwable {
	    
	}

	@Then("^user A enter otp code and click to confirm button$")
	public void user_A_enter_otp_code_and_click_to_confirm_button() throws Throwable {
	    
	}


}
