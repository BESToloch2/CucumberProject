package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "API",
        dryRun = false,
        tags = "@api",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                //to execute failed test cases one more time
                "rerun:target/failed.txt"}

)


public class APIRUnner {
}
