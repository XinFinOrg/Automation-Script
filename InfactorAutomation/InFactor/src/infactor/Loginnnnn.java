package infactor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loginnnnn {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		
		WebDriver wd = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) wd;
		
		wd.get("http://test.infactor.io/login");
		Thread.sleep(1000);
		
		wd.findElement(By.id("email")).sendKeys("john@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("/html/body/div[3]/div[2]/section/div/div[5]/section/div[2]/form/div[3]/button")).click();//login
		Thread.sleep(1000);
		
		wd.findElement(By.id("dropdownToggle")).click();//dropdown
		Thread.sleep(1000);
		
		wd.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[2]/ul/li/a")).click();//logout
	
	}

}
