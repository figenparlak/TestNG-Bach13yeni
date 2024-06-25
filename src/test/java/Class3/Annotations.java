package Class3;

import org.testng.annotations.*;

public class Annotations {

    @BeforeSuite
       public void beforeSuit() {
        System.out.println("I am beforeSuit");
    }

    @AfterSuite
       public void afterSuit() {
           System.out.println("I am after suit");
        }

    @BeforeTest
       public  void beforeTest(){
            System.out.println("I am beforeTest");
     }
    @BeforeClass

    public void beforeClass() {

        System.out.println("I am beforeclass");

    }

    @Test
    public void Atest() {
        System.out.println("I am Atest");

    }

    @Test
       public void Btest() {
            System.out.println("I am Btest");
       }

    @AfterClass
    public void afterClass() {
        System.out.println(("I am afterClass"));
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTest");
    }


}



