package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.roicians.com/contact-us/");//open this page
		driver.navigate().to("https://www.google.com/");//navigate to this
		driver.navigate().back();//will navigate back to roicians.com/contact-us
        driver.navigate().forward();//will go forward
        driver.navigate().refresh();//Will refresh the page
        driver.close();//will close the current tab
        driver.quit(); //all windows associated with this driver will get closed
	}

}
