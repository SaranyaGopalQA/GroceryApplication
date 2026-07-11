package testScripts;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage ;

	@Test(description = "User is trying to logout after successful login.")
	public void verify_User_Logout() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		homepage.clickAdmin();
		loginpage=homepage.clickLogout();

		String expected = "7rmart supermarket";
		String actual = loginpage.getLoginText();
		Assert.assertEquals(actual, expected,Constants.LOGOUTERROR);

	}
}
