package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();//maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://www.youtube.com/?themeRefresh=1");//URL

        WebElement searchJB = driver.findElement(By.xpath("//input[@id='search']"));
        searchJB.sendKeys("Justin Beiber");
        searchJB.sendKeys(Keys.ENTER);
        Thread.sleep(2000);//It gives enough time to Autamation to scroll down

        List<WebElement> justinBieberSongs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song:justinBieberSongs){
            if(song.getAttribute("title").contains("Ghost")){
                Thread.sleep(2000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }
        }




    }

}
