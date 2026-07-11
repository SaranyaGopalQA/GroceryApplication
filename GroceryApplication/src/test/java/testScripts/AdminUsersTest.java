package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.RandomUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserspage; 

	@Test(description = "User is trying to create a new admin user with valid details.")
	public void verify_Whether_User_is_able_to_Create_New_Admin_User() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		RandomUtility random = new RandomUtility();
		String username = random.randomUserName();
		String password = random.randomPassword();

		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		adminuserspage=homepage.click_adminUsersMoreinfo();

		
		adminuserspage.clickNewButton().enterUsername(username).enterPassword(password).selectUserType().clickSaveButton();

		String expected = "User Created Successfully";
		String actual = adminuserspage.getSuccessMessage().trim();

		Assert.assertTrue(actual.contains(expected),Constants.USERCREATIONERROR);

	}

	@Test(description = "User is trying to search the details of an existing admin user.")
	public void verify_Whether_the_User_is_able_to_Search_the_newly_added_Admin_User() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		String username = ExcelUtility.getStringData(0, 0, "AdminUsers");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		adminuserspage=homepage.click_adminUsersMoreinfo();

		
		adminuserspage.clicksearchButton().searchUsername(username).searchUserType().submitSearch();

		String expected = username;
		String actual = adminuserspage.verifyUsername();
		Assert.assertEquals(actual, expected, Constants.USERFOUNDSUCCESS);

	}

}
