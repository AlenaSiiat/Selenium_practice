package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/menu#");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		/*
		 * driver.get("https://www.roicians.com/"); Actions action=new Actions(driver);
		 * action.moveToElement(driver.findElement(By.linkText("Courses"))).build().
		 * perform(); driver.findElement(By.linkText("DevOps")).click(); driver.quit();
		 */
		action.moveToElement(driver.findElement(By.linkText("Main Item 2"))).build().perform();
		driver.findElement(By.linkText("SUB SUB LIST »")).click();
		Thread.sleep(6000);
		action.moveToElement(driver.findElement(By.linkText("Sub Sub Item 1"))).build().perform();
		Thread.sleep(6000);
		//driver.quit();
		
	
		
		
		
	}
}
