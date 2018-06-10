package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue="stepDefinitions",
        strict = false,
        dryRun = false,
        tags = "~@ignore"
)
public class TestRunner {

}
