package infactor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginWithExcel {

	public static void main(String[] args) throws Exception 
	{	
		//Here we have to set the path of Driver (ChromeDriver / FirefoxDriver)
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		
		// Comment the above 2 lines and uncomment below 2 lines to use Chrome
//		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//		WebDriver wd = new FirefoxDriver();
		
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) wd;	
		
		// Launch the http://test.infactor.io/signup
		wd.get("http://test.infactor.io/login");
		
		//Resize current window to the set dimension
	    wd.manage().window().maximize();
	    
	    // To Delay execution for 5 sec. as to view the maximize browser
		Thread.sleep(5000);
		
		// Specify the path of file
		FileInputStream fi=new FileInputStream("F:\\infactor.xlsx"); 

		// Load workbook
		XSSFWorkbook wb=new XSSFWorkbook(fi);
			
		// Call the getSheet() method of Workbook and pass the Sheet Name here. 
	    // In this case I have given the sheet name as “Login” 
		XSSFSheet sh=wb.getSheet("Login");
		XSSFCell un,pw,r,rs,rs1;
			
			for(int i=1; i<=sh.getLastRowNum(); i++)
			{
			    // getRow() specify which row we want to read and getCell() specify which column to read.
				// getStringCellValue() specify that we are reading String data.
				// Here createCell will create column and setCellvalue will set the value 
				
				un=sh.getRow(i).getCell(0); 
				rs=sh.getRow(i).createCell(1);
				pw=sh.getRow(i).getCell(2);
				rs1=sh.getRow(i).createCell(3);
				r=sh.getRow(i).createCell(4);
				
		try{
			try{
			wd.findElement(By.id("email")).sendKeys(un.toString()); // Enter UserName
			}
			catch(Exception e){
			}
			try
			{
			wd.findElement(By.id("password")).sendKeys(pw.toString()); // Enter Password
			Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			// This  will scroll down the page by  400 pixel vertical
			js.executeScript("window.scrollBy(0,400)");
			Thread.sleep(2000);
			try
			{
			wd.findElement(By.xpath("/html/body/div[4]/div[2]/section/div/div[5]/"
			+ "section/div[2]/form/div[3]/button")).click();// Click on 'Sign In' button
			Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			wd.findElement(By.id("dropdownToggle")).click();//Click on Dropdown
			Thread.sleep(2000);
			
			wd.findElement(By.xpath("/html/body/div[3]/div/div[2]"
			+ "/div/ul/li[2]/ul/li/a")).click(); //Click on 'Logout' Button
			
			// If Username and password is valid then the "Pass" value will be printed in excel sheet
			System.out.println("Valid Username: "+un+" "+"Valid Username: "+pw);
			r.setCellValue("Pass");
			Thread.sleep(4000);	
			
			wd.navigate().to("http://test.infactor.io/login"); // Navigate to URL
			Thread.sleep(4000);	
			
					}				
		catch(Exception e)
		{		//If Username/email is invalid then the error message will be printed in excel sheet
				if(wd.getPageSource().contains("Invalid email, please enter valid email.")){
				rs.setCellValue("Invalid email, please enter valid email.");	
				}
				
				// If Username and password is invalid then the "Fail" value will be printed in excel sheet				
				System.out.println("Invalid Username: "+un+" "+"Invalid Username: "+pw);
				r.setCellValue("Fail");
					
				wd.navigate().to("http://test.infactor.io/login"); // Navigate to URL
				Thread.sleep(4000);			
			
			 }
		}
				
		fi.close();
		// Here we need to specify where you want to save file
		FileOutputStream fo=new FileOutputStream("F:\\infactor.xlsx");
		// finally write content 
		wb.write(fo);
		}

	}