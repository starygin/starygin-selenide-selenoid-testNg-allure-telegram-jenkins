package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import suites.sanityTest.sanityTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomISuiteListener implements ISuiteListener {

    public static List<String> skippedTest = new ArrayList();

    @Override
    public void onStart(ISuite iSuite) {
        if (LocalDate.now().getDayOfYear() % 2 == 1) {
            skippedTest.add(sanityTest.class.getSimpleName());
        }
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}
