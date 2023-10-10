package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verificationcommands2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		/*
		 * boolean result=driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img")).
		 * isDisplayed(); System.out.print(result);
		 */
		/*
		 * 	driver.get("https://demoqa.com/checkbox");
		 * driver.findElement(By.
		 * cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg"
		 * )).click(); driver.findElement(By.
		 * cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"
		 * )).click(); boolean result2=driver.findElement(By.
		 * cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"
		 * )).isSelected(); System.out.print(result2);
		 */
		/*
		 * driver.get("https://demoqa.com/radio-button"); driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
		 * Thread.sleep(5000); boolean result= driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).isSelected();
		 * System.out.println(result); driver.quit();
		 */
	driver.get("https://demoqa.com/automation-practice-form");
    boolean result=	driver.findElement(By.cssSelector("#stateCity-wrapper > div:nth-child(3)")).isEnabled();
	System.out.println(result);
	
	}

}
