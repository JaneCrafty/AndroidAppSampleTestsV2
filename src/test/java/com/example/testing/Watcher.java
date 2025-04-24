package com.example.testing;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.*;
import framework.MobileDriver;

import static framework.Helpers.TestStatusesHelper.markTestStatus;

import java.net.MalformedURLException;

public class Watcher implements BeforeEachCallback, AfterEachCallback, TestWatcher {

    protected static MobileDriver mobileDriver;

    public static MobileDriver getMobileDriver() {
        return mobileDriver;
    }

    @Override
    public void beforeEach(ExtensionContext context) throws MalformedURLException {
        mobileDriver = new MobileDriver();
        mobileDriver.setTestName(context.getDisplayName());
        mobileDriver.StartAndroidDriver();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        mobileDriver.TearDown();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        markTestStatus(getMobileDriver().getDriver(), true, "Test passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        markTestStatus(getMobileDriver().getDriver(), false, "Test failed: " + cause.getMessage());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        markTestStatus(getMobileDriver().getDriver(), false, "Test aborted: " + cause.getMessage());
    }
}
