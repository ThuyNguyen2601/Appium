import def.Hook;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        tags = "@tc1",
        plugin = { "json:target/cucumber.json"},
        glue = {"def"},
        dryRun = false


)
public class TestRunner extends Hook {


}
