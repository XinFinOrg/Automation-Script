package infactor;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Registration {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		
		WebDriver wd=new FirefoxDriver();
		
		wd.get("http://test.infactor.io/signup");
		Thread.sleep(1000);
		
		 FileInputStream fi=new FileInputStream("F:\\infactor.xlsx");
		 

			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet("Signup");
			XSSFCell fn,ln,email,pw,cpw,r;
			
			for(int i=1; i<=sh.getLastRowNum(); i++)
			{
				fn=sh.getRow(i).getCell(0);//first name 
				//rs=sh.getRow(i).createCell(1);
				ln=sh.getRow(i).getCell(2); //last name
				//rs1=sh.getRow(i).createCell(3);
				email=sh.getRow(i).createCell(4); //email id
				//rs2=sh.getRow(i).createCell(5);
				pw=sh.getRow(i).createCell(6); //password
				//rs3=sh.getRow(i).createCell(7);
				cpw=sh.getRow(i).createCell(8); //confirm password
				//rs4=sh.getRow(i).createCell(9);
				r=sh.getRow(i).createCell(10); // Result:Pass/Fail
				
			try{
					try{
					wd.findElement(By.id("firstName")).sendKeys(fn.toString());
					}
					catch(Exception e){
					}
					try
					{
					wd.findElement(By.id("lastName")).sendKeys(ln.toString());
					}
					catch(Exception e)
					{	
					}
					try
					{
					wd.findElement(By.id("email")).sendKeys(email.toString());
					}
					catch(Exception e)
					{	
					}
					try
					{
					wd.findElement(By.id("password")).sendKeys(pw.toString());
					}
					catch(Exception e)
					{	
					}
					try
					{
					wd.findElement(By.id("confirmPassword")).sendKeys(cpw.toString());
					}
					catch(Exception e)
					{	
					}
					
					
					wd.findElement(By.className("btn btn-primary btn-corner-login btn-lg")).click();//login
					Thread.sleep(5000);
					
					//wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/ul/li[2]/a/i")).click();//logout
					
					System.out.println("Pass");
					r.setCellValue("Pass");
					Thread.sleep(4000);	
					wd.navigate().to("http://test.infactor.io/signup");
					Thread.sleep(4000);	
					
					
				} 
				catch(Exception e)
				{
					System.out.println("Fail");
					r.setCellValue("Fail");
					
					wd.navigate().to("http://test.infactor.io/signup");
					Thread.sleep(4000);
				}
			
			}
	}
}
