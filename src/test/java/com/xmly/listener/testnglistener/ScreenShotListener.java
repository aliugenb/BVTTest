package com.xmly.listener.testnglistener;

import com.xmly.common.MyException;
import com.xmly.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.ReporterConfig;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.xmly.utils.FilesInit.resultPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 11:35 AM
 */
public class ScreenShotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        try {
            captureScreenShot(result);
        } catch (MyException e) {
            e.printStackTrace();
        }
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
