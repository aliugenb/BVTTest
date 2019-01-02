package com.xmly.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:12 PM
 */


public class ActionHelper {

    // 检查当前页面最上层的activity是否在指定packageName
    public static boolean checkPackage(String packageName) throws IOException {
        String command = "adb shell \"dumpsys activity | grep \"mFocusedActivity\"\"";
        if (System.getProperty("os.name").equals("Mac OS X")) {
            command = "adb shell dumpsys activity | grep \"mFocusedActivity\"";
        }
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command);
        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line + " ");
            }
            String str = stringBuffer.toString().trim();
            if (str.indexOf("packageName") != -1) {
                return true;
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            try {
                proc.destroy();
            } catch (Exception e1) {
                System.err.print(e1);
                throw e1;
            }
        }
        return false;
    }

    //分钟转换成毫秒
    public static int formatMin(int i) {
        int timeLong = 0;
        if (i > 0) {
            timeLong = i * 60 * 1000;
        } else {
            System.out.println("输入错误");
        }
        return timeLong;
    }

    //获取非appium的输入法
    public static String getInputMethod() throws IOException, MyException {
        String inputMethod = null;
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

            if (inputMethods.size() == 1 && inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") == 0) {
                throw new MyException("请安装其他三方输入法");
            } else {
                if (inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") > 0) {
                    inputMethod = inputMethods.get(0);
                } else if (inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") == 0) {
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

    //执行cmd
    public static void execCmd(String cmd) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(cmd);

        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            proc.destroy();
        }
    }

    //休眠时长
    public static void sleep(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}
