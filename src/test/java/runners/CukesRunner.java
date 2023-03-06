package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "src/test/java/step_definitions",
        dryRun = false,  //when false - it'll open a browser and print snippets, if true - will print snippets only, won't open browser, will be faster
        tags = "",
        publish = true  // generating a report with public link
        // monochrome = true // changes the color of 'pretty' statements
)
public class CukesRunner {
}
