package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/java/featureFiles/HappyFlow.feature",
	glue= {"stepDefinitions","hooks"},
	plugin= {"pretty","html:target/cucumber-reoprts.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
