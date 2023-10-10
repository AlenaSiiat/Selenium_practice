package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Handlingalerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		WebDriver driver=new ChromeDriver();//methods of ChromeDriver and WebDriver can be used
		driver.get("https://demoqa.com/alerts");//open this link
	
		// SWITCH TO ALERT AFTER THE CLICK 	
		driver.findElement(By.id("alertButton")).click();//find alert button //
		Alert a=driver.switchTo().alert(); //
		a.accept();//"OK" will be clicked
			
		//ADDING WAIT EVENT BEFORE THE ALERT
		driver.findElement(By.id("timerAlertButton")).click(); 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));//adding explicit wait event after the click 
		wait.until(ExpectedConditions.alertIsPresent()); //condition for explicit wait: alert should be present 
		Alert a1=driver.switchTo().alert();
		a1.accept();//"OK" will be clicked
	
		//CONFIRM BOX 
		driver.findElement(By.id("confirmButton")).click(); //find the button
		Alert a2=driver.switchTo().alert(); 
		a2.dismiss();//"cancel" will be selected
		 		
		//PROMT BOX WITH TEXT
		driver.findElement(By.id("promtButton")).click(); //find the button
		Alert a3=driver.switchTo().alert();
		a3.sendKeys("abcd");//"abcd" will be written in the box
		a3.accept();//"OK" will be clicked
		 
		/*AUTHENTICATION POP UPS (LOGIN AND PASS) */
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//login "admin" and pass "admin" will be typed
		
	}

}
