package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("file:///Users/batboldganbold/Downloads/Techtorial.html");
        driver.manage().window();

        //LINKTEXT LOCATOR

        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader)? "Java Passed":"Java Failed");
        driver.navigate().back();

        /*
        1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
        2-Go back to the main page
        3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
        4-Go back to the main page
        5-Click TestNG and validate(ternary) header -->TestNG
        6-Go back to the main page
        7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
        */

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.className("display-1"));
        String actualSelenium = seleniumHeader.getText().trim();
        String expectedSelenium = "Selenium automates browsers. That's it!";
        System.out.println(actualSelenium.equals(expectedSelenium)? "Selenium Passed":"Selenium Failed");
        driver.navigate().back();
        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualCucumber = cucumberHeader.getText().trim();
        String expectedCucumber = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumber.equals(expectedCucumber)? "Cucumber Passed":"Cucumber Failed");
        driver.navigate().back();
        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        String actualNG = testNGHeader.getText().trim();
        String expectedNG ="TestNG";
        System.out.println(actualNG.equals(expectedNG)? "TestNG Passed": "TestNG Failed");
        driver.navigate().back();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="file:///Users/batboldganbold/Downloads/Techtorial.html";
        System.out.println(actualURL.equals(expectedURL)? "URL Passed": "URL Failed");

        //PARTIAL LINKTEXT LOCATOR

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();

        System.out.println(driver.getTitle());







    }
}
