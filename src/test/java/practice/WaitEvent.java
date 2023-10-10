package practice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitEvent {

	public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
	WebDriver driver=new ChromeDriver();	
//implicit wait: 300 millisec will be implemented on each element
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
	driver.get("https://www.roicians.com/contact-us/");
	
//explicit wait: class WebDriverWait needs to be imported to use his methods
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(300));//Constructor with parameter 
// it will wait till this element is visible	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-77525447616"))).sendKeys("Emily");
	
//fluent wait
	Wait<WebDriver> wait2=new FluentWait<WebDriver>(driver)//WebDriver is an interface
	.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(10))
	.ignoring(NoSuchElementException.class);//will ignore that element is not found
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-77525447616")));
	}
	}
