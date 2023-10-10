package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/");
		Actions act=new Actions(driver);
		//right click
		act.contextClick(driver.findElement(By.xpath("//h5[contains(text(),'Forms')]"))).perform();
		//double click
		act.doubleClick(driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"))).perform();
		
	}

}
