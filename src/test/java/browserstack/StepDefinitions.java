package browserstack;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pom.BrowserStackMainPage;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitions implements En {
    private WebDriver webDriver = null;
    //For this I could build a context but for a small POC like this its an overkill
    BrowserStackMainPage browserStackMainPage;

    public StepDefinitions() {
        Given("We open the following browser", (io.cucumber.datatable.DataTable dataTable) -> {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            // For other transformations you can register a DataTableType.
            Map<String, String> mapCapability = dataTable.asMap(String.class, String.class);
            webDriver = SeleniumHelper.getDesiredWebdriver(
                    mapCapability.get("Browser"),
                    mapCapability.get("BrowserVersion"),
                    mapCapability.get("OS"),
                    mapCapability.get("OSVersion"),
                    mapCapability.get("Resolution"));
        });

        When("open browserstack main page", () -> {
            // Write code here that turns the phrase above into concrete actions
            browserStackMainPage = new BrowserStackMainPage(webDriver);
            String test = browserStackMainPage.getStartedForFree();
        });

        Then("we see the {string} on top right", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            assertTrue(browserStackMainPage.doesFreeTrialExists());
        });

        Then("we see the text {string} in the middle of the screen", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            assertEquals(browserStackMainPage.getStartedForFree(), string);
        });

        Then("the top nav could should be {int}", (Integer int1) -> {
            // Write code here that turns the phrase above into concrete actions
            assertEquals(browserStackMainPage.getMainNavCount(), int1.intValue());
        });

        After((Scenario scenario) -> {
            scenario.write(
                    "you can access the browser stack here : " +
                            "https://automate.browserstack.com/dashboard/v2/sessions/"
                            + ((RemoteWebDriver) webDriver).getSessionId().toString());
            webDriver.quit();


        });


    }
}
