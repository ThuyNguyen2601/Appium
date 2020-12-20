package commons;

import pageObject.HomePageObj;
import pageObject.LoginPageObj;
import setupBase.SetupBase;

public class PageGeneratorManager extends SetupBase{
	public static HomePageObj getHomePageObj() throws Exception {
		return new HomePageObj();
	}
	
	public static LoginPageObj getLoginPageObj() throws Exception {
		return new LoginPageObj();
	}
}
