package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPracticeMidLevel {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Bagi");

        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Ganbold");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("bggii@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("1234567890");

        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("bagi12345");

        WebElement passwordConfirm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("bagi12345");

        WebElement agreeBox = driver.findElement(By.xpath("//input[@name='agree']"));
        agreeBox.click();

        WebElement continueButton1 = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton1.click();

        WebElement Header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualHeader = driver.getTitle().trim();
        String expectedHeader = "Your Account Has Been Created!";

        System.out.println(expectedHeader.equals(actualHeader)? "Header Validated":"Header Failed");

        WebElement continueButton3 = driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton3.click();


        //URL Validation
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualURL.equals(expectedURL)? "URL Validated!": "Test Failed");

        driver.quit();



    }
}
