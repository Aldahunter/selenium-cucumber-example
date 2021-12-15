
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/" },
				tags = "@selenium and not @unit")
public class CucumberSeleniumTestRunner {

}
