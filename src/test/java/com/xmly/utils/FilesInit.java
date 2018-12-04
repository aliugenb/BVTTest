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

public class FilesInit {
    public static File classpathRoot = new File(System.getProperty("user.dir"));
    private String logDirPath;
    private String screenshotDirPath;
    private String testNGReportPath;
    private String preTestNGReportPath;
    private String tarTestNGReportPath;

    public static final String testNGReportFile = "testNGReport.html";


    public String getLogDirPath() {
        return logDirPath;
    }

    public String getScreenshotDirPath() {
        return screenshotDirPath;
    }

    public String getPreTestNGReportPath() {
        return preTestNGReportPath;
    }

    public String getTestNGReportPath() {
        return testNGReportPath;
    }

    public String getTarTestNGReportPath() {
        return tarTestNGReportPath;
    }

    public FilesInit() {
        File resultDir = new File(classpathRoot, "result");
        String timeNow = formatDate();
        String resultPath = resultDir.getAbsolutePath();
        this.logDirPath = resultPath + "/" + timeNow + "/log";
        this.screenshotDirPath = resultPath + "/" + timeNow + "/screenshot";
        this.testNGReportPath = resultPath + "/" + timeNow + "/testNGReport";
        this.preTestNGReportPath = resultPath + "/" + testNGReportFile;
        this.tarTestNGReportPath = testNGReportPath + "/" + testNGReportFile;
    }

    private static String formatDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(now);
    }
}
