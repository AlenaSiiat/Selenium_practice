package practice;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		
		//1.get all links/images(by tag name <a> and store it in a List of WebElements 
		List <WebElement> all_links=driver.findElements(By.tagName("a"));
		//add in the same list all images
		all_links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of all links and images:"+all_links.size());
		
		
		//2.iterate through all_links list and exclude links which has empty href value 
		
		//and store all active links in a new array list
		List <WebElement> active_links=new ArrayList<WebElement>();
		
		for (int i=0; i<all_links.size();i++) {
			System.out.println(all_links.get(i).getAttribute("href"));
			if(all_links.get(i).getAttribute("href")!=null && (!all_links.get(i).getAttribute("href").contains("javascript"))) {
				active_links.add(all_links.get(i));
			}
		}
		
		//get the size of active links list
		System.out.println("Size of active links and images:"+active_links.size());
		
		//3.check all URL's with HTTPConnnection API
		
		for(int j=0;j<active_links.size();j++) {
			
		//create an object-new URL and cast it to HttpURLConnection	class and use .openConnection method(it will check if URL is correct or not)
			
		@SuppressWarnings("deprecation")
		HttpURLConnection connection=(HttpURLConnection)(new URL(active_links.get(j).getAttribute("href")).openConnection());
		connection.connect();
		String response=connection.getResponseMessage();
		connection.disconnect();
		System.out.println(active_links.get(j).getAttribute("href")+"------>"+response);
		}
		
		driver.quit();
		
		
		
	}

}
