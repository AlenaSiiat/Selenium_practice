package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verificationcommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.google.com/");
boolean	result=driver.findElement(By.linkText("Gmail")).isDisplayed();//the result of this line is stored in a variable "result" 
System.out.println(result);	//in order to display it for us, it should return "true" or "false"
//How to customize CSS selector		
boolean	result2=driver.findElement(By.cssSelector(".gb_f")).isDisplayed();//gb_f class, but with the help of dot . it becomes css selector
System.out.println(result2);	
	
//   /html/body/div[1]/div[1]/div/div/div/div[1]/div/div[1]/a   absolute xpath
//   //*[@id="gb"] customized relative xpath
	
	}}