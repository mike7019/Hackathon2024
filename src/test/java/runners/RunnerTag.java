package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = "com.co.hackathon.stepdefinitions",
        tags = "@RegisterUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTag {

}
