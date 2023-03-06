package step_definitions;

import utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;


public class Hooks {

    //@Before
    public void setUp() {
        System.out.println("SET UP BEFORE EACH SCENARIO");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "png/image", scenario.getName());
        }

        /* no condition - take screenshot after each scenario, fails or passes
        byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(data, "png/image", scenario.getName());
         */

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
