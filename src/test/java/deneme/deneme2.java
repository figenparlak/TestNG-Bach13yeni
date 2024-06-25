package deneme;

import org.testng.annotations.*;

public class deneme2 extends deneme1{
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("I am beforeSuit1");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("I am after suit1");
    }

    @BeforeTest
    public  void beforeTest(){
        System.out.println("I am beforeTest1");
    }
    @BeforeClass

    public void beforeClass() {

        System.out.println("I am beforeclass1");

    }

    @Test
    public void Atest() {
        System.out.println("I am Atest1");

    }

    @Test
    public void Btest() {
        System.out.println("I am Btest1");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(("I am afterClass1"));
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTest1");
    }


}
