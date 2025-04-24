package com.example.testing;

import org.junit.jupiter.api.*;
import framework.MobileDriver;

import java.net.MalformedURLException;

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
    public void tearDown() {
        getMobileDriver().TearDown();
    }

}
