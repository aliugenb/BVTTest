package com.xmly.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    public static String timeNow;

    public static String projectPath;
    public static String resultPath;
    public static String apkPath;

    static {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File resultDir = new File(classpathRoot, "result");
        File appDir = new File(classpathRoot, "apps");
        File apk = new File(appDir, "xmly.apk");

        timeNow = formatDate();

        projectPath = classpathRoot.getAbsolutePath();
        resultPath = resultDir.getAbsolutePath() + File.separator + timeNow;
        apkPath = apk.getAbsolutePath();

    }

    private static String formatDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(now);
    }

    public static void copyFile(String filePath, String dirPath) throws IOException {
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("原始文件不存在");
            return;
        }

        Files.copy(Paths.get(filePath), Paths.get(dirPath));
    }
}
