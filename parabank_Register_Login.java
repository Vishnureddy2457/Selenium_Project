package com.practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parabank_Register_Login {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Unique username (important)
        String username = "abc12345";

        // Registration
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName"))).sendKeys("Vishnu");
        driver.findElement(By.id("customer.lastName")).sendKeys("Reddy");
        driver.findElement(By.id("customer.address.street")).sendKeys("Hyderabad");
        driver.findElement(By.id("customer.address.city")).sendKeys("Hyderabad");
        driver.findElement(By.id("customer.address.state")).sendKeys("Telangana");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("500001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9999999999");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456");

        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys("Abc123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Abc123");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register']"))).click();
        
        Thread.sleep(5000);

        // Validation (Registration)
        boolean isRegistered = driver.getPageSource().contains("Welcome");
        if (isRegistered) {
            System.out.println("Registration Successful ✅");
        } else {
            System.out.println("Registration Failed ❌");
        }

        // Logout
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out"))).click();

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("Abc123");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log In']"))).click();

        // Validation (Login)
        boolean isLoggedIn = driver.getPageSource().contains("Overview");
        if (isLoggedIn) {
            System.out.println("Login Successful ✅");
        } else {
            System.out.println("Login Failed ❌");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}