package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		
		Select obj=new Select(driver.findElement(By.id("oldSelectMenu")));
		//obj.selectByVisibleText("Blue"); - by visible text
		//obj.selectByValue("5"); -- by value
		obj.selectByIndex(6);
		driver.quit();

	}

}
