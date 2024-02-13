package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterBrandPricePage {
	
	WebDriver driver;
	public FilterBrandPricePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void FilterPrice()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scroll until price filter
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		//click on Price filter
		driver.findElement(By.xpath("//span[text()='Price']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait for Rs.0 -Rs. 499 checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Rs. 0 - Rs. 499']//following::div[@class=\\\"control-indicator checkbox \\\"])[1]")));
		driver.findElement(By.xpath("(//span[text()='Rs. 0 - Rs. 499']//following::div[@class=\"control-indicator checkbox \"])[1]")).click();		
		WebElement ProductCount= driver.findElement(By.xpath("(//span[text()='Rs. 0 - Rs. 499']//following::span[@class='count'])[1]"));
		String ActualProductCount = ProductCount.getText();
		//get count of products for future use
		System.out.println("Total product count is:"+ActualProductCount);
		
	}
	
}
