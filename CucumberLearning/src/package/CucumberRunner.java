//create a runner class to execute your feature file


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.awt.*;

@RunWith(Cucumber.class)  //this class we will get from cucumber.api.junit package and annotation to run the class before our actual class
@CucumberOptions(
    features = "Feature/login_1.feature",
        glue = "Tests"


)

//specific the setting of test engine "cucumber option"
public class CucumberRunner {


}
