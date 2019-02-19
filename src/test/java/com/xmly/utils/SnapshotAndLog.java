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
            String screenshotPath = resultPath + File.separator + filename + ".png";
            System.out.println("save snapshot path is:" + resultPath + "/"
                    + filename);
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            Reporter.log("<img src=\"../" + screenshotPath + "\"/>");
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
        CommonUtil.execCmd(screenshotCmd);
        CommonUtil.sleep(3);
        System.out.println(pullCmd);
        CommonUtil.execCmd(pullCmd);
    }

    public static void logByAdb(String name) throws IOException {
        String path = resultPath + "/" + name + ".txt";
        String logCmd = "adb logcat -d -v time > " + path;
        System.out.println(logCmd);
        CommonUtil.execCmd(logCmd);
    }

    public static void clearAndroidLog() throws IOException {
        String clearCmd = "adb logcat -c";
        CommonUtil.execCmd(clearCmd);
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
