package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"src/test/resource/Feature/Booking.feature"},
    glue = {"StepDefinitions", "Hooks"},
    plugin = {
        "pretty",
        "summary",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml",
        "html:target/cucumber-report.html"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}