package practice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame_handle {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/frames");
		//switching to frame using ID
		driver.switchTo().frame("frame1");
		//get text of the element from iframe
		String a=driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(a);
		//switch back to the main frame
		driver.switchTo().parentFrame();
		
		//to get the size of the window
		Dimension size=driver.manage().window().getSize();
		int width=size.getWidth();
		int height=size.getHeight();
		//to maximize the window
		driver.manage().window().maximize();
		System.out.println(size);
		
		//to perform keyboard actions
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		
		//to get all cookies
		driver.manage().getCookies();
		driver.manage().getCookieNamed("");
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed(a);
		driver.manage().addCookie(null);
		
		//if clear() method is not working on a textbox
		driver.findElement(By.id("userName")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		
		
		//used to add a wait time for a page synchronization
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		

	}

}
