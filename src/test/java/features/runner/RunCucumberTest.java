package features.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/testFeatures/*.feature",
        glue = "stepdefinitions",
        dryRun = true,
        //format = {"pretty", "html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
    public static void main(String[] args) {
        io.cucumber.core.cli.Main.run(args, Thread.currentThread().getContextClassLoader());
    }
}
