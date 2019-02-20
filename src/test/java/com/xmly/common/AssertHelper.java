package com.xmly.common;

import com.xmly.utils.SnapshotAndLog;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileNotFoundException;

import static org.testng.internal.EclipseInterface.*;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 6:15 PM
 */

public class AssertHelper extends Assert {

    public static void assertTrue(boolean condition, String message, String errorMessage) {
        if (!condition) {
            failNotEquals(condition, Boolean.TRUE, message, errorMessage);
        } else {
            SnapshotAndLog.snapshotByAppium(message);
        }
    }

    static private void failNotEquals(Object actual, Object expected, String message, String errorMessage) {
        fail(format(actual, expected, message), errorMessage);
    }

    static public void fail(String message, String errorMessage) {
        SnapshotAndLog.snapshotByAppium(errorMessage);
        try {
            SnapshotAndLog.logByAppium(errorMessage);
            Reporter.log(errorMessage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
