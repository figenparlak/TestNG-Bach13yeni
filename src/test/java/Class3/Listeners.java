package Class3;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override

    // metodun ismini kaynak koddan gopyaladim  ctrl +shift+i yada buyuk I
    // yada ctrl+b ile
    public void onTestSuccess(ITestResult result) {
        System.out.println("the test case has pased successfuly : " + result.getName());

    }

    //testin basarisiz olmasi durumunda bunu basar yoksa yukaridakini
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("the test case has failed successfuly : " + result.getName());
    }


}
