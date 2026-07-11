package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage ;
	ManageNewsPage managenewspage ;

	@Test(description = "User is trying to create a new news item.")
	public void verify_Whether_User_is_able_to_Create_New_News() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		String news = ExcelUtility.getStringData(0, 0, "News");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		managenewspage=homepage.click_manageNewsMoreinfo();

		
		
		managenewspage.click_NewButton().enter_NewsText(news).click_saveButton();

		String actual = managenewspage.Verify_NewsCreation().trim();
		Assert.assertTrue(actual.contains("News Created Successfully"),Constants.NEWSCREATIONERROR );

	}

	@Test(description = "User is trying to search an existing news item.")
	public void verify_Whether_User_is_able_to_Search_Newly_added_News() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		String news = ExcelUtility.getStringData(0, 0, "News");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		managenewspage=homepage.click_manageNewsMoreinfo();

		
		managenewspage.click_SearchButton().enter_SearchNewsText(news).click_Submitsearch();

		String actual = managenewspage.verify_NewsSearch();
		String expected = news;
		Assert.assertEquals(actual, expected, Constants.NEWSFOUNDSUCCESS);

	}
}
