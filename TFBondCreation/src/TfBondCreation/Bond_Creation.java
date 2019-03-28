package TfBondCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Bond_Creation {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		
		WebDriver wd=new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) wd;
		
		wd.get("https://www.tradefinex.org/publicv/bond_create");
		Thread.sleep(3000);
		
		//Bond Creation form 
		
		wd.findElement(By.id("tokenName")).sendKeys("TradefinexBond");
		
		wd.findElement(By.id("tokenSymbol")).sendKeys("TFXB");
		Thread.sleep(2000);
		
		wd.findElement(By.id("tokenSupply")).sendKeys("100000");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		
		wd.findElement(By.id("bonusRate")).sendKeys("100");
		
		wd.findElement(By.id("ethRate")).sendKeys("10");
		
		wd.findElement(By.id("coupon")).sendKeys("10");
		
		wd.findElement(By.id("tenure")).sendKeys("1");
 
	    wd.findElement(By.id("defaultReal")).click(); 
	    Thread.sleep(10000);
		
		wd.findElement(By.id("bond_create")).click(); // Create bond button
		Thread.sleep(1000);
		wd.findElement(By.id("bond_create")).click();
		Thread.sleep(6000);
		
		if(wd.findElement(By.id("deploy_contract")).isDisplayed())
		{
			System.out.println("Deploying Contract");
			wd.findElement(By.id("deploy_contract")).click(); // Deploy Bond button
			Thread.sleep(10000);
			wd.findElement(By.id("DeployBtn")).click(); // (Contract Deployment in process.) OK button
			
		}
		else
		{	
			System.out.println("Sorry!! Bond Name already exists. Try another Bond Name..");
			Thread.sleep(4000);
			wd.findElement(By.id("sorry")).click(); // OK button
			Thread.sleep(6000);
		}
		wd.close();
	}

} 