package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait _wait;
    private final String url = "http://hub.browserstack.com/wd/hub";

    public AppiumDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return _wait;
    }
    public void StartAndroidDriver() throws MalformedURLException {
        try {
        URL url = new URL(this.url);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.user", "janecrafty_7NRt2Q");
        caps.setCapability("browserstack.key", "vKR2Scfk1x2uPq1wg3zo");
        caps.setCapability("app", "bs://c577406751699b491ed2933513b4fad19fcc812b");
        caps.setCapability("device", "Google Pixel 7");
        caps.setCapability("os_version", "13.0");
        caps.setCapability("project", "Demo Android App");
        caps.setCapability("build", "Build 1");
        caps.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver<>(url, caps);

        System.out.println("✅ Appium session started");
    } catch (Exception e) {
        System.err.println("❌ Error in StartAndroidDriver: " + e.getMessage());
        e.printStackTrace();
    }
    }

    public void setTestName(String name) {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\": \"" + name + "\" }}");
        }
    }

    public String getCurrentActivity() {
        if (driver instanceof AndroidDriver) {
            return ((AndroidDriver<?>) driver).currentActivity();
        }
        throw new UnsupportedOperationException("Current activity is only supported for AndroidDriver.");
    }

    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
        }

    public String getSessionId() {
        return driver.getSessionId().toString();
    }
}
