package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {
    public static void main(String[] args) {

        //First Step is setting up your automation
        WebDriverManager.chromedriver().setup();// set up
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Create your Driver to start automation

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());

        //Validation

        String actualTitle = driver.getTitle();
        String expectedTittle = "Amazon.com. Spend less. Smile more.";

        if(actualTitle.equals(expectedTittle)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL is Passed");
        }else{
            System.out.println("URL is Failed");
        }

        driver.close();




    }
}
