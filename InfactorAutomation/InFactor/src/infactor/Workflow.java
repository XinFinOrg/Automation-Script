package infactor;

import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Workflow {

public static void main(String[] args) throws Exception { 
		
	    System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver wd = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) wd;
		
		// Launch the http://test.infactor.io/login
		wd.get("http://test.infactor.io/login");
		
		// Resize current window to the set dimension
	    wd.manage().window().maximize();
	    
	    // To Delay execution for 5 sec. as to view the maximize browser
	 	Thread.sleep(5000);
	
// 1. Supplier - Add invoice (*Once the calender opens, select date manually within 10 sec)
//----------------------------------------------------------------------------------
	 	
		wd.findElement(By.id("email")).sendKeys("john@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(6000);
	
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section"
				+ "/div/div[5]/section/div[2]/form/div[3]/button")).click();// Click on 'Sign In' button
		Thread.sleep(5000); 
		                         
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section"
				+ "/div/div[1]/div/div[2]/button")).click();// Click on create request
		Thread.sleep(10000);
		
		Select s;
		s=new Select(wd.findElement(By.id("companyNameData")));// Buyer name
		s.selectByVisibleText("Buyer"); 
		Thread.sleep(1000);
		s=new Select(wd.findElement(By.id("companyTypeOptions")));// Company type
		s.selectByVisibleText("Aluminium");
		Thread.sleep(1000);
		
		wd.findElement(By.id("contactName")).sendKeys("Buyer-ABC"); // Contact name
		Thread.sleep(1000);
		
//		s=new Select(wd.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/section/div/div/form/div[2]/div[2]/div/div/span")));
//		s.selectByValue("+91"); 
		wd.findElement(By.id("companyPhone")).sendKeys("4546555"); // Contact No
		Thread.sleep(1000);
		wd.findElement(By.id("companyEmail")).sendKeys("buyer@gmail.com"); // Company email
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		
		wd.findElement(By.id("purchaseTitle")).sendKeys("Testing Project");
		Thread.sleep(1000); // Purchase order title 
		
		wd.findElement(By.id("payableDate")).click();
		Thread.sleep(10000); // Payable date calender 
		
		wd.findElement(By.id("purchaseNo")).sendKeys("PO101");
		Thread.sleep(1000); //PO number
		
		wd.findElement(By.id("purchaseDate")).click();
		Thread.sleep(10000); //PO date calender
		
		wd.findElement(By.id("purchaseAmount")).sendKeys("100");
		// PO Amount 
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		
		wd.findElement(By.id("invoiceNo")).sendKeys("INV101");
		Thread.sleep(1000); //Invoice number
		wd.findElement(By.id("invoiceDate")).click();
		Thread.sleep(10000); //Invoice date calender

		wd.findElement(By.id("invoiceAmount")).sendKeys("100");
		// Invoice Amount 
		
		wd.findElement(By.id("grnNo")).sendKeys("GRN1");
		Thread.sleep(1000); //GRN number
		wd.findElement(By.id("grnDate")).click();
		Thread.sleep(4000); //GRN date calender
	    
		//Fullpage screenshots
	    Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(wd);
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("F:\\Screenshots\\infactor//IF_CreateReqForm.png"));
	    Thread.sleep(4000);	
	    
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div/button[2]")).click();// Click on Submit button
		Thread.sleep(8000);
		wd.findElement(By.id("dropdownToggle")).click();//Click on dropdown
		Thread.sleep(8000);

		wd.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/ul/li[2]/ul/li/a")).click();// Click on logout
		
// 2. BUYER'S LOGIN - Approve Invoice
//----------------------------------------------------------------------------------		
		wd.get("http://test.infactor.io/login");
		Thread.sleep(1000); 
		
//		wd.findElement(By.id("email")).sendKeys("supplier@gmail.com");
		wd.findElement(By.id("email")).sendKeys("gm@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(6000);
	
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[5]/section"
				+ "/div[2]/form/div[3]/button")).click();//login
		Thread.sleep(4000); 
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section"
				+ "/div/div[3]/section/div")).click(); //View details
		Thread.sleep(8000);
		
		wd.findElement(By.id("description")).sendKeys("Approving Request");//Remark
		Thread.sleep(5000);   
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/div/div[4]/section"
				+ "/div/div/div/div[5]/div[2]/div[2]/button")).click();//Approved button
		
		wd.findElement(By.id("dropdownToggle")).click();//dropdown
		Thread.sleep(6000);
		
		wd.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[2]/ul/li/a")).click();//logout
			
// 3. SUPPLIER'S LOGIN - Request for factoring
//----------------------------------------------------------------------------------		
		wd.get("http://test.infactor.io/login");
		Thread.sleep(1000); 
		
		wd.findElement(By.id("email")).sendKeys("john@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(6000);
	
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/"
				+ "div/div[5]/section/div[2]/form/div[3]/button")).click();//login
		Thread.sleep(4000); 

		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/"
				+ "div/div[3]/section/div/div/div/div/table/tbody/tr[1]")).click(); //View details
		Thread.sleep(8000); 
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/"
				+ "div/div[4]/section/div/div/div/div[7]/div[2]/div/button")).click(); //Factor now Button
		
		wd.findElement(By.id("dropdownToggle")).click();//dropdown
		Thread.sleep(6000);
								
		wd.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[2]/ul/li/a")).click();//logout

// 4. FINANCER'S LOGIN - Send factoring proposal
//----------------------------------------------------------------------------------		
		wd.get("http://test.infactor.io/login");
		Thread.sleep(1000); 
		
		wd.findElement(By.id("email")).sendKeys("alex@infactor.io");
	
		wd.findElement(By.id("password")).sendKeys("infactor");
		Thread.sleep(6000);
	
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/"
				+ "div/div[5]/section/div[2]/form/div[3]/button")).click();//login
		Thread.sleep(4000); 
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section"
				+ "/div/div[3]/section/div/div/div/div/table/tbody/tr[1]")).click(); //View details
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/"
				+ "div/div[4]/section/div/div/div[1]/div[9]/div[3]/div[1]/button")).click(); //Proceed button
Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(4000);
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/div/div[4]/section"
				+ "/div/div/div[1]/div[8]/div[4]/div")); 
		Thread.sleep(1000);

	    
//		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/div/div[4]/section"
//				+ "/div/div/div[1]/div[8]/div[4]/div/div/span[5]")).click(); //Estimated charges
		Thread.sleep(3000);
		
		wd.findElement(By.xpath("/html/body/div[4]/div/div/section/div/div[4]/section"
				+ "/div/div/div[1]/div[8]/div[6]/div/div/span[5]")).click(); //First payment %
		Thread.sleep(3000);
		 
		wd.findElement(By.id("description")).sendKeys("Sending Factoring Proposal");
		Thread.sleep(4000);   

		wd.findElement(By.name("file")).sendKeys("C:\\Users\\Tradefinex\\Downloads\\1547210352041_vrush.jpg");
		
		
		
		
		
	}


}
