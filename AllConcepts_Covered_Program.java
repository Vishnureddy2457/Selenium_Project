package com.seleniumprjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AllConcepts_Covered_Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); 
		Actions actions = new Actions(driver); 
		
		driver.get("https://www.hyrtutorials.com/search/label/TechNews#"); 
		driver.manage().window().maximize(); 
		
		WebElement menu = driver.findElement(By.xpath("//a[.='Selenium Practice']"));
		WebElement selenium_frame = driver.findElement(By.xpath("//a[.='Frames Practice']"));
		actions.moveToElement(menu)
		.moveToElement(selenium_frame).click().perform();
		
		driver.findElement(By.id("name")).sendKeys("hi this is vishnu");
		
		
		driver.switchTo().frame("frm1");
		Select coursename = new Select(driver.findElement(By.id("course")));
		coursename.selectByVisibleText("Python");
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("hi task completed");
		
		driver.switchTo().frame("frm2");
		driver.findElement(By.id("firstName")).sendKeys("vishnu");
		
		driver.findElement(By.xpath("//input[@id='malerb']")).click();
		
		driver.switchTo().parentFrame();
		
		
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("hi task ending");
		
		Thread.sleep(5000);
		
		
		driver.quit();

	}

}
