package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		//
		WebElement table=driver.findElement(By.id("countries"));
		
		//finding number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//tr"));
		System.out.println(rows.size());
		
		//
		
		//finding number of columns
		List<WebElement> columns=driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		System.out.println(columns.size());
		
		//finding cell value for 5th row and 2nd column
		WebElement celladdress=driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
		String value=celladdress.getText();
		System.out.println(value);
		driver.close();
		
		

	}

}
