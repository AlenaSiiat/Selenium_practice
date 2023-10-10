package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Iterator_practice {

	public static void main(String[] args) {
	
	//Iterator lets you loop through a collection
	//ArrayList, HashMap
		
		ArrayList<String> foods= new ArrayList<String>();
		foods.add("pizza");
		foods.add("ice cream");
		foods.add("chicken");
		foods.add("pizza");
		foods.add("ice cream");
		foods.add("chicken");
		
        Iterator <String> it = foods.iterator();
		//it will print the next value in the array
       System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
    
		//hasNext() returns true if next would return an element rather than throwing an exception
		//next() Returns the next element in the iteration.
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		//How to switch from one window to another:
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/browser-windows");
		
		// 1.store parent window handle
		String parentwindow=driver.getWindowHandle();
		
		//2.click on child windows
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();
		
		
		//3.get child window handles and store them in a Set
		Set<String> windowhandles=driver.getWindowHandles();
		System.out.println(windowhandles);
		
		//4.iterate through all windows, using iterator and .next() method, storing each handle in a string
		Iterator <String> iter=windowhandles.iterator();
		
		String parentwindow2=iter.next();
		System.out.println("Parent window handle:"+parentwindow2);
		String childwindow1=iter.next();
		System.out.println("Child1 window handle:"+childwindow1);
		String childwindow2=iter.next();
		System.out.println("Child2 window handle:"+childwindow2);
		String childwindow3=iter.next();
		System.out.println("Child3 window handle:"+childwindow3);
		
		//5.switch to the child window by passing child's handle
		driver.switchTo().window(childwindow1);
		driver.switchTo().window(childwindow2);
		driver.switchTo().window(childwindow3);
		
		
//		while(iter.hasNext()) {
//			
//			String childwindow=iter.next();
//			if(!parentwindow.equalsIgnoreCase(childwindow)); {
//				
//				driver.switchTo().window(childwindow);
//				String text=driver.findElement(By.tagName("h1")).getText();
//				System.out.println(text);
//				break;
//			}	
//			
//		}
		
		//6.switch back to the parent window

		String maintitle=driver.switchTo().window(parentwindow).getTitle();
		System.out.println(maintitle);
		driver.quit();
	
		
		
		
		
		
	}

}
