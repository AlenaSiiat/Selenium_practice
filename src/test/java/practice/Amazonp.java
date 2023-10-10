package practice;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
//
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazonp {

	public static void main(String[] args) throws IOException {

//Step 1: Open google.com then navigate to Amazon.ca
System.setProperty("webdriver.chrome.driver","chromedriver.exe");//the method we use to open chrome  browser
WebDriver driver=new ChromeDriver();//using Top Casting to access methods of Webdriver and Chromedriver (parent and child)
driver.get("https://www.google.com/");//using reference name "driver" to access the method "get" and "navigate"
driver.navigate().to("https://www.amazon.ca/");

//Step 2: Take screen shot of the page with selenium automation commands
File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);/*using java IO File class to access 
the method to take screenshot and store it as a file*/
//using FileUtils to save the file on operating system in the provided location as a "amazonscreenshot"
//FileUtils.copyFile(srcfile,new File("C:\\Users\\asiia\\OneDrive\\Desktop\\QA course\\amazonscreenshot.jpg"));


//Step 3 When you are amazon homepage, Verify Amazon.ca (check its element locator) is displayed or not 
//(to check whether you landed on homepage or not) as shown below
boolean result=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();/*using reference name "driver" 
to access the method to find an element and store it in a variable "result" with "true or false" data type*/
System.out.println(result);//using this method to display the result


//Step 4 then Mouse hover on Hello, sign in and then click on Start here open for registration as shown below
Actions action=new Actions(driver);//creating a constructor with an argument "driver" to access the mouse hover method
//accessing the method with parameters to find the elements by id and by linktext and click on the 2nd element
action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
action.moveToElement(driver.findElement(By.linkText("Start here."))).build().perform();
driver.findElement(By.linkText("Start here.")).click();


//Step 5: Fill the information in the page below and click on continue or verify email/phone number 
//according to whatever option you filled. 
//telling the driver to go on this URL with the help of get method
driver.get("https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
//using reference name "driver" to access the method to find an element and using "sendKeys" method to type information
//into elements, then using the method "click" to finish the submission of a form
driver.findElement(By.id("ap_customer_name")).sendKeys("Alena Smith");
driver.findElement(By.id("ap_email")).sendKeys("asiiatskaia@gmail.com");
driver.findElement(By.id("ap_password")).sendKeys("qwerty123$Q");
driver.findElement(By.id("ap_password_check")).sendKeys("qwerty123$Q");
driver.findElement(By.id("continue")).click();
 
	}

}
