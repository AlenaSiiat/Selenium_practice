package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scr {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/");
		
		//1.convert webdriver object to take screenshot
		TakesScreenshot scr=((TakesScreenshot)driver);
		//2.create an image file by calling "getscreenshotAs" method
		File scrfile=scr.getScreenshotAs(OutputType.FILE);
		//3.copy file to desired location
		FileUtils.copyFile(scrfile,new File("C:\\Users\\Alena\\Desktop\\Transfer\\QA course\\Selenium\\scr.jpg"));
		
	}

}
