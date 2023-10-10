package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecuteFailed {

	WebDriver driver=new ChromeDriver();
	
	
//How to execute failed test cases	
	@Test
	public void launchapp() {
		
		driver.get("https://demoqa.com/");
		Assert.assertTrue(false);
		
	}
	
	
	
	
}
