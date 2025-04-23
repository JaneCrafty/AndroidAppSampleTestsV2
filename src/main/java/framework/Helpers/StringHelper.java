package framework.Helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class StringHelper {

    public static String GetRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + System.currentTimeMillis() + "@mail.com";
    }

    public static String GetRandomPassword() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
