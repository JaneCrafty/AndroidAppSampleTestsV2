package framework.Helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestStatusesHelper {
    public static void markTestStatus(AppiumDriver driver, boolean status, String reason) {
        if (driver == null) return;

        try {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""
                    + (status ? "passed" : "failed") + "\", \"reason\": \"" + reason + "\"}}"
            );
            System.out.println("✅ Marked test status in BrowserStack: " + (status ? "passed" : "failed"));
        } catch (Exception e) {
            System.err.println("❌ Failed to mark test status in BrowserStack: " + e.getMessage());
        }
    }
}
