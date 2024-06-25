package Class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
    //go to syntax hrms
    //we need to wright to case to verify the wrong credentials give error message
    //assert that username text box is displayed
    // quit the browser
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)

    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }
    @Test(groups="Regression")
    public void invalidCredentials(){
        WebElement username= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']")) ;
        WebElement lgnButton=driver.findElement(By.xpath("//input[@id='btnLogin']"));

        username.sendKeys("WeatherMay");
        password.sendKeys("abccefgh");
        lgnButton.click();

        WebElement errorMsg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        //burada once asagidali kodu yazip manuel olarak bak yext in ne olduguna sonra sil ve asagidan devam et
        // System.out.println(errorMsg.getText());

        String errorMe=errorMsg.getText();

        // expected texti gercek hayatta requirements lardan aliriz
        String expectedText="Invalid credentials";

        SoftAssert soft= new SoftAssert();
        soft.assertEquals(errorMe,expectedText);

        username= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean disPlayed=username.isDisplayed();
        System.out.println(disPlayed);
        soft.assertTrue(disPlayed);
        soft.assertAll();




    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){

        driver.quit();
    }
}
