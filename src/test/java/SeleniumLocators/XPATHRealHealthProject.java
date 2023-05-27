package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHRealHealthProject {
    public static void main(String[] args) {
                  /*
                    //THESE PARTS SHOULD BE DONE BY XPATH:
                    1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
                    2-Click Make an Appointment
                    3-Login the username and password provided and Login successfully
                    4-Choose the facility either HongKong or Seoul -->send keys
                    5-Click apply for hospital admission box if it is displayed and validate it is selected
                    6-Healthcare program 'Medicaid'
                    7-Visit date should be provided -->send keys
                    8-Put your comment for this box -->send keys
                    9-Book your appointment
                    THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
                    10-Validate the header is "Appointment confirmation" (if statement)
                    11-Print out the headers and values(only values) on your console.
                    12)Click go to homepage and print out url
                    13)Driver.quit or close.

           */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        //WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //CSS with ID #
        WebElement makeAppointment=driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppointment.click();


        WebElement firstName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        firstName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facilityOptions = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facilityOptions.sendKeys("Hongkong CURA Healthcare Center");

        WebElement admissionCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (admissionCheckBox.isDisplayed() && !admissionCheckBox.isSelected()) {
            admissionCheckBox.click();
        }

        WebElement medicaidRadioBox = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaidRadioBox.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("05/17/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I am making Appointment!");

        //WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        //CSS with Class .
        WebElement bookAppointmentButton = driver.findElement(By.cssSelector(".btn-default"));
        bookAppointmentButton.click();

        WebElement Header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String actualHeader = Header.getText().trim();
        String expectedHeader = "Appointment confirmation";

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Appointment Confirmed");
        }
        System.out.println("Appointment Not Validated");

        WebElement printOut1 = driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println(printOut1.getText());

        WebElement printOut2 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(printOut2.getText());

        WebElement printOut3 = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(printOut3.getText());

        WebElement printOut4 = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(printOut4.getText());

        WebElement printOut5 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(printOut5.getText());

        WebElement goHomeButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goHomeButton.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();


    }
}
