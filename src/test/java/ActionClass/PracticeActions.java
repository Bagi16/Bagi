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

import javax.swing.*;
import java.time.Duration;

public class PracticeActions {
    @Test
    public void DragAndDropPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement beforeDropMsg = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']//p[.='Drop here']"));
        String actualBeforeMsg = BrowserUtils.getText(beforeDropMsg);
        String expectedBeforeMsg ="Drop here";
        Assert.assertEquals(actualBeforeMsg,expectedBeforeMsg);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropBox).perform();
        dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualColorAfter = dropBox.getCssValue("background-color");
        String expectedColorAfter = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColorAfter, expectedColorAfter);

        WebElement AfterMsg = driver.findElement(By.xpath("//div[@id='droppable']//p[.='Dropped!']")) ;
        String actualAfterMsg = BrowserUtils.getText(AfterMsg);
        String expectedAfterMsg = "Dropped!";
        Assert.assertEquals(actualAfterMsg,expectedAfterMsg);

        
    }

    @Test
    public void ClickAndReleasePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement ClickAccept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        ClickAccept.click();
        Thread.sleep(2000);

        WebElement notAccept=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualNotAccept = BrowserUtils.getText(notAccept);
        String expectedNotAccept = "Not Acceptable";
        Assert.assertEquals(actualNotAccept,expectedNotAccept);

        WebElement DropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualDropHere = BrowserUtils.getText(DropBox);
        String expectedDropHere = "Drop here";
        Assert.assertEquals(actualDropHere,expectedDropHere);

        Actions actions = new Actions(driver);
        actions.clickAndHold(notAccept).moveToElement(DropBox).release().perform();

        //DropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualAfterDropMsg = BrowserUtils.getText(DropBox);
        String expectedAfterDropMsg = "Drop here";
        Assert.assertEquals(actualAfterDropMsg,expectedAfterDropMsg);





    }
}