package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utility.ExcelUtility;
import utility.RandomUtility;





public class ManageDeliveryBoyTest extends Base{
	
	HomePage homepage;
	ManageDeliveryBoyPage managedeliveryboypage; 
	

	@Test(description = "User is trying to create a new Delivery Boy.")
	public void verify_Whether_User_is_able_to_Create_New_Delivery_Boy() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		RandomUtility random = new RandomUtility();
		String username = random.randomUserName();
		String password = random.randomPassword();

		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		managedeliveryboypage=homepage.click_manageDeliveryBoyMoreinfo();
		managedeliveryboypage.clicknewButton();
		
		RandomUtility random1 = new RandomUtility();
		String name=random1.randomName();
		String email=random1.randomMailId();
		String phoneno=random1.randomPhoneNo();
		String address=random1.randomAddress();
		String uname=random1.randomUserName();
		String pwd=random1.randomPassword();
		
		managedeliveryboypage.enterName(name).enterEmail(email).enterPhone(phoneno).enterAddress(address).enterUsername(uname).enterPassword(pwd).ClickSaveButton();
		
		String actual = managedeliveryboypage.VerifyDeliveryBoyCreation().trim();
		Assert.assertTrue(actual.contains("Delivery Boy Details Created Successfully"),Constants.DELIVERYBOYCREATIONERROR );

	}	
	
	@Test(description = "User is trying to search  newly created Delivery Boy.")
	public void verify_Whether_User_is_able_to_Search_Newly_created_Delivery_Boy() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");

		RandomUtility random = new RandomUtility();
		

		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userNameValue).enterPasword(passwordValue);
		homepage=loginpage.clickSignin();

		
		managedeliveryboypage=homepage.click_manageDeliveryBoyMoreinfo();
		managedeliveryboypage.clicksearchButton();
		
		String searchName = ExcelUtility.getStringData(0, 0, "DeliveryBoyPage");
		String searchEmail = ExcelUtility.getStringData(0, 1, "DeliveryBoyPage");
		int searchPhone = ExcelUtility.getIntegerData(0, 2, "DeliveryBoyPage");
		
		managedeliveryboypage.searchName(searchName).searchEmail(searchEmail).searchphone(String.valueOf(searchPhone)).clicksearchSubmit();
		
		String actual = managedeliveryboypage.verifyDeliveryBoySearch();
		String expected = searchName;;
		Assert.assertEquals(actual, expected, Constants.DELIVERYBOYFOUNDSUCCESS);
		

}
}