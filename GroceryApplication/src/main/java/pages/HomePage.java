package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class HomePage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	WebElement admin;
	@FindBy(xpath = "(//a[contains(@href,'logout')])[1]")
	WebElement logout;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "(//a[text()='More info '])[2]")
	WebElement adminUsersMoreinfo;

	@FindBy(xpath = "(//a[text()='More info '])[13]")
	WebElement manageNewsMoreinfo;

	@FindBy(xpath = "(//a[text()='More info '])[3]")
	WebElement manageContactMoreinfo;

	@FindBy(xpath = "(//a[text()='More info '])[8]")
	WebElement manageDeliveryBoyMoreinfo;

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public LoginPage clickLogout() {
		logout.click();
		return new LoginPage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public AdminUsersPage click_adminUsersMoreinfo() {
		adminUsersMoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public ManageNewsPage click_manageNewsMoreinfo() {
		// manageNewsMoreinfo.click();
		pageutility.javascriptClick(driver, manageNewsMoreinfo);

		return new ManageNewsPage(driver);
	}

	public ManageContactPage click_manageContactMoreinfo() {
		manageContactMoreinfo.click();
		return new ManageContactPage(driver);
	}

	public ManageDeliveryBoyPage click_manageDeliveryBoyMoreinfo() {
		pageutility.javascriptClick(driver, manageDeliveryBoyMoreinfo);
		return new ManageDeliveryBoyPage(driver);

	}

}
