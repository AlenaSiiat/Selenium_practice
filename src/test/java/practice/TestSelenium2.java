package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSelenium2 {

	WebDriver driver;//declared a global variable so we can access all methods 
	SoftAssert obj;
	@BeforeSuite //code is executed only once in the beginning
	public void driversetup() { //location of chrome's driver is specified
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		}
	//Passing  multiple set of data to one test case	
	@DataProvider(name="getdata")//gave a name to data provider
	public Object[][] search(){ //object array
		return new Object[][] //object of object array is created
	{{"Roicians"},//values with which we want to test
	{"Roicians automations testing"},//type of data is String
	{"RoiciansQA"}};
	}
	@Test(dataProvider="getdata") //we specified from where test data will be coming from (from "getdata" dataprovider)
	public void Display(String Keywords) throws InterruptedException {/*in methods you can't pass values to the body of the method, 
	until this data specified as parameter of the method "(String Keywords)". 
	Type of data,which we want to pass,is string and name of the parameter could be anything-Keywords in this example*/
	driver.findElement(By.id("APjFqb")).sendKeys(Keywords);//we don't pass hard coded values
	Thread.sleep(2000);
	}
	@BeforeMethod //code is executed before each test case
	public void before() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.get("https://www.google.com/");
	    obj=new SoftAssert();//SoftAssert is a class and we need to create an object to use his methods
	}	
	@AfterMethod 
	public void closebrowser() { 
		driver.close();
	  
	  }
	 
	
	
}
