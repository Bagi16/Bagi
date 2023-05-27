package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class TestChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");

    }

    @Test
    public void NegativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("DEMO");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement alert = driver.findElement(By.cssSelector("#alert"));
        Assert.assertEquals(alert.getText().trim(), "No match for Username and/or Password.");

    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement securityXButton = driver.findElement(By.cssSelector(".btn-close"));
        securityXButton.click();

        WebElement catalogMenu = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogMenu.click();

        WebElement productMenu = driver.findElement(By.partialLinkText("Products"));

        Assert.assertTrue(productMenu.isDisplayed());

    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement securityXButton = driver.findElement(By.cssSelector(".btn-close"));
        securityXButton.click();
        Thread.sleep(2000);

        WebElement catalogMenu = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogMenu.click();
        Thread.sleep(2000);

        WebElement productMenu = driver.findElement(By.partialLinkText("Products"));
        productMenu.click();
        Thread.sleep(2000);
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));

        for (int i = 1; i < checkBoxes.size(); i++) {
            Thread.sleep(1500);
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(checkBoxes.get(i).isEnabled());
            Assert.assertFalse(checkBoxes.get(i).isSelected());
            checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxes.get(i).isSelected());
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

    }
    /*
    TEST CASE:

    1. You should click the productName Button
    2. You should create 2 arrayList
        *-One of them will be actualData
        *-Another will be expectedData
    3. For (int i = 1)
        *-store all the name for both of the list
    4. For expected List --> you will use Collections.sort(expectedList)
                         --> Collections.reverse(expected)
                         Assert.equals(actualList,expectedList)
     */

    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement securityXButton = driver.findElement(By.cssSelector(".btn-close"));
        securityXButton.click();
        Thread.sleep(2000);

        WebElement catalogMenu = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogMenu.click();
        Thread.sleep(2000);

        WebElement productMenu = driver.findElement(By.partialLinkText("Products"));
        productMenu.click();
        Thread.sleep(2000);

        WebElement productNameButton = driver.findElement(By.cssSelector("//a[.='Product Name']"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductNames= new ArrayList<>();
        List<String> expectedProductNames = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {
            actualProductNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedProductNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(2000);
        Collections.sort(expectedProductNames);
        System.out.println(actualProductNames);// print out to make sure
        System.out.println(expectedProductNames);
        Assert.assertEquals(actualProductNames,expectedProductNames);

    }

    @Test
    public void validatingProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement securityXButton = driver.findElement(By.cssSelector(".btn-close"));
        securityXButton.click();
        Thread.sleep(2000);

        WebElement catalogMenu = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogMenu.click();
        Thread.sleep(2000);

        WebElement productMenu = driver.findElement(By.partialLinkText("Products"));
        productMenu.click();
        Thread.sleep(2000);

        WebElement productNameButton = driver.findElement(By.xpath("//a[.='Product Name']"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductNames= new ArrayList<>();
        List<String> expectedProductNames = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {
            actualProductNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedProductNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(2000);
        Collections.sort(expectedProductNames);
        Collections.reverse(expectedProductNames);
        Assert.assertEquals(actualProductNames,expectedProductNames);

    }

    @Test
    public void validatingPriceFunctionalityLargestToSmallest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.cssSelector(".btn"));
        login.click();
        Thread.sleep(2000);

        WebElement securityXButton = driver.findElement(By.cssSelector(".btn-close"));
        securityXButton.click();
        Thread.sleep(2000);

        WebElement catalogMenu = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogMenu.click();
        Thread.sleep(2000);

        WebElement productMenu = driver.findElement(By.partialLinkText("Products"));
        productMenu.click();
        Thread.sleep(2000);

        WebElement priceButton = driver.findElement(By.xpath("//a[.='Price']"));
        priceButton.click();
        Thread.sleep(2000);



    }


}
