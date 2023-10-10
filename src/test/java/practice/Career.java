package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Career {

	public static void main(String[] args) {
//Step 1: to open the browser		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");/*the command to open a browser
with values "webdriver.name changes depending on browser.driver": words "webdriver" and "driver" are always same 
and 2nd value is the location of your driver. If it's in your project, just write the name*/
		
/*/I want to use all methods of ChromeDriver class-I need to create its object ChromeDriver driver=new ChromeDriver(); 
 But one problem with it: the dependency will be only on ChromeDriver. What if some test cases should be run on Firefox?
 With this ChromeDriver class I can't do it. That's why we should apply Top Casting here: parent class reference variable 
 is used to point child class object (by this we can access only parent methods and methods which are common in parent and child.
 WebDriver is a parent*/
		WebDriver driver=new ChromeDriver();//If I need to use firefox driver, I will change only this word "ChromeDriver" to FirefoxDriver
//Step 2 open career page
		driver.get("https://www.roicians.com/career/");//the method to open a URL is "get"
//Step 3 navigate to first name column and type your name
		driver.findElement(By.id("text-248418663108")).sendKeys("Alena");/*The method to navigate to any element is "findElement" 
and choose element locator and the method to type - sendKeys*/
//Step 4 navigate to last name column and type your last name
		driver.findElement(By.id("text-58969147196")).sendKeys("Siiatskaia");
//Step 5 navigate to email column and type your email
		driver.findElement(By.id("text-25931186823")).sendKeys("abc@gmail.com");
//Step 6 navigate to phone element and type your phone
		driver.findElement(By.id("field-LfRVhp7sisH0kRP")).sendKeys("6471112233");
//Step 7 navigate to Job title dropdown and select your job
		Select obj=new Select(driver.findElement(By.id("field-jHhehcNamzHL47m")));
		obj.selectByVisibleText("Automation Testing Trainer");
//Step 8 navigate to upload resume element and upload your resume
		driver.findElement(By.id("field-U7H2lPxWxSPqWeq")).sendKeys("C:\\Users\\asiia\\Inheritance.docx");
//Step 9 navigate to message element and write a message
		driver.findElement(By.id("textarea-27447478041")).sendKeys("Hello,this is Selenium assignment");
//Step 10 navigate to send button and click
		driver.findElement(By.id("button-23567600038")).click();

	}

}
