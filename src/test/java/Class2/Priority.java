package Class2;

import org.testng.annotations.Test;

public class Priority {


    // normalde test caseler isimlerinin alfabetik sirasina gore yazilir
    //fakat priority ile istedigin sirada basabilirsin
    @Test(groups = "Smoke")

    public void firstTest() {
        System.out.println("hello!! 1st test");

    }

    @Test(priority = 4)

    public void secondtTest() {
        System.out.println("hello!! 2nd test");

    }

    @Test(priority = 1)
    public void thirdtTest() {
        System.out.println("hello!! 3th test");

    }

    @Test(priority = 1)
    public void forthTest() {
        System.out.println("hello!! 4th test");
    }
}
