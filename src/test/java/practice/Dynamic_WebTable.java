package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_WebTable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		//Method 1: lengthy and not as efficient
		/*
		 * Iterate row and column and get the cell value. 
		 * • Using for loop 
		 * • Get total rows and iterate table 
		 * • Put if(string matches) then select the respective checkbox
		 * • Lengthy method
		 */
		
		//we want to fetch a specific value "Rosesau"(50 row,3rd column) in the row 
		
		//1.check the xpath of each row (to find out the constant part of the xpath)
		//table[1]/tbody[1]/tr[49]/td[3]
		//table[1]/tbody[1]/tr[50]/td[3] 	Rosesau
		//table[1]/tbody[1]/tr[51]/td[3]
		
		//2.divide the xpath into two parts: before changing value in the xpath("tr" in this case) and after
		String before_xpath="//table[1]/tbody[1]/tr[";
		String after_xpath="]/td[3]";
		
		//3.use For loop
		//i=1 - the loop will start from the 2nd row
		//i<=51 - the loop will iterate 51 times, because in this range our value exists, not further 
		for(int i=1; i<=51;i++) {
		//it will print all the elements from 3rd column until 51 row(included)
		String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
		//to find a specific value and click on the checkbox
			if (name.contains("Bogota")) { //if the name is Rosesau, it will find the checkbox and will click on  it 
				//tbody/tr[50]/td[1]/input[1] - xpath of the checkbox, which is divided into 2 parts
				//through "i" we're passing the row number
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/input[1]")).click();
		//Because the row number is not hard coded, the checkbox will be selected even if the row number will change to 150 position		
			}
		}
		
		//Method 2: easier method, using customized xpath 
		/*
		 * Using custom XPath 
		 * • Using parent and preceding-sibling tags
		 * • No need to write for loop 
		 * • No full iteration of table
		 * • Single line statement
		 * • More dynamic 
		 * • Efficient and fast
		 */
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		////a[contains(text(),'MTNL')]/parent::td
		driver.findElement(By.xpath("//a[contains(text(),'Berger Paints I')]/parent::td")).click();
		//in this statement we need to change only value, which is in '     ' quotes

	}

}
