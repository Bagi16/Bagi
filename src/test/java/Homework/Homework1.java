package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.facebook.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle ="Facebook - log in or sign up";
        System.out.println(actualTitle.equals(expectedTitle)? "Passed":"Failed");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";
        System.out.println(actualUrl.equals(expectedUrl)? "Url Passed":"Url Failed");

        driver.close();





    }
}
