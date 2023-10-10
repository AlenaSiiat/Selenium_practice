package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
//open this web site
		driver.get("https://demoqa.com/droppable");
//to use the methods of Actions class we should create an object of this class - constructor in this case		
		Actions action=new Actions(driver);
//Accessing the method "dragAndDrop" of Actions class by using reference name "action"
//arguments in the brackets: 1.element located by id which should be dragged;2.element, where the 1st element will be dragged
//Actions class should contain build().perform() in order to execute this script
		action.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
		
	
	}

}
