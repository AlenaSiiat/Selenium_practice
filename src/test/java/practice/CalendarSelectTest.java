package practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarSelectTest {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://freecrm.com/");
		driver.findElement(By.xpath("//header/div[1]/nav[1]/div[2]/div[1]/div[2]/ul[1]/a[1]")).click();
		driver.findElement(By.name("email")).sendKeys("alena7sergeevna@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Goodday1");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[contains(text(),'ADSforever')]")));
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/div[2]/a[1]")).click();
		
		//expected date
		String date="31-September-2023";
		//split function will return an array
		String dateArr[]=date.split("-"); //{23,September,2023}
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		//driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]")).click();
		
		//If it's a dropdown with months,then just use Select class - to select a particular month
		//Select drpd=new Select(driver,findelement(By.  )
		
		//to change future months
		//driver.findElement(By.xpath("//button[@type='button' ]/i[@class='chevron right icon']")).click();
		
		//to select a specific day
		//1.design a pattern
		
		//look at the xpath of a cell and define rows and columns, choose elements which have dates
		
		//copy the xpath of a 1st cell and 2nd cell in a calendar(even if it's empty or previous month)
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/button  28 aug
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/button  29 aug
			
		//copy an xpath of the 1st day of the month
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[5]/button  01 sept
	
		
		//to select a particular date, for example 23th of September 2023
		
		//2.break an xpath, specifying constant values
		String beforeXpath="//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div[";//constant
		String afterXpath="]/div[2]/div/div[";//constant
		String endXpath="]/button";
		//avoid including variables in xpath
		
		//2.1 in this calendar date and clickable element are designed separately
		//so I have to specify additional xpath for clickable part
		
		String clickBeforeXpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[";
		String clickafterXpath="]/div[1]/div[";

		//declare number of days as constant
		final int totalWeekdays=7;
		
		//3.use for loop with inner for loop
		
		//how it will check: row2-column1; row2-column2; row2-column3; row2-column4
		//then: row3-column1; row3-column2; row3-column3
		
		boolean flag=false;//this variable is needed to break outer loop
		// int rowNum=2 - we start from 2nd row; rowNum<=6 - we have 7 rows in general with 31th day
		for (int rowNum=2;rowNum<=7;rowNum++) { //for loop for rows
		//int colNum=1 - we start from the 1st column; colNum<=totalWeekdays - we have 7 days in a week
			for(int colNum=1;colNum<=totalWeekdays;colNum++) { //for loop for columns
				//in this string we specified constant values of xpath and + variables in rowNum and colNum
 				String dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+endXpath)).getText();
 			//	WebElement vasya = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+endXpath));
				System.out.println(dayVal);
			//	System.out.println(vasya.getAttribute("class"));

				if(dayVal.equals(day)) { //in string day we store the day which we want to pick, when it's true, it will click on it
				//clickable element has different xpath, than a date, so it's changed
					driver.findElement(By.xpath(clickBeforeXpath+rowNum+clickafterXpath+colNum+"]")).click();
					flag = true;
					break; //break inner loop, when condition above is satisfied (value is selected)
				}
			}
			
			if(flag) {
				break; //when flag is "true", break the outer loop
			}
		}
		
      //How to handle Calendar using Selenium
	  //1.With the help of dynamic webtable xpath concept
	  //2.Iterate the entire calendar grid by row and column
	//3.Match the value and select the day
     //4.Handle NoSuchElementException in case of 31st day 
	
		
	}

}
