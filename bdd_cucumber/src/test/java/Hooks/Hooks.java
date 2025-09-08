package Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Extent.Extent;
import io.cucumber.java.*;
import utils.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private static ExtentReports extent;
    public static final ThreadLocal<ExtentTest> feature = new ThreadLocal<>();
    public static final ThreadLocal<ExtentTest> scenarioNode = new ThreadLocal<>();

    @BeforeAll
    public static void beforeAll() {
        extent = Extent.getInstance();
    }

    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        // Create Extent hierarchy: Feature -> Scenario
        String featureName = scenario.getUri().toString();
        ExtentTest feat = extent.createTest(featureName.substring(featureName.lastIndexOf('/') + 1));
        feature.set(feat);
        scenarioNode.set(feat.createNode(scenario.getName()));
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] shot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", "FailedStep");
            scenarioNode.get().fail("Step failed; screenshot attached.");
        } else {
            scenarioNode.get().pass("Step passed");
        }
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }
}