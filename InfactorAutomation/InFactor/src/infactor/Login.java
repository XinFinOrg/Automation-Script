package infactor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		
		WebDriver wd=new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) wd;	
		
		wd.get("http://test.infactor.io/login");
		Thread.sleep(1000);
		
		 FileInputStream fi=new FileInputStream("F:\\infactor.xlsx"); //File name
		 

			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet("Login"); //Sheet name
			XSSFCell un,pw,r,rs,crs,rs1;
			
			for(int i=1; i<=sh.getLastRowNum(); i++)
			{
				un=sh.getRow(i).getCell(0); 
				rs=sh.getRow(i).createCell(1);
				pw=sh.getRow(i).getCell(2);
				rs1=sh.getRow(i).createCell(3);
				r=sh.getRow(i).createCell(4);
				
				try{
		try{
		wd.findElement(By.id("email")).sendKeys(un.toString()); //Email
		}
		catch(Exception e){
		}
		try
		{
		wd.findElement(By.id("password")).sendKeys(pw.toString()); //Password
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("/html/body/div[3]/div[2]/section/div/div[5]/section/div[2]/form/div[3]/button")).click();//login
		Thread.sleep(1000);
		
		wd.findElement(By.id("dropdownToggle")).click();//dropdown
		Thread.sleep(1000);
		
		wd.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[2]/ul/li/a")).click();//logout
		
		System.out.println("Valid Username: "+un+" "+"Valid Username: "+pw);
		r.setCellValue("Pass");
		Thread.sleep(4000);	
		wd.navigate().to("http://test.infactor.io/login");
		Thread.sleep(4000);	
		
				}
				
				catch(Exception e)
				{
					if(wd.getPageSource().contains("Invalid email, please enter valid email.")){
						rs.setCellValue("Invalid email, please enter valid email.");	
					}
					
				
					System.out.println("Invalid Username: "+un+" "+"Invalid Username: "+pw);
					r.setCellValue("Fail");
					
					wd.navigate().to("http://test.infactor.io/login");
					Thread.sleep(4000);			
			
					}
			}
				
				fi.close();
				FileOutputStream fo=new FileOutputStream("F:\\infactor.xlsx");
				wb.write(fo);
				}

	}