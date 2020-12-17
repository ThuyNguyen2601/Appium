package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
features = "src/test/java/Features",
glue= {"Steps"},
dryRun = true
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
