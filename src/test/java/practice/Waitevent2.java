package practice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class Waitevent2 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//implicit
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.get("https://demoqa.com/books"); driver.quit();
		 */
		
		//explicit
		/*
		 * driver.get("https://demoqa.com/upload-download"); WebDriverWait wait=new
		 * WebDriverWait(driver,Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("downloadButton"
		 * ))); driver.quit();
		 */

		//fluent wait
		driver.get("https://demoqa.com/dynamic-properties");
		Wait<WebDriver>wait2=new FluentWait<WebDriver>(driver)	
		.withTimeout(Duration.ofSeconds(6)).pollingEvery(Duration.ofMillis(50))
		.ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		driver.quit();

	}

}
