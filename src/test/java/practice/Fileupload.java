package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileupload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/upload-download");
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\asiia\\OneDrive\\Desktop\\QA course\\scr.jpg");

	}

}
