package infactor;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Registration {

	        public static void main(String[] args) throws Exception {
		//Here we have to set the path of Driver (ChromeDriver / FirefoxDriver)
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		// Create a new instance of the Chrome driver
		WebDriver wd=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) wd; 
		
		//Launch the http://test.infactor.io/signup 
		wd.get("http://test.infactor.io/signup");
		
		//Resize current window to the set dimension
	        wd.manage().window().maximize();
	        
	        //To Delay execution for 5 sec. as to view the maximize browser
		Thread.sleep(5000); 
			
	        
		//The below entered values for Buyer's account, if you want to register as a Supplier or 
		//Financer then please enter your details in sendkeys()function with double quotes
		
		wd.findElement(By.id("firstName")).sendKeys("BuyerABC"); //Set the value for First name
				
		wd.findElement(By.id("lastName")).sendKeys("B");  //Set the value for Last name 
				
		wd.findElement(By.id("email")).sendKeys("buyer@gmail.com"); //Set the value for Email ID 
					
		wd.findElement(By.id("password")).sendKeys("password");  //Set the value for Password 
		
		// This  will scroll down the page by  400 pixel vertical
		js.executeScript("window.scrollBy(0,400)"); 
		Thread.sleep(2000);
				
		wd.findElement(By.id("confirmPassword")).sendKeys("password"); //Set the value for Confirm password
		
		//ForBuyer Uncomment this code 
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[3]/section/div[2]"
				+ "/form/div[6]/div/div[2]/ul/li/label")).click(); Thread.sleep(2000);
		
		//For Supplier Uncomment this code
//		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[3]/section/div[2]"
//				+ "/form/div[6]/div/div[3]/ul/li/label")).click(); Thread.sleep(2000);
		
		//For Financer Uncomment this code
//		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[3]/section/div[2]"
//				+ "/form/div[6]/div/div[4]/ul/li/label")).click(); Thread.sleep(2000);
		
		wd.findElement(By.id("exampleCheck1")).click(); 
		//Here we have to agree the Terms & Conditions by selecting this checkbox
		
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[3]/section"
				+ "/div[2]/form/div[8]/button")).click(); //Sign Up Button
		Thread.sleep(2000);
		
		//Fullpage screenshot 
	        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(wd);
	        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("F:\\Screenshots\\infactor//Registration.png"));
	        Thread.sleep(4000);	
		
		//Closing browser
		wd.close();
	}

}
