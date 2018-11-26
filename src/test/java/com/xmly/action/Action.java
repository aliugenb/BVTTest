package com.xmly.action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/8
 * Time: 下午4:08
 */

public class Action {

    public static AndroidDriver<AndroidElement> driver;

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

    public static void sleep(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    public List<AndroidElement> getElementsByResourceId(String resourceId) {
        List<AndroidElement> lis = driver.findElementsById(resourceId);
        return lis;
    }

    //获取中心点击坐标
    public static String getCenterCoordinates(AndroidElement androidElement) {
        String coordinates = null;
        int x = androidElement.getCenter().getX();
        int y = androidElement.getCenter().getY();
        coordinates = "" + x + " " + y + "";
        return coordinates;
    }

    public static void pressKey(KEY keyCode) throws IOException {
        if (keyCode.equals(KEY.BACK)) {
            //点击返回键
            execCmd("adb shell input keyevent 4");
        } else if (keyCode.equals(KEY.ENTER)) {
            //点击ENTER键
            execCmd("adb shell input keyevent 66");
        } else if (keyCode.equals(KEY.HOME)) {
            //点击HOME键
            execCmd("adb shell input keyevent 3");
        }
    }

    public static void skipSplash() {
        try {
            if (driver.findElementById("com.ximalaya.ting.android:id/host_ad_img").isDisplayed()) {
                driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"跳过\")").click();
                System.out.println("跳过splash");
            }
        } catch (Exception e) {
            System.out.println("无splash");
        }
    }

    //根据设定时长滑动页面
    public static void swipUpAndDownByTime(int time) throws InterruptedException, IOException, MyException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        long s = (new Date()).getTime();
        while ((new Date()).getTime() - s < formatMin(time)) {
//            checkInFanli();
            for (int i1 = 0; i1 <= 8; i1++) {
                TouchAction action = new TouchAction(driver).press(width / 2, height * 5 / 7).waitAction().moveTo(width / 2, height * 2 / 7).release();
                action.perform();
                Thread.sleep(1000);
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                TouchAction action1 = new TouchAction(driver).press(width / 2, height * 2 / 7).waitAction().moveTo(width / 2, height * 5 / 7).release();
                action1.perform();
                Thread.sleep(1000);
            }
        }
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

    // 检查当前页面最上层的activity是否在指定packageName
    public static boolean checkPackage(String packageName) throws IOException, MyException {
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
//                throw new MyException("");
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
}

