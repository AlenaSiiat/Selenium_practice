package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Registration_TestNG {
WebDriver driver;
POM_Registration pom;
SoftAssert obj;

	
@BeforeMethod
public void openbrowser () {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver();
	pom=new POM_Registration(driver);
	obj=new SoftAssert();
	driver.get("https://demoqa.com/automation-practice-form");
}

@DataProvider(name="getdata")
public Object[][] fnamecomb(){ //object array
	return new Object[][] //object of object array is created
{{"Alena123"},//values with which we want to test
{"A!2$5"},//type of data is String
{"#(^#1"}};
}



@Test (priority=2,groups="formcheck")
public void validcase () {
	pom.typefirstname("Alex");
	pom.typelastname("Smith");
	pom.typeemail("AlexSmith@gmail.com");
	//pom.pickgender();
}

@Test (priority=3,groups="formcheck",dataProvider="getdata")
public void invalidcase(String Keywords) {
	pom.typefirstname(Keywords);
	pom.typelastname("S");
	pom.typeemail("AlexSmithgmail.com");
}
@Test (priority=1)
public void gettitle() {
	String title=driver.getTitle();
	System.out.println(title);
	obj.assertEquals(title,"DEMOQA");
	obj.assertAll();
	
}

@AfterMethod
public void closebrowser() {
	driver.quit();
 	
}
	
	
	
}
