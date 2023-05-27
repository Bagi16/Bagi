package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    /*
    1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrival in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Available"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-Navigating to the Website
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        //2-Selecting One Way trip Button
        WebElement typeOption = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeOption.click();
        Thread.sleep(2000);

        //3-Selecting 4 passengers from Passengers DropBox
        WebElement passengerCountSelect = driver.findElement(By.xpath("//select[@name='passCount']"));
        //Select numberOfPassengers = new Select(passengerCountSelect);
        //numberOfPassengers.selectByValue("4");
        BrowserUtils.selectBy(passengerCountSelect,"4","value");
        Thread.sleep(2000);


        //4-Validating the Default "Acapulco" from Departing From DropBox
        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select DefaultBox = new Select(departing);
        String actualDefault = DefaultBox.getFirstSelectedOption().getText().trim();

        String expectedDefault = "Acapulco";
        Assert.assertEquals(actualDefault, expectedDefault);

        //5-Choosing Paris for Departing From DropBox
        //DefaultBox.selectByValue("Paris");
        BrowserUtils.selectBy(departing,"Paris","value");
        Thread.sleep(2000);

        //6-Choosing the date August 15th for Departing on DropBox
        WebElement departMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        //Select monthDepart = new Select(departMonth);
        //monthDepart.selectByValue("8");
        BrowserUtils.selectBy(departMonth,"8","value");
        WebElement departDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        //Select dayDepart = new Select(departDay);
        //dayDepart.selectByValue("15");
        BrowserUtils.selectBy(departDay,"15","value");
        Thread.sleep(2000);

        //7-Choosing San Francisco for Arriving in DropBox
        WebElement arrivingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        //Select arriving = new Select(arrivingBox);
        //arriving.selectByValue("San Francisco");
        BrowserUtils.selectBy(arrivingBox,"San Francisco","value");
        Thread.sleep(2000);

        //8-Choosing the date December 15th for Returning DropBox
        WebElement returnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        //Select monthReturn = new Select(returnMonth);
        //monthReturn.selectByValue("12");
        BrowserUtils.selectBy(returnMonth,"12","value");
        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        //Select dayReturn = new Select(returnDay);
        //dayReturn.selectByValue("15");
        BrowserUtils.selectBy(returnDay,"15","value");
        Thread.sleep(2000);

        //9-Choosing First Class Option
        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        Thread.sleep(2000);

        //11-Validating All the options from Airline DropBox
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineOptions = new Select(airline);
        List<WebElement> actualAirlines = airlineOptions.getOptions();
        List<String> expectedAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0; i<actualAirlines.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(actualAirlines.get(i)),expectedAirlines.get(i).trim());
        }

        //12-Choosing Unified Airline option from Airline DropBox
        airlineOptions.selectByVisibleText("Unified Airlines");
        Thread.sleep(2000);

        //13-Clicking Continue Button
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement noSeatsAvailable= driver.findElement(By.xpath("//font[@size='4']"));
        System.out.println(noSeatsAvailable.getText());
        String expectedResult ="After flight finder - No Seats Available";
        Assert.assertEquals(BrowserUtils.getText(noSeatsAvailable),expectedResult.trim());


        driver.quit();

    }


}
