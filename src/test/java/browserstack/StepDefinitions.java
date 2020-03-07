package browserstack;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class StepDefinitions implements En {
    private WebDriver webDriver = null;

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

        When("open google.com", () -> {
            // Write code here that turns the phrase above into concrete actions
            webDriver.get("http://www.google.com");
        });


        After((Scenario scenario) -> {
            webDriver.quit();
        });


    }
}
