package browserstack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumHelper {
    public static final String USERNAME = "kiarashedraki1";
    public static final String AUTOMATE_KEY = "xLsBe2xdtQDYTSzqkAhB";
    public static final String URLTest = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private static final String build = System.getenv("sbBuild") != null ? System.getenv("sbBuild") : "local-build";

    public static WebDriver getDesiredWebdriver(String browser, String browserVersion, String os, String osVersion, String resolution) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", os);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("resolution", resolution);
        caps.setCapability("name", browser + "-" + browserVersion + "-" + os);
        caps.setCapability("build", build);

        return new RemoteWebDriver(new URL(URLTest), caps);
    }
}

