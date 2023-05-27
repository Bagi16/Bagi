package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //Locators --> is a way to locate(find) element and manipulate it
    public static void main(String[] args) throws InterruptedException {

        //ID LOCATOR

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/batboldganbold/Downloads/Techtorial.html");


        WebElement header = driver.findElement(By.id("techtorial1"));

        String actualHeader = header.getText().trim();//it gets the text from element
        String expectedHeader = "Techtorial Academy";

        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader)? "Correct":"Incorrect");

        //Locating Paragraph Task
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Bagi");

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ganbold");

        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("773-690-8814");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("baagiishd@gmail.com");

        WebElement address= driver.findElement(By.name("address1"));
        address.sendKeys("67 Knightsbridge dr");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Mundelein");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Illinois");

        WebElement postal= driver.findElement(By.name("postalCode"));
        postal.sendKeys("60060");

        //CLASS LOCATOR

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement checkBox = driver.findElement(By.id("cond1"));
        if(checkBox.isDisplayed()&&!checkBox.isSelected()){
            checkBox.click();
        }
        System.out.println(checkBox.isSelected()? "Selected":"Not Selected");

        WebElement textNgBox= driver.findElement(By.id("cond3"));

        if(textNgBox.isDisplayed()&&!textNgBox.isSelected()){
            textNgBox.click();
        }
        System.out.println(textNgBox.isSelected()? "TestNG Selected":"TestNG Not Selected");

        WebElement cucumberBox = driver.findElement(By.id("cond4"));

        if(cucumberBox.isDisplayed()&&!cucumberBox.isSelected()){
            cucumberBox.click();
        }
        System.out.println(cucumberBox.isSelected()? "Cucumber Selected":"Cucumber Not Selected");

        //TAG NAME LOCATOR

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement tagName = driver.findElement(By.tagName("u"));
        System.out.println(tagName.getText());

        Thread.sleep(2000);





    }
}
