package com.xmly.common;

import com.xmly.utils.SnapshotAndLog;
import org.testng.Assert;
import org.testng.Reporter;

import static org.testng.internal.EclipseInterface.*;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 6:15 PM
 */

public class AssertHelper extends Assert {

    public static void assertTrue(boolean condition, String message) {
        String successMessage = "assert_" + message + "_success";
        String failMessage = "assert_" + message + "_fail";

        if (!condition) {
            Reporter.log(failMessage, true);
//            SnapshotAndLog.snapshotByAppium(failMessage);
//            SnapshotAndLog.logByAppium(failMessage);
            failNotEquals(condition, Boolean.TRUE, message);
        } else {
            Reporter.log(successMessage, true);
            SnapshotAndLog.snapshotByAppium(successMessage);
        }
    }

    static private void failNotEquals(Object actual, Object expected, String message) {
        fail(format(actual, expected, message));
    }

    static String format(Object actual, Object expected, String message) {
        String formatted = "";
        if (null != message) {
            formatted = message + " ";
        }

        return formatted + ASSERT_LEFT + expected + ASSERT_MIDDLE + actual + ASSERT_RIGHT;
    }
}
