package com.example.testing;

import framework.Helpers.TestStatusesHelper;
import framework.MobileDriver;
import org.junit.jupiter.api.extension.*;

public class Watcher implements BeforeTestExecutionCallback, AfterTestExecutionCallback, Extension {

    private static final InheritableThreadLocal<MobileDriver> driverThreadLocal = new InheritableThreadLocal<>();

    public static MobileDriver getMobileDriver() {
        return driverThreadLocal.get();
    }

    public static void setMobileDriver(MobileDriver driver) {
        driverThreadLocal.set(driver);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("🔹 Starting test: " + context.getDisplayName());
        try {
            MobileDriver mobileDriver = new MobileDriver();
            mobileDriver.setTestName(context.getDisplayName());
            MobileDriver.onDriverStarted = Watcher::setMobileDriver;
            mobileDriver.StartAndroidDriver();
            setMobileDriver(mobileDriver);
        } catch (Exception e) {
            System.err.println("❌ Error starting MobileDriver: " + e.getMessage());
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("🔚 Finishing test: " + context.getDisplayName());

        MobileDriver mobileDriver = getMobileDriver();
        if (mobileDriver != null && mobileDriver.getDriver() != null) {
            boolean testPassed = context.getExecutionException().isEmpty();
            String reason = testPassed ? "Test passed" : context.getExecutionException().get().getMessage();

            try {
                TestStatusesHelper.markTestStatus(mobileDriver.getDriver(), testPassed, reason);
            } catch (Exception e) {
                System.err.println("❌ Failed to mark test status in BrowserStack: " + e.getMessage());
            }

            try {
                mobileDriver.TearDown();
            } catch (Exception e) {
                System.err.println("⚠️ Error during driver teardown: " + e.getMessage());
            }
        } else {
            System.err.println("⚠️ Driver or session was null during teardown");
        }

        driverThreadLocal.remove();
    }
}
