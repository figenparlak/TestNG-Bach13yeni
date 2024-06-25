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

public class DataProviders {
    //    Test Scenario:
    // navigat synts hrms
    //logininto website using the following credential
    // username= admin password = 12345  error massage ="Invalid Credential"
    //    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

    WebDriver driver;
    @BeforeMethod
    public  void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @DataProvider(name="Credentials")


    public Object[][] data() {
        //burada obje olusturduk.2D arrayi niye boyle yazduk bilmiyorum
 Object [][] login={
                { "Admin","12345","Invalid credential"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}};
        return login;
    }


    // asagidaki dataprovider adi ile ustteki ayni olmali.
    // boylese yukardaki 3 farkli testi ayri ayri yeniden yazacagima veriyoruz datadriver ile bilgileri bir kere yaziyoruz
    @Test(dataProvider = "Credentials")

    // metoda bu uc parametreyi verdik cunku yukadaki 2 d arrain her satirinda 3 parametre var
    //boylece tek test case altinda 4 test yaptik
    public void loginWithVariousCredentials(String usrname , String password ,String expectedError) throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send username
        username.sendKeys(usrname);
        //        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys(password);
//        finding the element  login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();
        Thread.sleep(2000);
//        get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        String actualError = errorMsg.getText();
        System.out.println(actualError);
        //decalre the soft Assertion
        SoftAssert soft =new SoftAssert();
//    asseert that the error is correct
        soft.assertEquals(actualError,expectedError);
//    assert all
        soft.assertAll();

    }

    @AfterMethod(alwaysRun =false)
    public  void  CloseBrowser(){
        driver.quit();
    }
}
