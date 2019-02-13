package com.xmly.utils;

import com.xmly.common.ActionHelper;
import com.xmly.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;

import static com.xmly.utils.FilesInit.resultPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/4
 * Time: 4:01 PM
 */
public class SnapshotAndLog {

    static AppiumDriver driver = BaseDriver.getDriver();

    public static void snapshotByAppium(String filename) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("save snapshot path is:" + resultPath + "/"
                    + filename);
            FileUtils.copyFile(scrFile, new File(resultPath + "/" + filename + ".png"));
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out.println("screen shot finished, it's in " + resultPath
                    + " folder");
        }
    }

    public static void snapshotByAdb(String fileName) throws IOException, InterruptedException {
        String savePath = resultPath + "/" + fileName + ".png";
        String screenshotCmd = "adb shell /system/bin/screencap -p /sdcard/screenshot.png";
        String pullCmd = "adb pull /sdcard/screenshot.png " + savePath;
        ActionHelper.execCmd(screenshotCmd);
        ActionHelper.sleep(3000);
        System.out.println(pullCmd);
        ActionHelper.execCmd(pullCmd);
    }

    public static void logByAdb(String name) throws IOException {
        String path = resultPath + "/" + name + ".txt";
        String logCmd = "adb logcat -d -v time > " + path;
        System.out.println(logCmd);
        ActionHelper.execCmd(logCmd);
    }

    public static void logByAppium(String fileName) throws FileNotFoundException {
//        LogEntries logEntries = driver.manage().logs().get("driver");
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
        File logFile = new File(resultPath + File.separator + fileName + ".txt");
        logFile.getParentFile().mkdirs();

        PrintWriter log_file_writer = new PrintWriter(logFile);
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getMessage().contains("ximalaya")) {
                log_file_writer.println(logEntry);
            }
        }
        log_file_writer.flush();
    }
}
