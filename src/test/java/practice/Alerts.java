package practice;
import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		/*
		 * driver.findElement(By.id("alertButton")).click(); Alert
		 * a=driver.switchTo().alert(); a.accept();
		 */
		
		
		/*
		 * driver.findElement(By.id("timerAlertButton")).click(); WebDriverWait wait=
		 * new WebDriverWait (driver,Duration.ofSeconds(6));
		 * wait.until(ExpectedConditions.alertIsPresent()); Alert
		 * a2=driver.switchTo().alert(); a2.accept();
		 */
		/*
		 * driver.findElement(By.id("confirmButton")).click(); Alert
		 * a=driver.switchTo().alert(); a.dismiss();
		 */
		
		driver.findElement(By.id("promtButton")).click();
		Alert a=driver.switchTo().alert();
		a.sendKeys("abc");
		a.accept();
		
		
		
	}

}
