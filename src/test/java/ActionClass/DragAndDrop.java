package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void dragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement orangeDropBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMsg= BrowserUtils.getText(orangeDropBox);
        String expectedMsg = "... Or here.";
        Assert.assertEquals(actualMsg,expectedMsg);

        String actualBackgroundColor = orangeDropBox.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);

        WebElement dragCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragCircle,orangeDropBox).perform();
        orangeDropBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualText = BrowserUtils.getText(orangeDropBox);
        String expectedText = "You did great!";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void dragAndDrop2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMsg= BrowserUtils.getText(blueBox);
        String expectedBlueBoxMsg="Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMsg,expectedBlueBoxMsg);

        String actualBlueColor = blueBox.getCssValue("background-color").trim();
        String expectedBlueColor ="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueColor,expectedBlueColor);
        WebElement blueCircle =driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(blueCircle).moveToElement(blueBox).release().perform();
        blueCircle=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueMsg = BrowserUtils.getText(blueCircle);
        String expectedBlueMsg = "You did great!";
        Assert.assertEquals(actualBlueMsg,expectedBlueMsg);

    }
}
