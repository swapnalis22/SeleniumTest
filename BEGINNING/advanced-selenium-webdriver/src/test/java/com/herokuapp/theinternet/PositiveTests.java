package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.FilterBrandPricePage;
import Pages.NykaaHomePage;
import Pages.SearchBrandPage;

public class PositiveTests {
	WebDriver driver;
	NykaaHomePage	objHomePage;
	SearchBrandPage	objSearchBrands;
	FilterBrandPricePage	objFilterBrandPrice;
	
	@BeforeTest
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
	// Create driver
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// open main page
	String url = "https://www.nykaa.com/";
	driver.get(url);
	System.out.println("Main page is opened.");
	}
	
	@Test(priority=1)
	public void Homepage() {
		
		objHomePage = new NykaaHomePage(driver);
		objHomePage.Verifyhomepage();
		System.out.println("home page verification done.");
	}
	
	@Test(priority=2)
	public void SearchBrands() throws InterruptedException
	{
		objSearchBrands = new SearchBrandPage(driver);
		objSearchBrands.SearchBrands();
		System.out.println("Search Brand Page verification done.");
	}
	
	@Test(priority=3)
	
	public void FilterBrandPrice() throws InterruptedException
	{
		objSearchBrands = new SearchBrandPage(driver);
		objSearchBrands.SearchBrands();
		System.out.println("Search Brand Page verification done.");
		objFilterBrandPrice = new FilterBrandPricePage(driver);
		objFilterBrandPrice.FilterPrice();
		System.out.println("Filter Branch Price verification done.");
	}
	
	
	@AfterTest
	public void teardown()
	{
		// Close browser
		System.out.println("browser closed.");
				driver.quit();
	}
}
