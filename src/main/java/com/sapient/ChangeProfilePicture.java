package com.sapient;
import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ChangeProfilePicture {
	
	static String URL;
	static String Image;
	public ChangeProfilePicture(String url, String image) {
		URL = url;
		Image = image;
	}
	
	public void changeImage() throws InterruptedException {
		// Set the browser
		System.setProperty("webdriver.chrome.driver", "//Users//sagshukl//Desktop//Automation//ChromeDriver//chromedriver");
		
		// Initialize browser
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		// Open Browser
		driver.get(URL);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title = 'Menu']")));
		
		// Click on menu button
		driver.findElement(By.xpath("//*[@title = 'Menu']")).click();
		
        Thread.sleep(1000);
		
		// Click on profile button
		driver.findElement(By.xpath("//*[@title = 'Profile']")).click();
		
		// Tap on profile picture
		element = driver.findElement(By.xpath("//img[@class='_3Whw5']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
		// Upload profile picture
		driver.findElement(By.xpath("//*[@type = 'file']")).sendKeys(Image);

		// Perform the click operation that opens new window
		
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		
		Thread.sleep(2000);
		// Confirm new profile picture
		driver.findElement(By.xpath("//*[@class = '_3y5oW _3qMYG']")).click();
	}
}
