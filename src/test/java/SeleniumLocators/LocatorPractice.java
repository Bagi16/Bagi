package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
            /*
            1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
            2-Enter first and last name (textbox).
            3-Select gender (radio button).
            4-Select years of experience (radio button).
            5-Enter date.(send keys)
            6-Select Profession (Checkbox). -->choose Both
            7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
            8-Select Continent(Send Keys).
            9-Click on Submit button.
            10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
            10-Close the webpage
            Try your own logic and automate it without any help.
                */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().window().maximize();

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Bagi");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Ganbold");
        Thread.sleep(3000);
        WebElement genderBox = driver.findElement(By.id("sex-0"));
        genderBox.click();

        WebElement yearsExperience = driver.findElement(By.id("exp-3"));
        yearsExperience.click();

        WebElement dateInPut = driver.findElement(By.id("datepicker"));
        dateInPut.sendKeys("05/16/2023");

        WebElement professionBox1 = driver.findElement(By.id("profession-0"));
        WebElement professionBox2 = driver.findElement(By.id("profession-1"));
        professionBox1.click();
        professionBox2.click();

        WebElement toolBox= driver.findElement(By.id("tool-2"));
        toolBox.click();

        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("NorthAmerica");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";

        System.out.println(actualURL.equals(expectedURL)? "URL PASSED":"URL FAILED");

        driver.close();










    }
}
