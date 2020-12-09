package cucumber.tests;

import basetest.BaseSetup;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = { "\\demoMavenProject\\src\\test\\java\\cucumber\\features\\" },
        glue = { "cucumber.steps" })
public class Runner extends BaseSetup {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        initialization("4723", "1");
        //initialization("5000", "2");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
