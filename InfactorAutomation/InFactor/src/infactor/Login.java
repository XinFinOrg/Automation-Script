package infactor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws Exception {
		
		//Here we have to set the path of Driver (ChromeDriver / FirefoxDriver)
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver wd = new ChromeDriver();
		
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) wd;
		
		// Launch the http://test.infactor.io/login
		wd.get("http://test.infactor.io/login");
		
		//Resize current window to the set dimension
	    wd.manage().window().maximize();
		Thread.sleep(5000);
		
		// Enter credentials, email & password in sendkeys() function 
		wd.findElement(By.id("email")).sendKeys("john@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(5000);
		
		// This  will scroll down the page by  400 pixel vertical
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/"
				+ "div[5]/section/div[2]/form/div[3]/button")).click();// Click on 'Sign In' button
		Thread.sleep(5000);
		
		wd.findElement(By.id("dropdownToggle")).click();// Click on dropdown
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/ul/li"
				+ "[2]/ul/li/a")).click();// Click on logout
	
		wd.close();
	}

}
