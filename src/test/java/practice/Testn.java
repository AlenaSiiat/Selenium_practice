package practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testn {
	WebDriver driver;//variables should be declared globally and we can use them inside methods
	Contactus_POM pom;//variables should be declared globally 
@BeforeSuite//code will be executed only once in the beginning
public void beforesuite () {
	System.out.println("Before suite");		
}
@BeforeTest
public void beforetest () {
	System.out.println("Before test");		
}
@BeforeClass
public void beforeclass () {
	System.out.println("Before class");		
}
	
@BeforeMethod	//any code comes in annotations
public void openbrowser () {
	
System.out.println("Before method");
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
driver=new ChromeDriver();//declared inside this method, scope of this variables local
pom = new Contactus_POM(driver);
driver.get("https://www.roicians.com/contact-us/");

}

@Test(priority=1)
//any code should be enclosed in a method in testNG
	public void validcase() throws InterruptedException {//method created
	pom.typefirstname("4-10 characters");
	Thread.sleep(500);

}
@Test(priority=2)
/*in testNG code is executed with respect to a name of test case 
 * (alphabetically which letter is first in alphabet, 
 * then this test case is executed unless you set a priority)*/
	public void invalidcase() {//method created
	System.out.println("less than 4 characters");		
	}
@AfterMethod()	
public void closebrowser () {
	System.out.println("close browser");	
}	
@AfterClass
public void afterclass () {
	System.out.println("after class");	
	
}
@AfterTest
public void afteretest() {
		System.out.println("after test");		
}
@AfterSuite
public void afteresuite() {
	System.out.println("after suite");	

}
}


