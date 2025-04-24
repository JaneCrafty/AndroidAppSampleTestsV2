package com.example.testing;

import org.junit.jupiter.api.*;
import framework.MobileDriver;

import java.net.MalformedURLException;

import static framework.Helpers.TestStatusesHelper.markTestStatus;

public class Watcher {
    protected static MobileDriver mobileDriver;

    public static MobileDriver getMobileDriver() {
        return mobileDriver;
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) throws MalformedURLException {
        mobileDriver = new MobileDriver();
        mobileDriver.setTestName(testInfo.getDisplayName());
        mobileDriver.StartAndroidDriver();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        boolean passed = testInfo.getTags().contains("passed"); // или анализ по-другому
        String reason = passed ? "Test passed" : "Test failed or error occurred";
        markTestStatus(getMobileDriver().getDriver(), passed, reason);
        getMobileDriver().TearDown();
    }

}
