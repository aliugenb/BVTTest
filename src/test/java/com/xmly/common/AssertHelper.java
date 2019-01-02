package com.xmly.common;

import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import static org.testng.internal.EclipseInterface.ASSERT_LEFT;
import static org.testng.internal.EclipseInterface.ASSERT_MIDDLE;
import static org.testng.internal.EclipseInterface.ASSERT_RIGHT;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 6:15 PM
 */

public class AssertHelper extends Assert {

    public static void assertTrue(boolean condition, String message, AppiumDriver driver, String fileName) {
        if (!condition) {
            failNotEquals(condition, Boolean.TRUE, message, driver, fileName);
        }
    }

    static private void failNotEquals(Object actual, Object expected, String message, AppiumDriver driver, String fileName) {
        fail(format(actual, expected, message), driver, fileName);
    }

    static public void fail(String message, AppiumDriver driver, String fileName) {
        SnapshotAndLog.snapshotByAppium(driver, fileName);
        throw new AssertionError(message);
    }

    static String format(Object actual, Object expected, String message) {
        String formatted = "";
        if (null != message) {
            formatted = message + " ";
        }

        return formatted + ASSERT_LEFT + expected + ASSERT_MIDDLE + actual + ASSERT_RIGHT;
    }
}
