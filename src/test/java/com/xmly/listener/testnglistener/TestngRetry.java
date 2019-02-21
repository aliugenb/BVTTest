package com.xmly.listener.testnglistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/8
 * Time: 下午4:51
 */

public class TestngRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;

            return true;
        }
        resetRetrycount();
        return false;
    }

    private String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }

    public boolean isRetryAvailable() {
        return retryCount < maxRetryCount;
    }

    private void resetRetrycount() {
        retryCount = 0;
    }
}
