package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class nested_iframe {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		//Switch to parent frame
		String f=driver.switchTo().frame("frame1").findElement(By.tagName("body")).getText();
		System.out.println(f);
		// Number of Frames on a Page
		int countIframes=driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames on a Page:" + countIframes);
		
		//switch to child frame by using index
		String a=driver.switchTo().frame(0).findElement(By.tagName("p")).getText();
		System.out.println(a);
		//switch to the main document
		String b=driver.switchTo().defaultContent().findElement(By.xpath("//div[contains(text(),'Sample Nested Iframe page. There are nested iframe')]")).getText();
		System.out.println(b);
}
	

}
