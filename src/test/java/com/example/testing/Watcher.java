package com.example.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import framework.MobileDriver;
import java.net.MalformedURLException;

public class Watcher {
    protected static MobileDriver mobileDriver;

    public static MobileDriver getMobileDriver() {
        return mobileDriver;
    }

    @BeforeAll
    public static void setUp() throws MalformedURLException {
      getMobileDriver().StartAndroidDriver();
    }

    @AfterAll
    public static void tearDown() {
        getMobileDriver().TearDown();
    }

}
