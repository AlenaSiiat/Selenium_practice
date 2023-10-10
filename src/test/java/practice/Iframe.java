package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		String a =driver.switchTo().frame("frame1").getTitle();
		System.out.println(a);
		String b=driver.switchTo().parentFrame().findElement(By.xpath("//span[contains(text(),'Frames')]/parent::li[@id='item-2']")).getText();
		System.out.println(b);
		String c=driver.switchTo().frame("frame2").findElement(By.tagName("h1")).getText();
		System.out.println(c);
		driver.quit();
	}

}
