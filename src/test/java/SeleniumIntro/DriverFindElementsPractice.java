package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();//maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://the-internet.herokuapp.com/");//URL

        List<WebElement> links = driver.findElements(By.tagName("li"));

        //Printing out all the links and count
        int count = 0;
        for(WebElement link: links){
            System.out.println(link.getText());
            count++;
        }
        System.out.println(count);

        //Print it if length equal and more than 12 and count

        int count2 = 0;
        for(WebElement link: links){
            if(link.getText().length()>=12){
                System.out.println(link.getText().trim());
                count2++;
            }
        }
        System.out.println(count2);









    }

}
