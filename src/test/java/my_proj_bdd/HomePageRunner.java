package my_proj_bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/tests/homePage.feature"},
        plugin = {"pretty", "json:target/report.json", "html:target/cucumber-reports"}
)
public class HomePageRunner {
}
