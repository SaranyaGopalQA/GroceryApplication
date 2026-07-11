package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageContactPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement actionButton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "(//textarea[@id='content'])[1]")
	WebElement address;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successMessage;

	public ManageContactPage click_ActionButton() {
		actionButton.click();
		return this;
	}

	public ManageContactPage enter_PhoneNumber(String phno) {
		phoneNumber.clear();
		phoneNumber.sendKeys(phno);
		return this;
	}

	public ManageContactPage enter_EmailId(String emid) {
		email.clear();
		email.sendKeys(emid);
		return this;
	}

	public ManageContactPage enter_Address(String adrss) {
		address.clear();
		address.sendKeys(adrss);
		return this;
	}

	public ManageContactPage click_UpdateButton() {
		pageutility.javascriptClick(driver, updateButton);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", updateButton);
		return this;
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
