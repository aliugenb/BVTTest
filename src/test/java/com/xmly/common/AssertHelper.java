package com.xmly.common;

import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import static org.testng.internal.EclipseInterface.*;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 6:15 PM
 */

public class AssertHelper extends Assert {

    public static void assertTrue(boolean condition, String message, String errorName) {
        if (!condition) {
            failNotEquals(condition, Boolean.TRUE, message, errorName);
        }
    }

    static private void failNotEquals(Object actual, Object expected, String message, String errorName) {
        fail(format(actual, expected, message), errorName);
    }

    static public void fail(String message, String errorName) {
        SnapshotAndLog.snapshotByAppium(errorName);
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
