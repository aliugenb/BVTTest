package com.xmly.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/3
 * Time: 5:50 PM
 */

public class DirInit {
    public static File classpathRoot = new File(System.getProperty("user.dir"));
    public File resultDir = new File(classpathRoot, "result");
    private File timeDir;
    private File logDir;
    private File screenshotDir;
    private String testNGIReportPath;

    public File getLogDir() {
        return logDir;
    }

    public String getTestNGIReportPath() {
        return testNGIReportPath;
    }

    public File getScreenshotDir() {
        return screenshotDir;
    }

    public DirInit() {
        String timeNow = formatDate();
        timeDir = new File(resultDir, timeNow);
        logDir = new File(timeDir, "log");
        screenshotDir = new File(timeDir, "result");
        testNGIReportPath = timeNow + "/testngreport/" + timeNow + ".html";
        new File(resultDir,testNGIReportPath);
    }

    private static String formatDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(now);
    }
}
