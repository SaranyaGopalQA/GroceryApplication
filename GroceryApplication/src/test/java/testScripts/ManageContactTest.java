package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;
import utility.RandomUtility;

public class ManageContactTest extends Base {
	HomePage homepage ;
	ManageContactPage managecontactpage ;

	@Test(description = "User is trying to update the Contact Us information.")
	public void verify_Whether_user_is_able_to_Update_ContactUs_Informations() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		managecontactpage=homepage.click_manageContactMoreinfo();

		
		

		RandomUtility random = new RandomUtility();
		String phone = random.randomPhoneNo();
		String email = random.randomMailId();
		String address = ExcelUtility.getStringData(0, 0, "ContactPage");

		managecontactpage.click_ActionButton().enter_PhoneNumber(phone).enter_EmailId(email).enter_Address(address).click_UpdateButton();

		String expected = "Contact Updated Successfully";
		String actual = managecontactpage.getSuccessMessage().trim();

		Assert.assertTrue(actual.contains(expected),Constants.CONTACTUPDATIONERROR );

	}

}
