package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackMainPage {
    private final static String FREE_TRIAL_XPATH = "//*[@id=\"primary-menu\"]/li[6]/a";
    private final static String GET_STARTED_FREE_ID = "signupModalButton";
    private final static String MAIN_NAV_BAR_XPATH = "//*[@id=\"product-nav\"]/ul/li";
    private WebDriver webDriver;

    public BrowserStackMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get("https://www.browserstack.com");
    }

    public boolean doesFreeTrialExists() {
        return (this.webDriver.findElements(By.xpath(FREE_TRIAL_XPATH)).size() == 1);
    }

    public String getStartedForFree() {
        return this.webDriver.findElement(By.id(GET_STARTED_FREE_ID)).getText();
    }

    public int getMainNavCount() {
        return this.webDriver.findElements(By.xpath(MAIN_NAV_BAR_XPATH)).size();
    }
}
