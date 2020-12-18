package commons;

import pageObject.HomePageObj;
import pageObject.LoginPageObj;
import setupBase.SetupBase;

public class PageGeneratorManager extends SetupBase{
	public static HomePageObj getHomePageObj() {
		return new HomePageObj();
	}
	
	public static LoginPageObj getLoginPageObj() {
		return new LoginPageObj();
	}

}
