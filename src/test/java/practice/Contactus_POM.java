package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactus_POM {
WebDriver driver;/*we need to declare reference variable "driver" 
because driver.findElement(By." is replaced by @FindBy */

	
//to store element in a variable 

//@ annotation - code is already predefined
//
@FindBy(id="text-77525447616") WebElement fname; //complete line is stored in an webelement called "fname"
//"driver.findElement(By." is replaced by @FindBy 
@FindBy(id="text-95374915097") WebElement lname;//last name
@FindBy(id="text-27022866830") WebElement mail;//email
@FindBy(id="field-tIgxvmTMez6ibt1") WebElement number;//phone number
@FindBy(id="field-kJfKGbPLNi5yFI7") WebElement cond;
@FindBy(id="button-18782068913") WebElement click;


//All actions(methods) which we perform on the element, also created and stored here in POM
//Test cases will have minimal code and everything comes from POM

//sendKeys("Alena") is replaced by creating a method, the dependency is small
public void typefirstname(String name) {
fname.sendKeys(name);//local variable inside the method, is should be passed to global		
}
public void typelastname (String lastname) {
lname.sendKeys(lastname);
}
public void typeemail (String email) {
mail.sendKeys(email);	
}
public void typephone (String pnumber) {
number.sendKeys(pnumber);
}
public void typecond (String text) {
cond.sendKeys(text);
}
public void click () {
click.click();
}

//to pass values from local to global variables
public Contactus_POM(WebDriver driver) {//constractor with parameter
PageFactory.initElements(driver, this);//we have to initiate the web elements
//PageFactory is for POM, it is predefined method; driver is a reference variable; this 

}


}
