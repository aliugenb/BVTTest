package com.xmly.listener.testnglistener;

import com.xmly.common.MyException;
import com.xmly.driver.BaseDriver;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.xmly.utils.FilesInit.resultPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/8
 * Time: 下午4:52
 */

public class TestngListener extends TestListenerAdapter {
    private static Logger logger = LogManager.getLogger(ITestListener.class);

    @Override
    public void onFinish(ITestContext testContext) {
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
            logger.info("PassedTests = " + passedTest.getName());
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
            logger.info("failedTest = " + failedTest.getName());
            // id = class + method + dataprovider
            int failedTestId = getId(failedTest);

            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        for (Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator(); iterator
                .hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                logger.info("Remove repeat Fail Test: " + testResult.getName());
                iterator.remove();
            }
        }

    }

    private int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = id + result.getMethod().getMethodName().hashCode();
        id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }

    public void onTestStart(ITestResult result) {
        //安卓设备开始测试前清空log
        try {
            if (AdbUtil.isConnect()) {
                AdbUtil.clearAndroidLog();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("Test start");
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.log("测试成功");
    }

    public void onTestFailure(ITestResult result) {
        Reporter.log("测试失败");
        SnapshotAndLog.snapshotByAppium("Exception_" + result.getMethod().getMethodName() + "_Failed");
        SnapshotAndLog.logByAppium("Exception_" + result.getMethod().getMethodName() + "_Failed");
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    private void captureScreenShot(ITestResult result) throws MyException {
        AppiumDriver driver = BaseDriver.getDriver();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String screenShotName = result.getMethod().getMethodName() + "-" + dateFormat.format(now) + ".png";
        String screenShotPath = resultPath + File.separator + screenShotName;
        ;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenShotPath));
            Reporter.log(screenShotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}