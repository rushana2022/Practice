package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver() {
    }


    /*
    we make the WebDriver private, because we want to restrict access for the object from outside of the class
     we make it static, bc we'll use it in a static method
     */
    //private static WebDriver driver;  // single run, default value == null
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>(); // parallel run
    // we want to open (InheritableThreadLocal) more of WebDriver


    /*
    create a reusable utility method which will return the same driver instance once we call it
    - if an instance doesn't exist, it will create first, and then it'll always return same instance
     */

    public static WebDriver getDriver() {

        //if (driver == null) {  // single run
        if (driverPool.get() == null) { // parallel run

            /*
            we'll read our browserType from configuration.properties file,
            this way we can control which browser is opened from outside our code
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on browserType return form the configuration.properties
            switch statement will determine the "case", and open the matching browser
             */
            switch (browserType) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    //driver = new ChromeDriver(); // setting our driver - single run
                    driverPool.set(new ChromeDriver()); // parallel run
                    //driver.manage().window().maximize();  // single run
                    driverPool.get().manage().window().maximize();  // parallel run
                    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // single run
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // parallel run
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver(); // single run
                    driverPool.set(new FirefoxDriver());  // parallel run
                    // driver.manage().window().maximize();  // single run
                    driverPool.get().manage().window().maximize();  // parallel run
                    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // single run
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // parallel run
                    break;

            }

        }

        return driverPool.get();


    }


    public static void closeDriver() {
        //if (driver != null) {  // single run
        if (driverPool.get() != null) {  // parallel run
            //driver.quit(); // single run, will terminate the currently existing driver completely, it'll not exist anymore
            driverPool.get().quit();  // parallel run
            //driver = null; // single run, we assign the value back to null, so that my "singleton" can create a newer one if needed
            driverPool.remove(); // parallel run
        }
    }

}
