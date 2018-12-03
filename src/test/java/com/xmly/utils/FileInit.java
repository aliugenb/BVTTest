package com.xmly.utils;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/3
 * Time: 5:50 PM
 */

public class FileInit {

    public static File classpathRoot = new File(System.getProperty("user.dir"));
    public static File resultDir = new File(classpathRoot, "result");
    private File logDir;
    private File screenshotDir;
    private File testNGIReportDir;

    public static final String testNGIReportFile = "testngReport.html";

    public File getLogDir() {
        return logDir.getAbsoluteFile();
    }

    public File getTestNGIReportDir() {
        return testNGIReportDir;
    }

    public File getScreenshotDir() {
        return screenshotDir;
    }

    public FileInit() {
        String timeNow = formatDate();
        File timeDir = new File(resultDir, timeNow);
        logDir = new File(timeDir, "log");
        screenshotDir = new File(timeDir, "screenShot");
        testNGIReportDir = new File(timeDir, "testngReport");
    }

    private static String formatDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(now);
    }
}
