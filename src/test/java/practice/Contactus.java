package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Contactus {

	public static void main(String[] args) {

		// Step 1: to open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.roicians.com/contact-us/?gclid=CjwKCAjw4ZWkBhA4EiwAVJXwqaRXLPO_0cWA9QcbwFZM9F1ynS1OLrtprmgZsIMC96ADF6UFPf7voxoCcVMQAvD_BwE");
		
		Contactus_POM pom = new Contactus_POM(driver);//created an object to use methods of ContactUs_POM
			
	
		//driver.findElement(By.id("text-77525447616")).sendKeys("Alena");  		
		pom.typefirstname("Alena");	// we created this method in POM
	    //driver.findElement(By.id("text-95374915097")).sendKeys("Smith");
		pom.typelastname("Siiatskaia");
		//driver.findElement(By.id("text-27022866830")).sendKeys("abc@gmail.com");
		pom.typeemail("abc@gmail.com");
		//driver.findElement(By.id("field-tIgxvmTMez6ibt1")).sendKeys("+16471237856");
		pom.typephone("+16471237856");
		//driver.findElement(By.id("field-kJfKGbPLNi5yFI7")).sendKeys("Please tell me conditions of enrolling to course");
		pom.typecond("Please tell me conditions of enrolling to course");
		//driver.findElement(By.id("button-18782068913")).click();
		//pom.click();
		 

	}

}
