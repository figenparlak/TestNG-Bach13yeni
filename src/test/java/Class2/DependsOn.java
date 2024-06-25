package Class2;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DependsOn {

//bunu class 3 te annotation clasini yaptiktan sonra yazdik.
// @BeforeSuit kodlarini yani .
// xml dosyasini calistirinca ciktida en ustte iki tana i ambeforesuit yazisi cikti
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("I am beforeSuit");
    }
    @Test
    public  void login(){
        System.out.println(" i have login succesfuly");
        // make the test fail
      //  System.out.println(0/0);

    }

    //(dependsOnMethods ="login") bunu ustteki test basarisiz olursa skip etmek icin yazdik.
    // alttaki ciktidada 1 test skip yazacak

    @Test(dependsOnMethods ="login")

    public  void verificationOfDashboardPage(){
        System.out.println("I am on dashboard page");

    }
}
