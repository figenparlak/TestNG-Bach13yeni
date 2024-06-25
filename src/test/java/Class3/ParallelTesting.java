package Class3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ParallelTesting {
    //go to syntax hrms
    //we need to wright to case to verify the wrong credentials give error message
    //assert that username text box is displayed
    // quit the browser
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void openBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "Regression")
    public void invalidCredentials() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement lgnButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        username.sendKeys("WeatherMay");
        password.sendKeys("abccefgh");
        lgnButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        //burada once asagidali kodu yazip manuel olarak bak yext in ne olduguna sonra sil ve asagidan devam et
        // System.out.println(errorMsg.getText());

        String errorMe = errorMsg.getText();

        // expected texti gercek hayatta requirements lardan aliriz
        String expectedText = "Invalid credential";

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(errorMe, expectedText);

        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean disPlayed = username.isDisplayed();
        System.out.println(disPlayed);
        soft.assertTrue(disPlayed);
        //bu beklemeyi konsolda olup biteni gormek icin koyduk
        //sleep for observing the console
        Thread.sleep(5000);
        soft.assertAll();


    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {

        driver.quit();
    }
}

