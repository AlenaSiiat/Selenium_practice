package practice;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSelenium {
WebDriver driver;//declared a global variable so we can access it in every method
SoftAssert obj;
@BeforeSuite //code is executed only once in the beginning
public void driversetup() { //location of chrome's driver is specified
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
	}
	/*
	 * @BeforeTest //code will be executed once before the first test case (gettitle in this case) and the 2nd test case will fail
	 * because the initial setup will not be done!
	 * initialsetup () { driver=new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); }//adding
	 * implicit wait }
	 */	 
@BeforeMethod //code is executed before each test case
public void before() {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    driver.get("https://www.google.com/");
    obj=new SoftAssert();//SoftAssert is a class and we need to create an object to use his methods
}
@Test(priority=1,groups="title")//we can group test cases by command "groups=";
//with this "enabled=false" testNG will skip the test case
public void gettitle () {
	String Title= driver.getTitle(); 
	System.out.println(Title);
    //Assert.assertEquals(Title,"yahoo");//hard assert, the execution stopped at this line and "display" test case is skipped
	obj.assertEquals(Title,"yahoo");
	driver.close();
    obj.assertAll();
}
@Test(priority=2,groups="verification",dependsOnMethods= {"gettitle"})/*child of the gettitle, the execution of this test case
is dependant on the execution of "gettitle" */
public void display() {
    boolean result=driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println(result);
}

  @AfterMethod public void closebrowser() { driver.close();
  
  }
 
}
