package Steps;

import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import pageObject.HomePageObj;

public class LoginSteps {
	HomePageObj homePageObj;
	
	@Then("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
		
	}

	@Then("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
	    
	}

	@Then("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
	    
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
	    
	}

	@Then("^user A is  on homepage$")
	public void user_A_is_on_homepage() throws Throwable {
		homePageObj.userAClickToAvatar();
	}

	@Then("^user B is  on homepage$")
	public void user_B_is_on_homepage() throws Throwable {
		homePageObj.userBClickToAvatar();
	}

	@Then("^user A navigates to Login Page$")
	public void user_A_navigates_to_Login_Page() throws Throwable {
	    
	}

	@Then("^user B navigates to Login Page$")
	public void user_B_navigates_to_Login_Page() throws Throwable {
	    
	}

	@Then("^user A enters username and Password$")
	public void user_A_enters_username_and_Password() throws Throwable {
	    
	}

	@Then("^user B enters username and Password$")
	public void user_B_enters_username_and_Password() throws Throwable {
	    
	}

	@Then("^success message is displayed with user A$")
	public void success_message_is_displayed_with_user_A() throws Throwable {
	    
	}

	@Then("^success message is displayed with user B$")
	public void success_message_is_displayed_with_user_B() throws Throwable {
	    
	}

}
