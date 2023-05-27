package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/batboldganbold/Downloads/Techtorial.html");

        //verify United States as default

        WebElement countries = driver.findElement(By.xpath("//select[@name='country']"));
        Select DefaultOption = new Select(countries);
        String actual = DefaultOption.getFirstSelectedOption().getText().trim();
        String expected = "UNITED STATES".trim();
        Assert.assertEquals(actual,expected);

        //Print out all options and count

        List<WebElement> allcountries = DefaultOption.getOptions();
        int count = 0;
        for(WebElement country: allcountries){
            System.out.println(country.getText());
            count++;
        }
        System.out.println(count);

        //Choose your own country with VisibleText method
        //Choose Favorite country
        //Choose Travel country with index
        //Thread.sleep(2000)

        DefaultOption.selectByVisibleText("MONGOLIA");
        Thread.sleep(2000);
        DefaultOption.selectByValue("123");
        Thread.sleep(2000);
        DefaultOption.selectByIndex(43);


    }
}
