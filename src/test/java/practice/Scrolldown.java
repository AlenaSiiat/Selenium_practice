package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolldown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js method "scrollBy" to scroll down by pixels
		js.executeScript("window.scrollBy(0,3000)"); //scroll vertically down by 3000 pixels
		
		//scroll down by visibility of element - scrollIntoView()
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.className("product-image-photo")));
	
		
		//scroll down to the bottom of a web page - scrollTo()
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		//horizontal scroll on the page: scroll the page horizontally until the mentioned element is visible on the current page
		js.executeScript("window.scrollBy(500,0)");
		
		driver.quit();
	}

}
