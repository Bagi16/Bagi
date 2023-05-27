package SelectClass;

import Utils.BrowserUtils;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        Thread.sleep(2000);

        WebElement stockType = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(stockType, "new", "value");
        Thread.sleep(2000);

        WebElement makeType = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makeType, "lexus", "value");
        Thread.sleep(2000);

        WebElement modelType = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(modelType, "lexus-rx_350", "value");

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select aPrice = new Select(price);
        String actual = BrowserUtils.getText(aPrice.getFirstSelectedOption());
        String expected = "No max price";
        Assert.assertEquals(actual, expected);

        WebElement distanceType = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distanceType, "40", "value");

        WebElement zipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60065");

        WebElement search = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        search.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement sortDropDown = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortDropDown, "list_price", "value");
        Thread.sleep(3000);
        List<WebElement> lexus350List = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
        int count = 0;
        for (int i = 0; i < lexus350List.size(); i++) {
            Assert.assertTrue(BrowserUtils.getText(lexus350List.get(i)).contains("Lexus RX 350"));
            System.out.println(lexus350List.get(i).getText());
            count++;
            System.out.println(count);
        }

        //price sort lowest to highest, remove $ and , and validate

        List<WebElement> allPrice = driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPrice = new ArrayList<>();
        List<Integer> expectedPrice = new ArrayList<>();

        for(int i = 0; i<actualPrice.size(); i++){
            actualPrice.add(Integer.parseInt(BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",","")));
            expectedPrice.add(Integer.parseInt(BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",","")));
            System.out.println(actualPrice);
            System.out.println(expectedPrice);
        }
        Collections.sort(expectedPrice);
        Assert.assertEquals(actualPrice,expectedPrice);

    }
}
