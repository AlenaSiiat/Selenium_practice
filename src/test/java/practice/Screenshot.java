package practice;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();	
//open this web site		
		driver.get("https://www.roicians.com/");	
//(TakeScreenshot)driver)get.ScreenShotAs(OutputType.FILE) - the method we use to take screenshot
//we need to download common ios first and configure in the library				
//Selenium took a screenshot and stored this screenshot as File in a variable "srcfile"
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//In order to save it on our Operating system we should tell Selenium to copyFile and the location and name
		FileUtils.copyFile(srcfile,new File("C:\\Users\\asiia\\OneDrive\\Desktop\\QA course\\screenshot.jpg"));
		
	}

}
