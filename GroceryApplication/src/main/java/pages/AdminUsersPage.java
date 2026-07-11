package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// New

	@FindBy(xpath = "//a[contains(normalize-space(.),'New')]")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successMessage;

	// Search
	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUsername;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchSubmit;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement firstUsername;

	public AdminUsersPage clickNewButton() {
		// newButton.click();
		pageutility.javascriptClick(driver, newButton);
		return this;
	}

	public AdminUsersPage enterUsername(String user) {
		username.sendKeys(user);
		return this;
	}

	public AdminUsersPage enterPassword(String pass) {
		password.sendKeys(pass);
		return this;
	}

	public AdminUsersPage selectUserType() {
		pageutility.selectDropdownWithVisibleText(userTypeDropdown, "Admin");
		return this;
	}

	public AdminUsersPage clickSaveButton() {
		saveButton.click();
		return this;

	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

	// Search

	public AdminUsersPage clicksearchButton() {
		pageutility.javascriptClick(driver, searchButton);
		return this;
	}

	public AdminUsersPage searchUsername(String uname) {
		searchUsername.sendKeys(uname);
		return this;
	}

	public AdminUsersPage searchUserType() {
		pageutility.selectDropdownWithValue(searchUserType, "admin");
		// Select select = new Select(searchUserType);
		// select.selectByValue("admin");
		return this;
	}

	public AdminUsersPage submitSearch() {
		// searchSubmit.click();
		pageutility.javascriptClick(driver, searchSubmit);

		return this;
	}

	public String verifyUsername() {
		return firstUsername.getText().trim();
	}

}
