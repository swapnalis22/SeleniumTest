package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class NykaaHomePage {
	
	WebDriver driver;
	public NykaaHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void Verifyhomepage()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Inside VerifyHomepage");
		System.out.println("Inside VerifyHomepage");
		boolean Menu1=driver.findElement(By.id("category")).getText().equalsIgnoreCase("categories");
		Assert.assertTrue(Menu1);
		
		boolean Menu2=driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]")).getText().equalsIgnoreCase("brands");
		Assert.assertTrue(Menu2);
		
		boolean Menu3=driver.findElement(By.xpath("(//li[@id='nykaaNetwork']//a)[1]")).getText().equalsIgnoreCase("luxe");
		Assert.assertTrue(Menu3);
		
		boolean Menu4=driver.findElement(By.xpath("(//li[@id='popups']//a)[1]")).getText().equalsIgnoreCase("nykaa fashion");
		Assert.assertTrue(Menu4);
		
		boolean Menu5=driver.findElement(By.xpath("(//li[@id='beauty_advice']//a)[1]")).getText().equalsIgnoreCase("beauty advice");
		Assert.assertTrue(Menu5);
		System.out.println(" outside VerifyHomepage");
		Reporter.log("Outside VerifyHomepage");
	}
	
}
