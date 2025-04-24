package com.example.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import framework.MobileDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.net.MalformedURLException;

public class Watcher {
    protected static MobileDriver mobileDriver;

    public static MobileDriver getMobileDriver() {
        return mobileDriver;
    }

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        mobileDriver = new MobileDriver();
        mobileDriver.StartAndroidDriver();
    }

    @BeforeEach
    public void beforeEachTest(TestInfo testInfo) {
        String testName = testInfo.getDisplayName();
        getMobileDriver().setTestName(testName);
    }


    @AfterAll
    public static void tearDown() {
        getMobileDriver().TearDown();
    }

}
