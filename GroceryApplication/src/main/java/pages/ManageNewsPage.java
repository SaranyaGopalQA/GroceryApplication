package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// New

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textarea;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	WebElement verifyNews;

	// Search

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement textBox;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement submitSearchButton;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement firstRowNews;

	// New

	public ManageNewsPage click_NewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enter_NewsText(String text) {
		textarea.sendKeys(text);
		return this;
	}

	public ManageNewsPage click_saveButton() {
		saveButton.click();
		return this;
	}

	public String Verify_NewsCreation() {
		return verifyNews.getText();
	}

	// Search

	public ManageNewsPage click_SearchButton() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage enter_SearchNewsText(String text) {
		textBox.sendKeys(text);
		return this;
	}

	public ManageNewsPage click_Submitsearch() {
		submitSearchButton.click();
		return this;
	}

	public String verify_NewsSearch() {
		return firstRowNews.getText();
	}
}
