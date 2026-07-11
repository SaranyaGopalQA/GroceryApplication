package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException { //failedtestcase=failed testcase name

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  //used to store temporary file

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //Generate timestamp otherwise it will overwrite the file

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create folder in directory
		if (!f1.exists()) { //check folder

		f1.mkdirs();// create folder if it is not created
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";  //generate filename
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); //copy screenshot in to project folder
		} 

}
