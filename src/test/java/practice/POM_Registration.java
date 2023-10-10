package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Registration {
WebDriver driver;

	@FindBy(id="firstName") WebElement fname;
	@FindBy(id="lastName") WebElement lname;
	@FindBy(id="userEmail") WebElement email;
	@FindBy(id="gender-radio-1") WebElement malegender;
	
	
	public void typefirstname(String name) {
		fname.sendKeys(name);

	}
	public void typelastname(String lastname) {
		lname.sendKeys(lastname);
	}
	public void typeemail (String mail) {
		email.sendKeys(mail);
	}
	public void pickgender () {
		malegender.click();
	}
	public POM_Registration (WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
}
