package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement signin;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement text;

	public LoginPage enterUsername(String userNameValue) {
		username.sendKeys(userNameValue);
		return this;

	}

	public LoginPage enterPasword(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage clickSignin() {
		waitutility.waitUntilElementToBeClickable(driver, signin);
		signin.click();
		return new HomePage(driver);
	}

	public String getLoginText() {
		return text.getText();
	}

}
