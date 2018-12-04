package com.xmly.utils;

import com.xmly.action.ActionHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/4
 * Time: 4:01 PM
 */
public class snapshotAndLog {
    static String currentPath = System.getProperty("user.dir");

    public static void snapshotByAppium(TakesScreenshot drivername, String filename) {
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("save snapshot path is:" + currentPath + "/"
                    + filename);
            FileUtils.copyFile(scrFile, new File(currentPath + "/" + filename + ".png"));
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out.println("screen shot finished, it's in " + currentPath
                    + " folder");
        }
    }

    public static void snapshotByAdb(Path path, String fileName) throws IOException, InterruptedException {
        String savePath = path + "/" + fileName + ".png";
        String screenshotCmd = "adb shell /system/bin/screencap -p /sdcard/screenshot.png";
        String pullCmd = "adb pull /sdcard/screenshot.png " + savePath;
        ActionHelper.execCmd(screenshotCmd);
        ActionHelper.sleep(3000);
        System.out.println(pullCmd);
        ActionHelper.execCmd(pullCmd);
    }
}
