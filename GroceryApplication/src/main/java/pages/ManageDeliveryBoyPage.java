package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageDeliveryBoyPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class, 'alert')]")
	WebElement verifysuccess;

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchName;
	@FindBy(xpath = "//input[@id='ut']")
	WebElement searchEmail;
	@FindBy(xpath = "//input[@id='ph']")
	WebElement searchPhone;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement submitSearch;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement firstRowName;

	public ManageDeliveryBoyPage clicknewButton() {
		newButton.click();
		return this;
	}

	public ManageDeliveryBoyPage enterName(String n) {
		name.sendKeys(n);
		return this;
	}

	public ManageDeliveryBoyPage enterEmail(String em) {
		email.sendKeys(em);
		return this;
	}

	public ManageDeliveryBoyPage enterPhone(String ph) {
		phone.sendKeys(ph);
		return this;
	}

	public ManageDeliveryBoyPage enterAddress(String adrs) {
		address.sendKeys(adrs);
		return this;
	}

	public ManageDeliveryBoyPage enterUsername(String uname) {
		username.sendKeys(uname);
		return this;
	}

	public ManageDeliveryBoyPage enterPassword(String pwd) {
		password.sendKeys(pwd);
		return this;
	}

	public ManageDeliveryBoyPage ClickSaveButton() {

		pageutility.javascriptClick(driver, saveButton);
		return this;
	}

	public String VerifyDeliveryBoyCreation() {
		return verifysuccess.getText();
	}

	public ManageDeliveryBoyPage clicksearchButton() {
		searchButton.click();
		return this;
	}

	public ManageDeliveryBoyPage searchName(String nm) {
		searchName.sendKeys(nm);
		return this;
	}

	public ManageDeliveryBoyPage searchEmail(String em) {
		searchEmail.sendKeys(em);
		return this;
	}

	public ManageDeliveryBoyPage searchphone(String ph) {
		searchPhone.sendKeys(ph);
		return this;
	}

	public ManageDeliveryBoyPage clicksearchSubmit() {
		submitSearch.click();
		return this;
	}

	public String verifyDeliveryBoySearch() {
		return firstRowName.getText();
	}

}
