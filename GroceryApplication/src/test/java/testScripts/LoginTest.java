package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;
	@Test(priority = 1, description = "User is trying to login with valid credentials",groups=
			{"Smoke"})
	public void verify_User_Login_with_Valid_Credentials() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();
		
		boolean dashboardvalue = homepage.isDashboardDisplayed();
		Assert.assertTrue(dashboardvalue,Constants.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login with invalid credentials", retryAnalyzer = retry.Retry.class)
	public void verify_User_Login_with_Invalid_Credentials() throws IOException {
		String userNameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue).clickSignin();
		String expected = "7rmart supermarket";
		String actual = loginpage.getLoginText();
		Assert.assertEquals(actual, expected, Constants.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to login with valid username and invalid password ")
	public void verify_User_Login_with_Valid_Username_and_Invalid__Passsword() throws IOException {
		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue).clickSignin();
		String expected = "7rmart supermarket";
		String actual = loginpage.getLoginText();
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid username and valid password ",groups= {"Smoke"},dataProvider="loginProvider")
	public void verify_User_Login_with_Invalid_Username_and_Valid_Password(String userNameValue,String passwordValue) throws IOException {
		//String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue).clickSignin();
		String expected = "7rmart supermarket";
		String actual = loginpage.getLoginText();
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEERROR);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
