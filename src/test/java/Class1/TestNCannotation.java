package Class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNCannotation {
    // Class A Class B
    //@beforemethod @beformethod
    //@aftermethod @aftermethod
    //@beforclass @beforeclass
    //@afterclass @afterclass
    //@beforetest @beforetest
    //@aftertest @aftertest
    @Test
    public void firstTestCase(){

        System.out.println("Heeey! Iam a first test case");
    }

    @Test(groups="Smoke")
    public void secondTestCases(){

        System.out.println("Iam second test case");
    }
    @Test
    public void thirdTestCase(){

        System.out.println("I am third test case");
    }
    @BeforeMethod
    public void beforeMetod(){
        System.out.println("heyyy I AM BEFORE METHOD");

    }
    @AfterMethod
    public void afterMthod(){
        System.out.println("heyy I AM after  method");
    }




}
