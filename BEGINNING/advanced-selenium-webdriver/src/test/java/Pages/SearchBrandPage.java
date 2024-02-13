package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchBrandPage {
	
	WebDriver driver;
	public SearchBrandPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void SearchBrands() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click on brands links
		Actions a =new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"))).perform();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//search brandname 
		WebElement Searchinputbox = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='brandSearchBox']")));
		String BrandName = "Maybelline New York";
		Searchinputbox.sendKeys(BrandName);
		//click on branch Searched
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='list_topbrands']//following-sibling::div//a[text()='Maybelline New York'])[1]")));
		WebElement SearchedBrand = driver.findElement(By.xpath("(//div[@id='list_topbrands']//following-sibling::div//a[text()='Maybelline New York'])[1]"));
		Thread.sleep(10000);
		SearchedBrand.click();	
		//verify Brand name on Searching result page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Buy Maybelline New York Products Online']")));
		boolean BrandSearch=driver.findElement(By.xpath("//h1[text()='Buy Maybelline New York Products Online']")).getText().contains(BrandName);
		Assert.assertTrue(BrandSearch);
		
			
	}
}
