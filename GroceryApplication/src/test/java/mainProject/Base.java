package mainProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constant.Constants;
import utility.ScreenshotUtility;

public class Base {
	Properties prop;
	FileInputStream fin;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException {
		prop=new Properties();
		fin=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fin);
		String url=prop.getProperty("url");
		if(browsers.equalsIgnoreCase("chrome"))
		{
					driver = new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(browsers.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
//		 // driver.close();
		//driver.quit();
	}
	}


