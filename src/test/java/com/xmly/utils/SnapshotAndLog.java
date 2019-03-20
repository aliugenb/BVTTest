package com.xmly.utils;

import com.xmly.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;

import static com.xmly.utils.CommonUtil.execCmd;
import static com.xmly.utils.CommonUtil.sleep;
import static com.xmly.utils.FilesInit.resultPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/4
 * Time: 4:01 PM
 */

public class SnapshotAndLog {

    public static void snapshotByAppium(String fileName) {
        AppiumDriver driver = BaseDriver.getDriver();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String actFileName = fileName + ".png";
            String screenshotPath = resultPath + File.separator + actFileName;
            System.out.println("save snapshot path is:" + screenshotPath);
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            Reporter.log(timescreenshotPath);
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out.println("screen shot finished, it's in " + resultPath
                    + " folder");
        }
    }

    public static void snapshotByAdb(String fileName) {
        String savePath = resultPath + File.separator + fileName + ".png";
        String screenshotCmd = "adb shell /system/bin/screencap -p /sdcard/screenshot.png";
        String pullCmd = "adb pull /sdcard/screenshot.png " + savePath;
        execCmd(screenshotCmd);
        sleep(3);
        System.out.println(pullCmd);
        execCmd(pullCmd);
    }

    public static void logByAdb(String name) throws IOException {
        String path = resultPath + File.separator + name + ".txt";
        String logCmd = "adb logcat -d -v time > " + path;
        System.out.println(logCmd);
        execCmd(logCmd);
    }

    public static void logByAppium(String fileName) {
        AppiumDriver driver = BaseDriver.getDriver();
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
        File logFile = new File(resultPath + File.separator + fileName + ".txt");
        logFile.getParentFile().mkdirs();

        PrintWriter logFileWriter = null;
        try {
            logFileWriter = new PrintWriter(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getMessage().contains("ximalaya")) {
                logFileWriter.println(logEntry);
            }
        }
        logFileWriter.flush();
    }
}
