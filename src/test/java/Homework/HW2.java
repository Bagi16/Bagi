package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HW2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement error= driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface:')]"));
        String actualError = error.getText().trim();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        System.out.println(actualError.equals(expectedError)? "Error Validated":"Failed");

        driver.quit();

    }
}
