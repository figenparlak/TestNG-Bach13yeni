package Class2;

import org.testng.annotations.Test;

public class enabledDiabled {
     @Test(enabled =false)

    public void firstTest(){
        System.out.println("hello!! 1st test");

    }
    @Test

    public void secondtTest(){
        System.out.println("hello!! 2nd test");

    }
     @Test(groups="Smoke")
    public void thirdtTest(){
         System.out.println("hello!! 3th test");

    }
}
