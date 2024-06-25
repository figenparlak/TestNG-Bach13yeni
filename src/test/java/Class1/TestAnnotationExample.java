package Class1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotationExample {
    //go to fcebook
    //enter password
    //enter user invalid name
    // make sure the error is there

  public static  WebDriver driver ;
    @Test
    public void  testingForInvalidCredantial() {



//entring the password and the user name then clicking on login
        driver.findElement(By.id("email")).sendKeys("syntax@adfasdfasf.com");
        driver.findElement(By.id("pass")).sendKeys("......");
        //driver.findElement(By.name("login")).click();

        String text = driver.findElement(By.xpath("//h2")).getText();

        if (text.equals("Facebook helps you connect and share with the people in your life.")) {
            System.out.println("succesfull");
        } else {
            System.out.println("fail");
        }

    }

@Test
    public void createAccountText(){


        String text=driver.findElement(By.xpath("//a[text()='Create new account']")).getText();
        if (text.equals("Create new account")){
            System.out.println("succesfull");
        }else{
            System.out.println("failed");
        }

    }

   @BeforeMethod
    public void beforeTest(){
       //setting up the wevdriver
       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       //getting the particular url
       driver.get("https://www.fb.com");
   }

   @AfterMethod
    public  void quitingMethod(){
       driver.quit();
   }
}


