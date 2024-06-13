package my_proj_bdd.driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class ServiceHooks {

    DriverManager startDriver;

    @Before
    public void initializeTest() {
        startDriver = new DriverManager();
        startDriver.startDriver();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                final byte[] screenshot = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                scenario.embed(((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DriverManager.driver.close();
    }
}
