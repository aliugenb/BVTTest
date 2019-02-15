package com.xmly.utils;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 17:57
 */


import com.xmly.common.MyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * adb 控制类
 */
public class AdbUtil {

    public static void tapByCoordinates(int x, int y) {
        CommonUtil.execCmd("adb shell input tap " + x + " " + y);
    }

    //点击系统按钮
    public static void pressKey(KEY keyCode) {
        if (keyCode.equals(KEY.BACK)) {
            //点击返回键
            CommonUtil.execCmd("adb shell input keyevent 4");
        } else if (keyCode.equals(KEY.ENTER)) {
            //点击ENTER键
            CommonUtil.execCmd("adb shell input keyevent 66");
        } else if (keyCode.equals(KEY.HOME)) {
            //点击HOME键
            CommonUtil.execCmd("adb shell input keyevent 3");
        }
    }

    /*
     *获取当前最顶层页面的activity
     */
    public static String getFocusedActivity() throws IOException {
        String command = "adb shell \"dumpsys activity | grep \"mFocusedActivity\"\"";
        if (System.getProperty("os.name").equals("Mac OS X")) {
            command = "adb shell dumpsys activity | grep \"mFocusedActivity\"";
        }
        String focusedActivity = null;
        focusedActivity = CommonUtil.execCmd(command);
        return focusedActivity;
    }

    //获取非appium的输入法
    public static String getInputMethod() throws IOException, MyException {
        String inputMethod = null;
        String appiumInputMethod = "io.appium.settings/.UnicodeIME";
        List<String> inputMethods = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("adb shell ime list -s");
        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                inputMethods.add(line.toString().trim());
            }

            if (inputMethods.size() == 1 && inputMethods.indexOf(appiumInputMethod) == 0) {
                throw new MyException("请安装其他三方输入法");
            } else {
                if (inputMethods.indexOf(appiumInputMethod) > 0) {
                    inputMethod = inputMethods.get(0);
                } else if (inputMethods.indexOf(appiumInputMethod) == 0) {
                    inputMethod = inputMethods.get(1);
                } else {
                    throw new MyException("没有安装appium输入法");
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            try {
                proc.destroy();
            } catch (Exception e1) {
                System.err.print(e1);
            }
        }
        return inputMethod;
    }
}
