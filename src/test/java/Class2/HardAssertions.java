package Class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions {

    //go to syntax hrms
    //we need to wright to case to verify the wrong credentials give error message
    // quit the browser


    // once before metodu yazdik
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)

    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

     @Test(groups = "smoke")
    public void verifyIncalidCredentialsError() throws InterruptedException {
     WebElement username= driver.findElement(By.xpath("//input[@id='txtUsername']"));
      WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']")) ;
      WebElement lgnButton=driver.findElement(By.xpath("//input[@id='btnLogin']"));

      username.sendKeys("WeatherMay");
      password.sendKeys("abccefgh");
      lgnButton.click();

      WebElement errorMsg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
      String errorText=errorMsg.getText();
         System.out.println(errorText);
         String expectedMessag="Invalid credentials";
       // assert bir class testng kutuphanesinden

         Assert.assertEquals(expectedMessag,errorText);
 //ilk halinde gormek icin yeniden bulduk.yani username kutucugunda birsey yamadan once bulunan yazi

         username =driver.findElement(By.xpath("//input[@id='txtUsername']"));

         boolean userN= username.isDisplayed();




    }


    @AfterMethod
    public void afterMethod(){

      // driver.quit();
    }
    //@Test(alwaysRun = true)
    //public  void closeBrowser(){
       // driver.quit();
  //  }
}
