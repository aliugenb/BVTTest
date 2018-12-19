package com.xmly.utils;

import java.io.File;
import java.io.IOException;
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

public class FilesInit {
    public static File classpathRoot = new File(System.getProperty("user.dir"));
    public static Path logDirPath;
    public static Path screenshotDirPath;
    public static Path testNGReportPath;
    public static Path preTestNGReportPath;
    public static Path tarTestNGReportPath;

    public static final String testNGReportFile = "testNGReport.html";


    public FilesInit() {


    }

    public static void filesInit() throws IOException {
        File resultDir = new File(classpathRoot, "result");
        String timeNow = formatDate();
        String resultPath = resultDir.getAbsolutePath();
        logDirPath = Paths.get(resultPath + "/" + timeNow + "/log");
        screenshotDirPath = Paths.get(resultPath + "/" + timeNow + "/screenshot");
        testNGReportPath = Paths.get(resultPath + "/" + timeNow + "/testNGReport");
        preTestNGReportPath = Paths.get(resultPath + "/" + testNGReportFile);
        tarTestNGReportPath = Paths.get(testNGReportPath + "/" + testNGReportFile);

        try {
            Files.createDirectories(logDirPath);
            Files.createDirectories(screenshotDirPath);
            Files.createDirectories(testNGReportPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Files.deleteIfExists(preTestNGReportPath);
    }

    private static String formatDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(now);
    }
}
